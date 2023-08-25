/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_column_grants

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.Field

trait RoleColumnGrantsViewFields[Row] {
  val grantor: Field[SqlIdentifier, Row]
  val grantee: Field[SqlIdentifier, Row]
  val tableCatalog: Field[SqlIdentifier, Row]
  val tableSchema: Field[SqlIdentifier, Row]
  val tableName: Field[SqlIdentifier, Row]
  val columnName: Field[SqlIdentifier, Row]
  val privilegeType: Field[CharacterData, Row]
  val isGrantable: Field[YesOrNo, Row]
}
object RoleColumnGrantsViewFields extends RoleColumnGrantsViewStructure[RoleColumnGrantsViewRow](None, identity, (_, x) => x)

