/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import testdb.hardcoded.Defaulted

object PersonRepoImpl extends PersonRepo {
  override def delete(compositeId: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from compositepk.person where "one" = ${compositeId.one} AND two = ${compositeId.two}""".executeUpdate() > 0
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into compositepk.person("one", two, "name")
          values (${unsaved.one}::int8, ${unsaved.two}, ${unsaved.name})
          returning "one", two, "name"
       """
      .executeInsert(PersonRow.rowParser(1).single)
  
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), "")),
      unsaved.one match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("one", ParameterValue.from[Long](value)), "::int8"))
      },
      unsaved.two match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("two", ParameterValue.from[Option[String]](value)), ""))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into compositepk.person default values
            returning "one", two, "name"
         """
        .executeInsert(PersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into compositepk.person(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "one", two, "name"
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PersonRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "one", two, "name"
          from compositepk.person
       """.as(PersonRow.rowParser(1).*)
  }
  override def selectById(compositeId: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "one", two, "name"
          from compositepk.person
          where "one" = ${compositeId.one} AND two = ${compositeId.two}
       """.as(PersonRow.rowParser(1).singleOpt)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update compositepk.person
          set "name" = ${row.name}
          where "one" = ${compositeId.one} AND two = ${compositeId.two}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into compositepk.person("one", two, "name")
          values (
            ${unsaved.one}::int8,
            ${unsaved.two},
            ${unsaved.name}
          )
          on conflict ("one", two)
          do update set
            "name" = EXCLUDED."name"
          returning "one", two, "name"
       """
      .executeInsert(PersonRow.rowParser(1).single)
  
  }
}
