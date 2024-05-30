/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `humanresources.jobcandidate` */
case class JobcandidateId(value: Int) extends AnyVal
object JobcandidateId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[JobcandidateId]] = adventureworks.IntArrayDecoder.map(_.map(JobcandidateId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[JobcandidateId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[JobcandidateId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[JobcandidateId, Int] = Bijection[JobcandidateId, Int](_.value)(JobcandidateId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[JobcandidateId] = JdbcDecoder.intDecoder.map(JobcandidateId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[JobcandidateId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[JobcandidateId] = JsonDecoder.int.map(JobcandidateId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[JobcandidateId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[JobcandidateId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[JobcandidateId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[JobcandidateId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[JobcandidateId] = new Text[JobcandidateId] {
    override def unsafeEncode(v: JobcandidateId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: JobcandidateId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
