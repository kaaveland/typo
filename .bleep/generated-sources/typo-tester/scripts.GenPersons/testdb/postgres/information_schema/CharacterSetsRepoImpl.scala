/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object CharacterSetsRepoImpl extends CharacterSetsRepo {
  override def selectAll(implicit c: Connection): List[CharacterSetsRow] = {
    SQL"""select character_set_catalog, character_set_schema, character_set_name, character_repertoire, form_of_use, default_collate_catalog, default_collate_schema, default_collate_name from information_schema.character_sets""".as(CharacterSetsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CharacterSetsFieldValue[_]])(implicit c: Connection): List[CharacterSetsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CharacterSetsFieldValue.characterSetCatalog(value) => NamedParameter("character_set_catalog", ParameterValue.from(value))
          case CharacterSetsFieldValue.characterSetSchema(value) => NamedParameter("character_set_schema", ParameterValue.from(value))
          case CharacterSetsFieldValue.characterSetName(value) => NamedParameter("character_set_name", ParameterValue.from(value))
          case CharacterSetsFieldValue.characterRepertoire(value) => NamedParameter("character_repertoire", ParameterValue.from(value))
          case CharacterSetsFieldValue.formOfUse(value) => NamedParameter("form_of_use", ParameterValue.from(value))
          case CharacterSetsFieldValue.defaultCollateCatalog(value) => NamedParameter("default_collate_catalog", ParameterValue.from(value))
          case CharacterSetsFieldValue.defaultCollateSchema(value) => NamedParameter("default_collate_schema", ParameterValue.from(value))
          case CharacterSetsFieldValue.defaultCollateName(value) => NamedParameter("default_collate_name", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.character_sets where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(CharacterSetsRow.rowParser.*)
    }

  }
}
