/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import adventureworks.customtypes.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VjobcandidateeducationViewFields {
  def jobcandidateid: Field[JobcandidateId, VjobcandidateeducationViewRow]
  def EduLevel: OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow]
  def EduStartDate: OptField[TypoLocalDate, VjobcandidateeducationViewRow]
  def EduEndDate: OptField[TypoLocalDate, VjobcandidateeducationViewRow]
  def EduDegree: OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow]
  def EduMajor: OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow]
  def EduMinor: OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow]
  def EduGPA: OptField[/* max 5 chars */ String, VjobcandidateeducationViewRow]
  def EduGPAScale: OptField[/* max 5 chars */ String, VjobcandidateeducationViewRow]
  def EduSchool: OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow]
  def EduLocCountryRegion: OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow]
  def EduLocState: OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow]
  def EduLocCity: OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow]
}

object VjobcandidateeducationViewFields {
  lazy val structure: Relation[VjobcandidateeducationViewFields, VjobcandidateeducationViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[VjobcandidateeducationViewFields, VjobcandidateeducationViewRow] {
  
    override lazy val fields: VjobcandidateeducationViewFields = new VjobcandidateeducationViewFields {
      override def jobcandidateid = Field[JobcandidateId, VjobcandidateeducationViewRow](_path, "jobcandidateid", None, None, x => x.jobcandidateid, (row, value) => row.copy(jobcandidateid = value))
      override def EduLevel = OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Level", None, None, x => x.EduLevel, (row, value) => row.copy(EduLevel = value))
      override def EduStartDate = OptField[TypoLocalDate, VjobcandidateeducationViewRow](_path, "Edu.StartDate", Some("text"), None, x => x.EduStartDate, (row, value) => row.copy(EduStartDate = value))
      override def EduEndDate = OptField[TypoLocalDate, VjobcandidateeducationViewRow](_path, "Edu.EndDate", Some("text"), None, x => x.EduEndDate, (row, value) => row.copy(EduEndDate = value))
      override def EduDegree = OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Degree", None, None, x => x.EduDegree, (row, value) => row.copy(EduDegree = value))
      override def EduMajor = OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Major", None, None, x => x.EduMajor, (row, value) => row.copy(EduMajor = value))
      override def EduMinor = OptField[/* max 50 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Minor", None, None, x => x.EduMinor, (row, value) => row.copy(EduMinor = value))
      override def EduGPA = OptField[/* max 5 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.GPA", None, None, x => x.EduGPA, (row, value) => row.copy(EduGPA = value))
      override def EduGPAScale = OptField[/* max 5 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.GPAScale", None, None, x => x.EduGPAScale, (row, value) => row.copy(EduGPAScale = value))
      override def EduSchool = OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.School", None, None, x => x.EduSchool, (row, value) => row.copy(EduSchool = value))
      override def EduLocCountryRegion = OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Loc.CountryRegion", None, None, x => x.EduLocCountryRegion, (row, value) => row.copy(EduLocCountryRegion = value))
      override def EduLocState = OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Loc.State", None, None, x => x.EduLocState, (row, value) => row.copy(EduLocState = value))
      override def EduLocCity = OptField[/* max 100 chars */ String, VjobcandidateeducationViewRow](_path, "Edu.Loc.City", None, None, x => x.EduLocCity, (row, value) => row.copy(EduLocCity = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VjobcandidateeducationViewRow]] =
      List[FieldLikeNoHkt[?, VjobcandidateeducationViewRow]](fields.jobcandidateid, fields.EduLevel, fields.EduStartDate, fields.EduEndDate, fields.EduDegree, fields.EduMajor, fields.EduMinor, fields.EduGPA, fields.EduGPAScale, fields.EduSchool, fields.EduLocCountryRegion, fields.EduLocState, fields.EduLocCity)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
