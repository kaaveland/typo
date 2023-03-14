package typo

trait DbLib {
  def repoSig(repoMethod: RepoMethod): sc.Code
  def repoImpl(table: TableComputed, default: DefaultComputed, repoMethod: RepoMethod): sc.Code
  def stringEnumInstances(wrapperType: sc.Type, underlying: sc.Type, lookup: sc.Ident): List[sc.Code]
  def instances(tpe: sc.Type, scalaFields: Seq[(sc.Ident, sc.Type, db.Col)]): List[sc.Code]
  def anyValInstances(wrapperType: sc.Type.Qualified, underlying: sc.Type): List[sc.Code]
}
