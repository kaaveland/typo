package typo
package metadb
import typo.generated.information_schema.{KeyColumnUsageRow, ReferentialConstraintsRow, TableConstraintsRow}

class ForeignKeys(
    tableConstraints: List[TableConstraintsRow],
    keyColumnUsage: List[KeyColumnUsageRow],
    referentialConstraints: List[ReferentialConstraintsRow]
) {
  lazy val fks: List[TableConstraintsRow] = tableConstraints.filter(_.constraintType.contains("FOREIGN KEY"))

  lazy val getAsMap: Map[db.RelationName, List[db.ForeignKey]] = {
    fks
      .map { fk =>
        (
          db.RelationName(fk.tableSchema.get, fk.tableName.get),
          getReferringColumns(fk),
          getReferredTable(fk),
          getReferredColumns(fk),
          db.RelationName(fk.constraintSchema.get, fk.constraintName.get)
        )
      }
      .collect { case (tableName, referringColumns, Some(referredTable), referredColumns, constraintName) =>
        tableName -> db.ForeignKey(referringColumns, referredTable, referredColumns, constraintName)
      }
      .groupMap(_._1)(_._2)
  }

  private def getReferringColumns(fk: TableConstraintsRow): List[db.ColName] = {
    val kcus =
      keyColumnUsage.filter { kcu =>
        fk.constraintCatalog == kcu.constraintCatalog &&
        fk.constraintSchema == kcu.constraintSchema &&
        fk.constraintName == kcu.constraintName
      }

    kcus
      .sortBy(_.ordinalPosition)
      .map(kcu => db.ColName(kcu.columnName.get))
  }

  private def getReferredTable(fk: TableConstraintsRow): Option[db.RelationName] = {
    referentialConstraints
      .find { rc =>
        fk.constraintCatalog == rc.constraintCatalog &&
        fk.constraintSchema == rc.constraintSchema &&
        fk.constraintName == rc.constraintName
      }
      .flatMap { rc =>
        tableConstraints.find { tc =>
          tc.constraintCatalog == rc.uniqueConstraintCatalog &&
          tc.constraintSchema == rc.uniqueConstraintSchema &&
          tc.constraintName == rc.uniqueConstraintName
        }
      }
      .map { tc =>
        db.RelationName(tc.tableSchema.get, tc.tableName.get)
      }
  }

  private def getReferredColumns(fk: TableConstraintsRow): List[db.ColName] = {
    referentialConstraints
      .filter { rc =>
        fk.constraintCatalog == rc.constraintCatalog &&
        fk.constraintSchema == rc.constraintSchema &&
        fk.constraintName == rc.constraintName
      }
      .flatMap { rc =>
        keyColumnUsage
          .filter { kcu =>
            kcu.constraintCatalog == rc.uniqueConstraintCatalog &&
            kcu.constraintSchema == rc.uniqueConstraintSchema &&
            kcu.constraintName == rc.uniqueConstraintName
          }
          .sortBy(_.ordinalPosition)
          .map(kcu => db.ColName(kcu.columnName.get))
      }
  }

}
