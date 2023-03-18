package scripts

import bleep._
import bleep.logging.Logger
import typo._

import java.sql.DriverManager
import java.util

object GenPersons extends BleepCodegenScript("GenPersons") {
  val enums = List(
    db.StringEnum(db.RelationName("myschema", "sector"), List("PUBLIC", "PRIVATE", "OTHER"))
  )

  val person = db.Table(
    name = db.RelationName("myschema", "person"),
    cols = List(
      db.Col(db.ColName("id"), db.Type.BigInt, isNotNull = true, hasDefault = true),
      db.Col(db.ColName("favourite_football_club_id"), db.Type.VarChar(Some(50)), isNotNull = true, hasDefault = false),
      db.Col(db.ColName("name"), db.Type.VarChar(Some(100)), isNotNull = true, hasDefault = false),
      db.Col(db.ColName("nick_name"), db.Type.VarChar(Some(30)), isNotNull = false, hasDefault = false),
      db.Col(db.ColName("blog_url"), db.Type.VarChar(Some(100)), isNotNull = false, hasDefault = false),
      db.Col(db.ColName("email"), db.Type.VarChar(Some(254)), isNotNull = true, hasDefault = false),
      db.Col(db.ColName("phone"), db.Type.VarChar(Some(8)), isNotNull = true, hasDefault = false),
      db.Col(db.ColName("likes_pizza"), db.Type.Boolean, isNotNull = true, hasDefault = false),
      db.Col(db.ColName("marital_status_id"), db.Type.VarChar(Some(50)), isNotNull = true, hasDefault = true),
      db.Col(db.ColName("work_email"), db.Type.VarChar(Some(254)), isNotNull = false, hasDefault = false),
      db.Col(
        db.ColName("sector"),
        db.Type.StringEnum(db.RelationName("myschema", "sector")),
        isNotNull = true,
        hasDefault = true
      )
    ),
    Some(db.PrimaryKey(List(db.ColName("id")))),
    Nil,
    List(
      db.ForeignKey(db.ColName("favourite_football_club_id"), db.RelationName("myschema", "football_club"), db.ColName("id")),
      db.ForeignKey(db.ColName("marital_status_id"), db.RelationName("myschema", "marital_status"), db.ColName("id"))
    )
  )
  val football_club = db.Table(
    name = db.RelationName("myschema", "football_club"),
    cols = List(
      db.Col(db.ColName("id"), db.Type.BigInt, isNotNull = true, hasDefault = false),
      db.Col(db.ColName("name"), db.Type.VarChar(Some(100)), isNotNull = true, hasDefault = false)
    ),
    Some(db.PrimaryKey(List(db.ColName("id")))),
    Nil,
    Nil
  )
  val marital_status = db.Table(
    name = db.RelationName("myschema", "marital_status"),
    cols = List(
      db.Col(db.ColName("id"), db.Type.BigInt, isNotNull = true, hasDefault = false)
    ),
    Some(db.PrimaryKey(List(db.ColName("id")))),
    Nil,
    Nil
  )

  val cpk_person = db.Table(
    name = db.RelationName("compositepk", "person"), // name clash to ensure we handle it
    cols = List(
      db.Col(db.ColName("one"), db.Type.BigInt, isNotNull = true, hasDefault = true),
      db.Col(db.ColName("two"), db.Type.Text, isNotNull = false, hasDefault = true),
      db.Col(db.ColName("name"), db.Type.Text, isNotNull = false, hasDefault = false)
    ),
    Some(db.PrimaryKey(List(db.ColName("one"), db.ColName("two")))),
    Nil,
    Nil
  )
  val cpk_bike = db.Table(
    name = db.RelationName("compositepk", "bike"),
    cols = List(
      db.Col(db.ColName("id"), db.Type.BigInt, isNotNull = true, hasDefault = true),
      db.Col(db.ColName("owner_one"), db.Type.BigInt, isNotNull = true, hasDefault = false),
      db.Col(db.ColName("owner_two"), db.Type.Text, isNotNull = false, hasDefault = false),
      db.Col(db.ColName("bike_name"), db.Type.Text, isNotNull = true, hasDefault = false)
    ),
    Some(db.PrimaryKey(List(db.ColName("id")))),
    Nil,
    Nil
  )

  val all = List(person, football_club, marital_status, cpk_person)

  override def run(started: Started, commands: Commands, targets: List[Target], args: List[String]): Unit = {
    val c = {
      val url = "jdbc:postgresql://localhost/postgres"
      val props = new util.Properties
      props.setProperty("user", "postgres")
      props.setProperty("password", "postgres")
      DriverManager.getConnection(url, props)
    }

    val files1: Map[RelPath, String] =
      Gen(sc.QIdent(List(sc.Ident("testdb"), sc.Ident("hardcoded"))), all, enums, views = Nil, JsonLibPlay, DbLibAnorm).map {
        case sc.File(sc.Type.Qualified(sc.QIdent(path :+ name)), content) =>
          val relpath = RelPath(path.map(_.value) :+ (name.value + ".scala"))
          relpath -> content.render
      }.toMap

    val files2: Map[RelPath, String] =
      Gen(sc.QIdent(List(sc.Ident("testdb"), sc.Ident("postgres"))), JsonLibPlay, DbLibAnorm, c).map { case sc.File(sc.Type.Qualified(sc.QIdent(path :+ name)), content) =>
        val relpath = RelPath(path.map(_.value) :+ (name.value + ".scala"))
        relpath -> content.render
      }.toMap

    targets.foreach { target =>
      FileSync
        .syncStrings(
          target.sources,
          files1 ++ files2,
          deleteUnknowns = FileSync.DeleteUnknowns.Yes(maxDepth = None),
          soft = false // todo: bleep should use something better than timestamps
        )
      cli("add to git", target.sources, List("git", "add", "-f", target.sources.toString), Logger.DevNull, cli.Out.Raw)
    }
  }
}
