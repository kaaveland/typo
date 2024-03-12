package typo
package internal
package codegen

import typo.internal.codegen.DbLib.RowType

case class FilesView(view: ComputedView, options: InternalOptions) {
  val relation = FilesRelation(view.naming, view.names, Some(view.cols), options)
  val all: List[sc.File] = List(
    relation.RowFile(RowType.Readable),
    relation.FieldsFile,
    for {
      dbLib <- options.dbLib
    } yield relation.RepoTraitFile(dbLib, view.repoMethods),
    for {
      dbLib <- options.dbLib
    } yield relation.RepoImplFile(dbLib, view.repoMethods),
    relation.FieldValueFile
  ).flatten
}
