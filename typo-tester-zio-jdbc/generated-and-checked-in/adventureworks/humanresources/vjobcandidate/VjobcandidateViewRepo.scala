/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait VjobcandidateViewRepo {
  def select: SelectBuilder[VjobcandidateViewFields, VjobcandidateViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VjobcandidateViewRow]
}