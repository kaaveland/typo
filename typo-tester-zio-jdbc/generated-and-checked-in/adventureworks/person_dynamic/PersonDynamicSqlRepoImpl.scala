/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_dynamic

import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PersonDynamicSqlRepoImpl extends PersonDynamicSqlRepo {
  override def apply(firstName: Option[String]): ZStream[ZConnection, Throwable, PersonDynamicSqlRow] = {
    val sql =
      sql"""SELECT p.title, p.firstname, p.middlename, p.lastname
            FROM person.person p
            WHERE ${Segment.paramSegment(firstName)(Setter.optionParamSetter(Setter.stringSetter))}::text IS NULL OR p.firstname = ${Segment.paramSegment(firstName)(Setter.optionParamSetter(Setter.stringSetter))}
      """
    sql.query(PersonDynamicSqlRow.jdbcDecoder).selectStream
  }
}
