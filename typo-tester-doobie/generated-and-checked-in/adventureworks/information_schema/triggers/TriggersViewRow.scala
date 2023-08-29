/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import adventureworks.customtypes.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class TriggersViewRow(
  triggerCatalog: /* nullability unknown */ Option[String],
  triggerSchema: /* nullability unknown */ Option[String],
  triggerName: /* nullability unknown */ Option[String],
  eventManipulation: /* nullability unknown */ Option[String],
  eventObjectCatalog: /* nullability unknown */ Option[String],
  eventObjectSchema: /* nullability unknown */ Option[String],
  eventObjectTable: /* nullability unknown */ Option[String],
  actionOrder: /* nullability unknown */ Option[Int],
  actionCondition: /* nullability unknown */ Option[String],
  actionStatement: /* nullability unknown */ Option[String],
  actionOrientation: /* nullability unknown */ Option[String],
  actionTiming: /* nullability unknown */ Option[String],
  actionReferenceOldTable: /* nullability unknown */ Option[String],
  actionReferenceNewTable: /* nullability unknown */ Option[String],
  actionReferenceOldRow: /* nullability unknown */ Option[String],
  actionReferenceNewRow: /* nullability unknown */ Option[String],
  created: /* nullability unknown */ Option[TypoOffsetDateTime]
)

object TriggersViewRow {
  implicit lazy val decoder: Decoder[TriggersViewRow] = Decoder.forProduct17[TriggersViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoOffsetDateTime]]("trigger_catalog", "trigger_schema", "trigger_name", "event_manipulation", "event_object_catalog", "event_object_schema", "event_object_table", "action_order", "action_condition", "action_statement", "action_orientation", "action_timing", "action_reference_old_table", "action_reference_new_table", "action_reference_old_row", "action_reference_new_row", "created")(TriggersViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit lazy val encoder: Encoder[TriggersViewRow] = Encoder.forProduct17[TriggersViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoOffsetDateTime]]("trigger_catalog", "trigger_schema", "trigger_name", "event_manipulation", "event_object_catalog", "event_object_schema", "event_object_table", "action_order", "action_condition", "action_statement", "action_orientation", "action_timing", "action_reference_old_table", "action_reference_new_table", "action_reference_old_row", "action_reference_new_row", "created")(x => (x.triggerCatalog, x.triggerSchema, x.triggerName, x.eventManipulation, x.eventObjectCatalog, x.eventObjectSchema, x.eventObjectTable, x.actionOrder, x.actionCondition, x.actionStatement, x.actionOrientation, x.actionTiming, x.actionReferenceOldTable, x.actionReferenceNewTable, x.actionReferenceOldRow, x.actionReferenceNewRow, x.created))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit lazy val read: Read[TriggersViewRow] = new Read[TriggersViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TriggersViewRow(
      triggerCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      triggerSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      triggerName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      eventManipulation = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      eventObjectCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      eventObjectSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      eventObjectTable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      actionOrder = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      actionCondition = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      actionStatement = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      actionOrientation = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
      actionTiming = Meta.StringMeta.get.unsafeGetNullable(rs, i + 11),
      actionReferenceOldTable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 12),
      actionReferenceNewTable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 13),
      actionReferenceOldRow = Meta.StringMeta.get.unsafeGetNullable(rs, i + 14),
      actionReferenceNewRow = Meta.StringMeta.get.unsafeGetNullable(rs, i + 15),
      created = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 16)
    )
  )
}
