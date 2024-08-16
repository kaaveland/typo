/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title_domain

import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: public.title_domain
    Primary key: code */
case class TitleDomainRow(
  code: TitleDomainId
){
   val id = code
 }

object TitleDomainRow {
  implicit lazy val decoder: Decoder[TitleDomainRow] = Decoder.forProduct1[TitleDomainRow, TitleDomainId]("code")(TitleDomainRow.apply)(TitleDomainId.decoder)
  implicit lazy val encoder: Encoder[TitleDomainRow] = Encoder.forProduct1[TitleDomainRow, TitleDomainId]("code")(x => (x.code))(TitleDomainId.encoder)
  implicit lazy val read: Read[TitleDomainRow] = new Read[TitleDomainRow](
    gets = List(
      (TitleDomainId.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TitleDomainRow(
      code = TitleDomainId.get.unsafeGetNonNullable(rs, i + 0)
    )
  )
  implicit lazy val text: Text[TitleDomainRow] = Text.instance[TitleDomainRow]{ (row, sb) =>
    TitleDomainId.text.unsafeEncode(row.code, sb)
  }
  implicit lazy val write: Write[TitleDomainRow] = new Write[TitleDomainRow](
    puts = List((TitleDomainId.put, Nullability.NoNulls)),
    toList = x => List(x.code),
    unsafeSet = (rs, i, a) => {
                  TitleDomainId.put.unsafeSetNonNullable(rs, i + 0, a.code)
                },
    unsafeUpdate = (ps, i, a) => {
                     TitleDomainId.put.unsafeUpdateNonNullable(ps, i + 0, a.code)
                   }
  )
}
