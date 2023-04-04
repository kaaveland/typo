package typo
package internal
package codegen

case class SqlScriptFiles(script: SqlScriptComputed, naming: Naming, options: InternalOptions) {
  val relation = RelationFiles(naming, script.relation, options)
  val all: List[sc.File] = List(
    relation.RowFile,
    relation.RepoTraitFile(script.repoMethods),
    relation.RepoImplFile(script.repoMethods)
  )
}