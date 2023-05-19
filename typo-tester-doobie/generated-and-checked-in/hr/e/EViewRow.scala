/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

case class EViewRow(
  id: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employee.EmployeeRow.nationalidnumber]] */
  nationalidnumber: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.loginid]] */
  loginid: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.birthdate]] */
  birthdate: Option[LocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.maritalstatus]] */
  maritalstatus: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.gender]] */
  gender: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.hiredate]] */
  hiredate: Option[LocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.salariedflag]] */
  salariedflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.vacationhours]] */
  vacationhours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.sickleavehours]] */
  sickleavehours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.currentflag]] */
  currentflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[humanresources.employee.EmployeeRow.modifieddate]] */
  modifieddate: Option[LocalDateTime],
  /** Points to [[humanresources.employee.EmployeeRow.organizationnode]] */
  organizationnode: Option[String]
)

object EViewRow {
  implicit val decoder: Decoder[EViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        nationalidnumber <- c.downField("nationalidnumber").as[Option[String]]
        loginid <- c.downField("loginid").as[Option[String]]
        jobtitle <- c.downField("jobtitle").as[Option[String]]
        birthdate <- c.downField("birthdate").as[Option[LocalDate]]
        maritalstatus <- c.downField("maritalstatus").as[Option[/* bpchar */ String]]
        gender <- c.downField("gender").as[Option[/* bpchar */ String]]
        hiredate <- c.downField("hiredate").as[Option[LocalDate]]
        salariedflag <- c.downField("salariedflag").as[Flag]
        vacationhours <- c.downField("vacationhours").as[Option[Int]]
        sickleavehours <- c.downField("sickleavehours").as[Option[Int]]
        currentflag <- c.downField("currentflag").as[Flag]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
        organizationnode <- c.downField("organizationnode").as[Option[String]]
      } yield EViewRow(id, businessentityid, nationalidnumber, loginid, jobtitle, birthdate, maritalstatus, gender, hiredate, salariedflag, vacationhours, sickleavehours, currentflag, rowguid, modifieddate, organizationnode)
  implicit val encoder: Encoder[EViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "businessentityid" := row.businessentityid,
        "nationalidnumber" := row.nationalidnumber,
        "loginid" := row.loginid,
        "jobtitle" := row.jobtitle,
        "birthdate" := row.birthdate,
        "maritalstatus" := row.maritalstatus,
        "gender" := row.gender,
        "hiredate" := row.hiredate,
        "salariedflag" := row.salariedflag,
        "vacationhours" := row.vacationhours,
        "sickleavehours" := row.sickleavehours,
        "currentflag" := row.currentflag,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate,
        "organizationnode" := row.organizationnode
      )}
}
