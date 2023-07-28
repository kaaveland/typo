/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object CountryregioncurrencyRepoImpl extends CountryregioncurrencyRepo {
  override def delete(compositeId: CountryregioncurrencyId): ConnectionIO[Boolean] = {
    sql"delete from sales.countryregioncurrency where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}".update.run.map(_ > 0)
  }
  override def insert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    sql"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (${unsaved.countryregioncode}, ${unsaved.currencycode}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning countryregioncode, currencycode, modifieddate
       """.query[CountryregioncurrencyRow].unique
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved): ConnectionIO[CountryregioncurrencyRow] = {
    val fs = List(
      Some((Fragment.const(s"countryregioncode"), fr"${unsaved.countryregioncode}")),
      Some((Fragment.const(s"currencycode"), fr"${unsaved.currencycode}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.countryregioncurrency default values
            returning countryregioncode, currencycode, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.countryregioncurrency(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning countryregioncode, currencycode, modifieddate
         """
    }
    q.query[CountryregioncurrencyRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, CountryregioncurrencyRow] = {
    sql"select countryregioncode, currencycode, modifieddate from sales.countryregioncurrency".query[CountryregioncurrencyRow].stream
  }
  override def selectById(compositeId: CountryregioncurrencyId): ConnectionIO[Option[CountryregioncurrencyRow]] = {
    sql"select countryregioncode, currencycode, modifieddate from sales.countryregioncurrency where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}".query[CountryregioncurrencyRow].option
  }
  override def update(row: CountryregioncurrencyRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.countryregioncurrency
          set modifieddate = ${row.modifieddate}::timestamp
          where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    sql"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (
            ${unsaved.countryregioncode},
            ${unsaved.currencycode}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (countryregioncode, currencycode)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning countryregioncode, currencycode, modifieddate
       """.query[CountryregioncurrencyRow].unique
  }
}
