/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgBackendMemoryContextsViewRow(
  name: /* nullability unknown */ Option[String],
  ident: /* nullability unknown */ Option[String],
  parent: /* nullability unknown */ Option[String],
  level: /* nullability unknown */ Option[Int],
  totalBytes: /* nullability unknown */ Option[Long],
  totalNblocks: /* nullability unknown */ Option[Long],
  freeBytes: /* nullability unknown */ Option[Long],
  freeChunks: /* nullability unknown */ Option[Long],
  usedBytes: /* nullability unknown */ Option[Long]
)

object PgBackendMemoryContextsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgBackendMemoryContextsViewRow] = new JdbcDecoder[PgBackendMemoryContextsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgBackendMemoryContextsViewRow) =
      columIndex + 8 ->
        PgBackendMemoryContextsViewRow(
          name = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          ident = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          parent = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          level = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 3, rs)._2,
          totalBytes = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 4, rs)._2,
          totalNblocks = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 5, rs)._2,
          freeBytes = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 6, rs)._2,
          freeChunks = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 7, rs)._2,
          usedBytes = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgBackendMemoryContextsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val ident = jsonObj.get("ident").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val parent = jsonObj.get("parent").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val level = jsonObj.get("level").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val totalBytes = jsonObj.get("total_bytes").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val totalNblocks = jsonObj.get("total_nblocks").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val freeBytes = jsonObj.get("free_bytes").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val freeChunks = jsonObj.get("free_chunks").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val usedBytes = jsonObj.get("used_bytes").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    if (name.isRight && ident.isRight && parent.isRight && level.isRight && totalBytes.isRight && totalNblocks.isRight && freeBytes.isRight && freeChunks.isRight && usedBytes.isRight)
      Right(PgBackendMemoryContextsViewRow(name = name.toOption.get, ident = ident.toOption.get, parent = parent.toOption.get, level = level.toOption.get, totalBytes = totalBytes.toOption.get, totalNblocks = totalNblocks.toOption.get, freeBytes = freeBytes.toOption.get, freeChunks = freeChunks.toOption.get, usedBytes = usedBytes.toOption.get))
    else Left(List[Either[String, Any]](name, ident, parent, level, totalBytes, totalNblocks, freeBytes, freeChunks, usedBytes).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgBackendMemoryContextsViewRow] = new JsonEncoder[PgBackendMemoryContextsViewRow] {
    override def unsafeEncode(a: PgBackendMemoryContextsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""ident":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.ident, indent, out)
      out.write(",")
      out.write(""""parent":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.parent, indent, out)
      out.write(",")
      out.write(""""level":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.level, indent, out)
      out.write(",")
      out.write(""""total_bytes":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.totalBytes, indent, out)
      out.write(",")
      out.write(""""total_nblocks":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.totalNblocks, indent, out)
      out.write(",")
      out.write(""""free_bytes":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.freeBytes, indent, out)
      out.write(",")
      out.write(""""free_chunks":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.freeChunks, indent, out)
      out.write(",")
      out.write(""""used_bytes":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.usedBytes, indent, out)
      out.write("}")
    }
  }
}
