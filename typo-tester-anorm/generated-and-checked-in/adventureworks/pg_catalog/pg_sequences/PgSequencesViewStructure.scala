/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequences

import adventureworks.customtypes.TypoRegtype
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgSequencesViewStructure[Row](val prefix: Option[String], val extract: Row => PgSequencesViewRow, val merge: (Row, PgSequencesViewRow) => Row)
  extends Relation[PgSequencesViewFields, PgSequencesViewRow, Row]
    with PgSequencesViewFields[Row] { outer =>

  override val schemaname = new Field[String, Row](prefix, "schemaname", None, None)(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val sequencename = new Field[String, Row](prefix, "sequencename", None, None)(x => extract(x).sequencename, (row, value) => merge(row, extract(row).copy(sequencename = value)))
  override val sequenceowner = new OptField[String, Row](prefix, "sequenceowner", None, None)(x => extract(x).sequenceowner, (row, value) => merge(row, extract(row).copy(sequenceowner = value)))
  override val dataType = new OptField[TypoRegtype, Row](prefix, "data_type", None, None)(x => extract(x).dataType, (row, value) => merge(row, extract(row).copy(dataType = value)))
  override val startValue = new Field[Long, Row](prefix, "start_value", None, None)(x => extract(x).startValue, (row, value) => merge(row, extract(row).copy(startValue = value)))
  override val minValue = new Field[Long, Row](prefix, "min_value", None, None)(x => extract(x).minValue, (row, value) => merge(row, extract(row).copy(minValue = value)))
  override val maxValue = new Field[Long, Row](prefix, "max_value", None, None)(x => extract(x).maxValue, (row, value) => merge(row, extract(row).copy(maxValue = value)))
  override val incrementBy = new Field[Long, Row](prefix, "increment_by", None, None)(x => extract(x).incrementBy, (row, value) => merge(row, extract(row).copy(incrementBy = value)))
  override val cycle = new Field[Boolean, Row](prefix, "cycle", None, None)(x => extract(x).cycle, (row, value) => merge(row, extract(row).copy(cycle = value)))
  override val cacheSize = new Field[Long, Row](prefix, "cache_size", None, None)(x => extract(x).cacheSize, (row, value) => merge(row, extract(row).copy(cacheSize = value)))
  override val lastValue = new OptField[Long, Row](prefix, "last_value", None, None)(x => extract(x).lastValue, (row, value) => merge(row, extract(row).copy(lastValue = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, sequencename, sequenceowner, dataType, startValue, minValue, maxValue, incrementBy, cycle, cacheSize, lastValue)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgSequencesViewRow, merge: (NewRow, PgSequencesViewRow) => NewRow): PgSequencesViewStructure[NewRow] =
    new PgSequencesViewStructure(prefix, extract, merge)
}
