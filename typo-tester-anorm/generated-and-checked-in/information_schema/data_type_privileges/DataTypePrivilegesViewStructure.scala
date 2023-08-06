/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class DataTypePrivilegesViewStructure[Row](val prefix: Option[String], val extract: Row => DataTypePrivilegesViewRow, val merge: (Row, DataTypePrivilegesViewRow) => Row)
  extends Relation[DataTypePrivilegesViewFields, DataTypePrivilegesViewRow, Row]
    with DataTypePrivilegesViewFields[Row] { outer =>

  override val objectCatalog = new OptField[SqlIdentifier, Row](prefix, "object_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).objectCatalog, (row, value) => merge(row, extract(row).copy(objectCatalog = value)))
  override val objectSchema = new OptField[SqlIdentifier, Row](prefix, "object_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).objectSchema, (row, value) => merge(row, extract(row).copy(objectSchema = value)))
  override val objectName = new OptField[SqlIdentifier, Row](prefix, "object_name", None, Some("information_schema.sql_identifier"))(x => extract(x).objectName, (row, value) => merge(row, extract(row).copy(objectName = value)))
  override val objectType = new OptField[CharacterData, Row](prefix, "object_type", None, Some("information_schema.character_data"))(x => extract(x).objectType, (row, value) => merge(row, extract(row).copy(objectType = value)))
  override val dtdIdentifier = new OptField[SqlIdentifier, Row](prefix, "dtd_identifier", None, Some("information_schema.sql_identifier"))(x => extract(x).dtdIdentifier, (row, value) => merge(row, extract(row).copy(dtdIdentifier = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](objectCatalog, objectSchema, objectName, objectType, dtdIdentifier)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => DataTypePrivilegesViewRow, merge: (NewRow, DataTypePrivilegesViewRow) => NewRow): DataTypePrivilegesViewStructure[NewRow] =
    new DataTypePrivilegesViewStructure(prefix, extract, merge)
}