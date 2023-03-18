package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgShmemAllocationsRepoImpl extends PgShmemAllocationsRepo {
  override def selectAll(implicit c: Connection): List[PgShmemAllocationsRow] = {
    SQL"""select name, off, size, allocated_size from pg_catalog.pg_shmem_allocations""".as(PgShmemAllocationsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgShmemAllocationsFieldValue[_]])(implicit c: Connection): List[PgShmemAllocationsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgShmemAllocationsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgShmemAllocationsFieldValue.off(value) => NamedParameter("off", ParameterValue.from(value))
          case PgShmemAllocationsFieldValue.size(value) => NamedParameter("size", ParameterValue.from(value))
          case PgShmemAllocationsFieldValue.allocatedSize(value) => NamedParameter("allocated_size", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_shmem_allocations where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgShmemAllocationsRow.rowParser.*)
    }

  }
}