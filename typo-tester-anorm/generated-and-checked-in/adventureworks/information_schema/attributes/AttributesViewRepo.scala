/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package attributes

import java.sql.Connection
import typo.dsl.SelectBuilder

trait AttributesViewRepo {
  def select: SelectBuilder[AttributesViewFields, AttributesViewRow]
  def selectAll(implicit c: Connection): List[AttributesViewRow]
}