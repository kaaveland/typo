/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: person.addresstype
    Types of addresses stored in the Address table.
    Primary key: addresstypeid */
case class AddresstypeRow(
  /** Primary key for AddressType records.
      Default: nextval('person.addresstype_addresstypeid_seq'::regclass) */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object AddresstypeRow {
  implicit lazy val decoder: Decoder[AddresstypeRow] = Decoder.forProduct4[AddresstypeRow, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("addresstypeid", "name", "rowguid", "modifieddate")(AddresstypeRow.apply)(AddresstypeId.decoder, Name.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[AddresstypeRow] = Encoder.forProduct4[AddresstypeRow, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("addresstypeid", "name", "rowguid", "modifieddate")(x => (x.addresstypeid, x.name, x.rowguid, x.modifieddate))(AddresstypeId.encoder, Name.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[AddresstypeRow] = new Read[AddresstypeRow](
    gets = List(
      (AddresstypeId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => AddresstypeRow(
      addresstypeid = AddresstypeId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
  implicit lazy val text: Text[AddresstypeRow] = Text.instance[AddresstypeRow]{ (row, sb) =>
    AddresstypeId.text.unsafeEncode(row.addresstypeid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
