/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait VjobcandidateeducationViewRepo {
  def select: SelectBuilder[VjobcandidateeducationViewFields, VjobcandidateeducationViewRow]
  def selectAll: ZStream[ZConnection, Throwable, VjobcandidateeducationViewRow]
}
