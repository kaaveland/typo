/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VpersondemographicsViewRepo {
  def select: SelectBuilder[VpersondemographicsViewFields, VpersondemographicsViewRow]
  def selectAll(implicit c: Connection): List[VpersondemographicsViewRow]
}