/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_user_mappings`

import adventureworks.pg_catalog.pg_user_mapping.PgUserMappingId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgUserMappingsViewStructure[Row](val prefix: Option[String], val extract: Row => PgUserMappingsViewRow, val merge: (Row, PgUserMappingsViewRow) => Row)
  extends Relation[PgUserMappingsViewFields, PgUserMappingsViewRow, Row]
    with PgUserMappingsViewFields[Row] { outer =>

  override val oid = new Field[PgUserMappingId, Row](prefix, "oid", None, None)(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val umoptions = new OptField[Array[String], Row](prefix, "umoptions", None, None)(x => extract(x).umoptions, (row, value) => merge(row, extract(row).copy(umoptions = value)))
  override val umuser = new Field[/* oid */ Long, Row](prefix, "umuser", None, None)(x => extract(x).umuser, (row, value) => merge(row, extract(row).copy(umuser = value)))
  override val authorizationIdentifier = new OptField[String, Row](prefix, "authorization_identifier", None, None)(x => extract(x).authorizationIdentifier, (row, value) => merge(row, extract(row).copy(authorizationIdentifier = value)))
  override val foreignServerCatalog = new OptField[/* nullability unknown */ String, Row](prefix, "foreign_server_catalog", None, None)(x => extract(x).foreignServerCatalog, (row, value) => merge(row, extract(row).copy(foreignServerCatalog = value)))
  override val foreignServerName = new OptField[/* nullability unknown */ String, Row](prefix, "foreign_server_name", None, None)(x => extract(x).foreignServerName, (row, value) => merge(row, extract(row).copy(foreignServerName = value)))
  override val srvowner = new OptField[/* nullability unknown */ String, Row](prefix, "srvowner", None, None)(x => extract(x).srvowner, (row, value) => merge(row, extract(row).copy(srvowner = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, umoptions, umuser, authorizationIdentifier, foreignServerCatalog, foreignServerName, srvowner)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgUserMappingsViewRow, merge: (NewRow, PgUserMappingsViewRow) => NewRow): PgUserMappingsViewStructure[NewRow] =
    new PgUserMappingsViewStructure(prefix, extract, merge)
}
