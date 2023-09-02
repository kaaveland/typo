package scripts

import typo.*

import java.nio.file.Path
import java.sql.{Connection, DriverManager}
import java.util

object GeneratedSources {
  def main(args: Array[String]): Unit = {
    implicit val c: Connection = {
      val url = "jdbc:postgresql://localhost:6432/postgres"
      val props = new util.Properties
      props.setProperty("user", "postgres")
      props.setProperty("password", "password")
      props.setProperty("port", "6432")
      DriverManager.getConnection(url, props)
    }

    val header =
      """|/**
         | * File has been automatically generated by `typo` for internal use.
         | *
         | * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
         | *
         | * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
         | */
         |""".stripMargin

    val buildDir = Path.of(sys.props("user.dir"))
    val typoSources = buildDir.resolve("typo/generated-and-checked-in")

    val files = generateFromDb(
      Options(
        pkg = "typo.generated",
        jsonLibs = List(JsonLibName.PlayJson),
        dbLib = Some(DbLibName.Anorm),
        fileHeader = header,
        debugTypes = true
      ),
      Selector.relationNames(
        "columns",
        "key_column_usage",
        "pg_namespace",
        "referential_constraints",
        "table_constraints",
        "tables",
        "foo",
        "pg_prepared_statements"
      ),
      List(buildDir.resolve("sql"))
    )

    files.overwriteFolder(typoSources)

    import scala.sys.process.*
    List("git", "add", "-f", typoSources.toString).!!
    ()
  }
}
