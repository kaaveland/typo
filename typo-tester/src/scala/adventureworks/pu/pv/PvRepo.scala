/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import java.sql.Connection

trait PvRepo {
  def selectAll(implicit c: Connection): List[PvRow]
  def selectByFieldValues(fieldValues: List[PvFieldOrIdValue[_]])(implicit c: Connection): List[PvRow]
}