/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.TimeStamp
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class TriggersViewStructure[Row](val prefix: Option[String], val extract: Row => TriggersViewRow, val merge: (Row, TriggersViewRow) => Row)
  extends Relation[TriggersViewFields, TriggersViewRow, Row]
    with TriggersViewFields[Row] { outer =>

  override val triggerCatalog = new Field[SqlIdentifier, Row](prefix, "trigger_catalog", None, Some("name"))(x => extract(x).triggerCatalog, (row, value) => merge(row, extract(row).copy(triggerCatalog = value)))
  override val triggerSchema = new Field[SqlIdentifier, Row](prefix, "trigger_schema", None, Some("name"))(x => extract(x).triggerSchema, (row, value) => merge(row, extract(row).copy(triggerSchema = value)))
  override val triggerName = new Field[SqlIdentifier, Row](prefix, "trigger_name", None, Some("name"))(x => extract(x).triggerName, (row, value) => merge(row, extract(row).copy(triggerName = value)))
  override val eventManipulation = new Field[CharacterData, Row](prefix, "event_manipulation", None, Some("varchar"))(x => extract(x).eventManipulation, (row, value) => merge(row, extract(row).copy(eventManipulation = value)))
  override val eventObjectCatalog = new Field[SqlIdentifier, Row](prefix, "event_object_catalog", None, Some("name"))(x => extract(x).eventObjectCatalog, (row, value) => merge(row, extract(row).copy(eventObjectCatalog = value)))
  override val eventObjectSchema = new Field[SqlIdentifier, Row](prefix, "event_object_schema", None, Some("name"))(x => extract(x).eventObjectSchema, (row, value) => merge(row, extract(row).copy(eventObjectSchema = value)))
  override val eventObjectTable = new Field[SqlIdentifier, Row](prefix, "event_object_table", None, Some("name"))(x => extract(x).eventObjectTable, (row, value) => merge(row, extract(row).copy(eventObjectTable = value)))
  override val actionOrder = new Field[CardinalNumber, Row](prefix, "action_order", None, Some("int4"))(x => extract(x).actionOrder, (row, value) => merge(row, extract(row).copy(actionOrder = value)))
  override val actionCondition = new Field[CharacterData, Row](prefix, "action_condition", None, Some("varchar"))(x => extract(x).actionCondition, (row, value) => merge(row, extract(row).copy(actionCondition = value)))
  override val actionStatement = new Field[CharacterData, Row](prefix, "action_statement", None, Some("varchar"))(x => extract(x).actionStatement, (row, value) => merge(row, extract(row).copy(actionStatement = value)))
  override val actionOrientation = new Field[CharacterData, Row](prefix, "action_orientation", None, Some("varchar"))(x => extract(x).actionOrientation, (row, value) => merge(row, extract(row).copy(actionOrientation = value)))
  override val actionTiming = new Field[CharacterData, Row](prefix, "action_timing", None, Some("varchar"))(x => extract(x).actionTiming, (row, value) => merge(row, extract(row).copy(actionTiming = value)))
  override val actionReferenceOldTable = new Field[SqlIdentifier, Row](prefix, "action_reference_old_table", None, Some("name"))(x => extract(x).actionReferenceOldTable, (row, value) => merge(row, extract(row).copy(actionReferenceOldTable = value)))
  override val actionReferenceNewTable = new Field[SqlIdentifier, Row](prefix, "action_reference_new_table", None, Some("name"))(x => extract(x).actionReferenceNewTable, (row, value) => merge(row, extract(row).copy(actionReferenceNewTable = value)))
  override val actionReferenceOldRow = new Field[SqlIdentifier, Row](prefix, "action_reference_old_row", None, Some("name"))(x => extract(x).actionReferenceOldRow, (row, value) => merge(row, extract(row).copy(actionReferenceOldRow = value)))
  override val actionReferenceNewRow = new Field[SqlIdentifier, Row](prefix, "action_reference_new_row", None, Some("name"))(x => extract(x).actionReferenceNewRow, (row, value) => merge(row, extract(row).copy(actionReferenceNewRow = value)))
  override val created = new Field[TimeStamp, Row](prefix, "created", None, Some("timestamptz"))(x => extract(x).created, (row, value) => merge(row, extract(row).copy(created = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](triggerCatalog, triggerSchema, triggerName, eventManipulation, eventObjectCatalog, eventObjectSchema, eventObjectTable, actionOrder, actionCondition, actionStatement, actionOrientation, actionTiming, actionReferenceOldTable, actionReferenceNewTable, actionReferenceOldRow, actionReferenceNewRow, created)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => TriggersViewRow, merge: (NewRow, TriggersViewRow) => NewRow): TriggersViewStructure[NewRow] =
    new TriggersViewStructure(prefix, extract, merge)
}
