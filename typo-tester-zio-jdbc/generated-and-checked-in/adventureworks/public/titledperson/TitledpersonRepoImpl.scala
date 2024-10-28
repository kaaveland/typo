/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package titledperson

import adventureworks.public.title.TitleId
import adventureworks.public.title_domain.TitleDomainId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class TitledpersonRepoImpl extends TitledpersonRepo {
  override def delete: DeleteBuilder[TitledpersonFields, TitledpersonRow] = {
    DeleteBuilder(""""public"."titledperson"""", TitledpersonFields.structure)
  }
  override def insert(unsaved: TitledpersonRow): ZIO[ZConnection, Throwable, TitledpersonRow] = {
    sql"""insert into "public"."titledperson"("title_short", "title", "name")
          values (${Segment.paramSegment(unsaved.titleShort)(TitleDomainId.setter)}::text, ${Segment.paramSegment(unsaved.title)(TitleId.setter)}, ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)})
          returning "title_short", "title", "name"
       """.insertReturning(using TitledpersonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TitledpersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "public"."titledperson"("title_short", "title", "name") FROM STDIN""", batchSize, unsaved)(TitledpersonRow.text)
  }
  override def select: SelectBuilder[TitledpersonFields, TitledpersonRow] = {
    SelectBuilderSql(""""public"."titledperson"""", TitledpersonFields.structure, TitledpersonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TitledpersonRow] = {
    sql"""select "title_short", "title", "name" from "public"."titledperson"""".query(using TitledpersonRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[TitledpersonFields, TitledpersonRow] = {
    UpdateBuilder(""""public"."titledperson"""", TitledpersonFields.structure, TitledpersonRow.jdbcDecoder)
  }
}