/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object AddresstypeRepoImpl extends AddresstypeRepo {
  override def delete(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean = {
    SQL"delete from person.addresstype where addresstypeid = $addresstypeid".executeUpdate() > 0
  }
  override def insert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype(addresstypeid, "name", rowguid, modifieddate)
          values (${unsaved.addresstypeid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning addresstypeid, "name", rowguid, modifieddate
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
  
  }
  override def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.addresstypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("addresstypeid", ParameterValue.from[AddresstypeId](value)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.addresstype default values
            returning addresstypeid, "name", rowguid, modifieddate
         """
        .executeInsert(AddresstypeRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.addresstype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning addresstypeid, "name", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(AddresstypeRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[AddresstypeRow] = {
    SQL"""select addresstypeid, "name", rowguid, modifieddate
          from person.addresstype
       """.as(AddresstypeRow.rowParser(1).*)
  }
  override def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow] = {
    SQL"""select addresstypeid, "name", rowguid, modifieddate
          from person.addresstype
          where addresstypeid = $addresstypeid
       """.as(AddresstypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow] = {
    implicit val toStatement: ToStatement[Array[AddresstypeId]] =
      (s: PreparedStatement, index: Int, v: Array[AddresstypeId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select addresstypeid, "name", rowguid, modifieddate
          from person.addresstype
          where addresstypeid = ANY($addresstypeids)
       """.as(AddresstypeRow.rowParser(1).*)
  
  }
  override def update(row: AddresstypeRow)(implicit c: Connection): Boolean = {
    val addresstypeid = row.addresstypeid
    SQL"""update person.addresstype
          set "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where addresstypeid = $addresstypeid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype(addresstypeid, "name", rowguid, modifieddate)
          values (
            ${unsaved.addresstypeid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (addresstypeid)
          do update set
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning addresstypeid, "name", rowguid, modifieddate
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
  
  }
}
