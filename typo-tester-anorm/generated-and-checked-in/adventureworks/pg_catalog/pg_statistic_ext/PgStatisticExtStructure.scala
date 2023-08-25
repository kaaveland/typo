/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatisticExtStructure[Row](val prefix: Option[String], val extract: Row => PgStatisticExtRow, val merge: (Row, PgStatisticExtRow) => Row)
  extends Relation[PgStatisticExtFields, PgStatisticExtRow, Row]
    with PgStatisticExtFields[Row] { outer =>

  override val oid = new IdField[PgStatisticExtId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val stxrelid = new Field[/* oid */ Long, Row](prefix, "stxrelid", None, Some("oid"))(x => extract(x).stxrelid, (row, value) => merge(row, extract(row).copy(stxrelid = value)))
  override val stxname = new Field[String, Row](prefix, "stxname", None, Some("name"))(x => extract(x).stxname, (row, value) => merge(row, extract(row).copy(stxname = value)))
  override val stxnamespace = new Field[/* oid */ Long, Row](prefix, "stxnamespace", None, Some("oid"))(x => extract(x).stxnamespace, (row, value) => merge(row, extract(row).copy(stxnamespace = value)))
  override val stxowner = new Field[/* oid */ Long, Row](prefix, "stxowner", None, Some("oid"))(x => extract(x).stxowner, (row, value) => merge(row, extract(row).copy(stxowner = value)))
  override val stxstattarget = new Field[Int, Row](prefix, "stxstattarget", None, Some("int4"))(x => extract(x).stxstattarget, (row, value) => merge(row, extract(row).copy(stxstattarget = value)))
  override val stxkeys = new Field[TypoInt2Vector, Row](prefix, "stxkeys", None, Some("int2vector"))(x => extract(x).stxkeys, (row, value) => merge(row, extract(row).copy(stxkeys = value)))
  override val stxkind = new Field[Array[String], Row](prefix, "stxkind", None, Some("_char"))(x => extract(x).stxkind, (row, value) => merge(row, extract(row).copy(stxkind = value)))
  override val stxexprs = new OptField[TypoPgNodeTree, Row](prefix, "stxexprs", None, Some("pg_node_tree"))(x => extract(x).stxexprs, (row, value) => merge(row, extract(row).copy(stxexprs = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatisticExtRow, merge: (NewRow, PgStatisticExtRow) => NewRow): PgStatisticExtStructure[NewRow] =
    new PgStatisticExtStructure(prefix, extract, merge)
}