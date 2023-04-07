package typo

/** Here you can override the type of a column. You specify either a fully qualified type name or something which is in scope, either by default in scala or is
  * exposed in a super package of the generated code.
  *
  * Note that you cannot override `Array` or `Option`.
  */
trait TypeOverride {

  /** @param from
    *   inside the ADT you can find the name of the relation or the location of the sql script
    * @param colName
    *   name of column
    * @return
    */
  def apply(from: OverrideFrom, colName: db.ColName): Option[String]
}

object TypeOverride {
  val Empty: TypeOverride = (_, _) => None

  def of(pf: PartialFunction[(OverrideFrom, db.ColName), String]): TypeOverride =
    (from, colName) => pf.lift((from, colName))

  def relation(pf: PartialFunction[(String, String), String]): TypeOverride =
    (from, colName) => {
      from match {
        case rel: OverrideFrom.Relation => pf.lift((rel.name.value, colName.value))
        case _                          => None
      }
    }
}
