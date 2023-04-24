/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import org.postgresql.jdbc.PgSQLXML

object IllustrationRepoImpl extends IllustrationRepo {
  override def delete(illustrationid: IllustrationId)(implicit c: Connection): Boolean = {
    SQL"delete from production.illustration where illustrationid = $illustrationid".executeUpdate() > 0
  }
  override def insert(unsaved: IllustrationRowUnsaved)(implicit c: Connection): IllustrationRow = {
    val namedParameters = List(
      Some((NamedParameter("diagram", ParameterValue.from(unsaved.diagram)), "::xml")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.illustration default values
            returning illustrationid, diagram, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.illustration(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning illustrationid, diagram, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[IllustrationRow] = {
    SQL"""select illustrationid, diagram, modifieddate
          from production.illustration
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[IllustrationFieldOrIdValue[_]])(implicit c: Connection): List[IllustrationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case IllustrationFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case IllustrationFieldValue.diagram(value) => NamedParameter("diagram", ParameterValue.from(value))
          case IllustrationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select illustrationid, diagram, modifieddate
                    from production.illustration
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(illustrationid: IllustrationId)(implicit c: Connection): Option[IllustrationRow] = {
    SQL"""select illustrationid, diagram, modifieddate
          from production.illustration
          where illustrationid = $illustrationid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(illustrationids: Array[IllustrationId])(implicit c: Connection): List[IllustrationRow] = {
    implicit val toStatement: ToStatement[Array[IllustrationId]] =
      (s: PreparedStatement, index: Int, v: Array[IllustrationId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select illustrationid, diagram, modifieddate
          from production.illustration
          where illustrationid = ANY($illustrationids)
       """.as(rowParser.*)
  
  }
  override def update(row: IllustrationRow)(implicit c: Connection): Boolean = {
    val illustrationid = row.illustrationid
    SQL"""update production.illustration
          set diagram = ${row.diagram}::xml,
              modifieddate = ${row.modifieddate}::timestamp
          where illustrationid = $illustrationid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(illustrationid: IllustrationId, fieldValues: List[IllustrationFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case IllustrationFieldValue.diagram(value) => NamedParameter("diagram", ParameterValue.from(value))
          case IllustrationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.illustration
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where illustrationid = {illustrationid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("illustrationid", ParameterValue.from(illustrationid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[IllustrationRow] =
    RowParser[IllustrationRow] { row =>
      Success(
        IllustrationRow(
          illustrationid = row[IllustrationId]("illustrationid"),
          diagram = row[Option[PgSQLXML]]("diagram"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
