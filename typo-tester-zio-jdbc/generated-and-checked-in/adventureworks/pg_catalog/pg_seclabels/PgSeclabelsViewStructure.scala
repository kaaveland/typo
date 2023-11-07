/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabels

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgSeclabelsViewStructure[Row](val prefix: Option[String], val extract: Row => PgSeclabelsViewRow, val merge: (Row, PgSeclabelsViewRow) => Row)
  extends Relation[PgSeclabelsViewFields, PgSeclabelsViewRow, Row]
    with PgSeclabelsViewFields[Row] { outer =>

  override val objoid = new OptField[/* oid */ Long, Row](prefix, "objoid", None, None)(x => extract(x).objoid, (row, value) => merge(row, extract(row).copy(objoid = value)))
  override val classoid = new OptField[/* oid */ Long, Row](prefix, "classoid", None, None)(x => extract(x).classoid, (row, value) => merge(row, extract(row).copy(classoid = value)))
  override val objsubid = new OptField[Int, Row](prefix, "objsubid", None, None)(x => extract(x).objsubid, (row, value) => merge(row, extract(row).copy(objsubid = value)))
  override val objtype = new OptField[String, Row](prefix, "objtype", None, None)(x => extract(x).objtype, (row, value) => merge(row, extract(row).copy(objtype = value)))
  override val objnamespace = new OptField[/* oid */ Long, Row](prefix, "objnamespace", None, None)(x => extract(x).objnamespace, (row, value) => merge(row, extract(row).copy(objnamespace = value)))
  override val objname = new OptField[String, Row](prefix, "objname", None, None)(x => extract(x).objname, (row, value) => merge(row, extract(row).copy(objname = value)))
  override val provider = new OptField[String, Row](prefix, "provider", None, None)(x => extract(x).provider, (row, value) => merge(row, extract(row).copy(provider = value)))
  override val label = new OptField[String, Row](prefix, "label", None, None)(x => extract(x).label, (row, value) => merge(row, extract(row).copy(label = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](objoid, classoid, objsubid, objtype, objnamespace, objname, provider, label)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgSeclabelsViewRow, merge: (NewRow, PgSeclabelsViewRow) => NewRow): PgSeclabelsViewStructure[NewRow] =
    new PgSeclabelsViewStructure(prefix, extract, merge)
}
