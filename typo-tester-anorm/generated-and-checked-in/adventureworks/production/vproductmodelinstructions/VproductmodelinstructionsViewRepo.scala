/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VproductmodelinstructionsViewRepo {
  def select: SelectBuilder[VproductmodelinstructionsViewFields, VproductmodelinstructionsViewRow]
  def selectAll(implicit c: Connection): List[VproductmodelinstructionsViewRow]
}