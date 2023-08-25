/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sequences

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class SequencesViewStructure[Row](val prefix: Option[String], val extract: Row => SequencesViewRow, val merge: (Row, SequencesViewRow) => Row)
  extends Relation[SequencesViewFields, SequencesViewRow, Row]
    with SequencesViewFields[Row] { outer =>

  override val sequenceCatalog = new Field[SqlIdentifier, Row](prefix, "sequence_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).sequenceCatalog, (row, value) => merge(row, extract(row).copy(sequenceCatalog = value)))
  override val sequenceSchema = new Field[SqlIdentifier, Row](prefix, "sequence_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).sequenceSchema, (row, value) => merge(row, extract(row).copy(sequenceSchema = value)))
  override val sequenceName = new Field[SqlIdentifier, Row](prefix, "sequence_name", None, Some("information_schema.sql_identifier"))(x => extract(x).sequenceName, (row, value) => merge(row, extract(row).copy(sequenceName = value)))
  override val dataType = new Field[CharacterData, Row](prefix, "data_type", None, Some("information_schema.character_data"))(x => extract(x).dataType, (row, value) => merge(row, extract(row).copy(dataType = value)))
  override val numericPrecision = new Field[CardinalNumber, Row](prefix, "numeric_precision", None, Some("information_schema.cardinal_number"))(x => extract(x).numericPrecision, (row, value) => merge(row, extract(row).copy(numericPrecision = value)))
  override val numericPrecisionRadix = new Field[CardinalNumber, Row](prefix, "numeric_precision_radix", None, Some("information_schema.cardinal_number"))(x => extract(x).numericPrecisionRadix, (row, value) => merge(row, extract(row).copy(numericPrecisionRadix = value)))
  override val numericScale = new Field[CardinalNumber, Row](prefix, "numeric_scale", None, Some("information_schema.cardinal_number"))(x => extract(x).numericScale, (row, value) => merge(row, extract(row).copy(numericScale = value)))
  override val startValue = new Field[CharacterData, Row](prefix, "start_value", None, Some("information_schema.character_data"))(x => extract(x).startValue, (row, value) => merge(row, extract(row).copy(startValue = value)))
  override val minimumValue = new Field[CharacterData, Row](prefix, "minimum_value", None, Some("information_schema.character_data"))(x => extract(x).minimumValue, (row, value) => merge(row, extract(row).copy(minimumValue = value)))
  override val maximumValue = new Field[CharacterData, Row](prefix, "maximum_value", None, Some("information_schema.character_data"))(x => extract(x).maximumValue, (row, value) => merge(row, extract(row).copy(maximumValue = value)))
  override val increment = new Field[CharacterData, Row](prefix, "increment", None, Some("information_schema.character_data"))(x => extract(x).increment, (row, value) => merge(row, extract(row).copy(increment = value)))
  override val cycleOption = new Field[YesOrNo, Row](prefix, "cycle_option", None, Some("information_schema.yes_or_no"))(x => extract(x).cycleOption, (row, value) => merge(row, extract(row).copy(cycleOption = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](sequenceCatalog, sequenceSchema, sequenceName, dataType, numericPrecision, numericPrecisionRadix, numericScale, startValue, minimumValue, maximumValue, increment, cycleOption)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SequencesViewRow, merge: (NewRow, SequencesViewRow) => NewRow): SequencesViewStructure[NewRow] =
    new SequencesViewStructure(prefix, extract, merge)
}
