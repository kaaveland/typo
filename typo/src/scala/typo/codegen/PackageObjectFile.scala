package typo
package codegen

import typo.sc.syntax._

object PackageObjectFile {
  def packageObject(options: Options): sc.File = {
    val parentPkg = options.pkg.idents.dropRight(1)
    val content =
      code"""|package ${parentPkg.map(_.code).mkCode(".")}
             |
             |package object ${options.pkg.name} {
             |  ${options.dbLib.missingInstances.mkCode("\n  ")}
             |  ${options.jsonLib.missingInstances.mkCode("\n  ")}
             |  implicit val pgObjectOrdering: ${sc.Type.Ordering.of(sc.Type.PGobject)} =
             |    ${sc.Type.Ordering}.by(x => (x.getType, x.getValue))
             |}
             |""".stripMargin

    sc.File(sc.Type.Qualified(options.pkg / sc.Ident("package")), content)
  }

}