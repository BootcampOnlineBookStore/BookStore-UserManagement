package com.capgemini.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 * Class: LDTConverter
 * Description: the class is used for converting dates to specific forms
 * @author SAISHIVA
 * CreatedOn 2020-10-07
 */
@Converter(autoApply=true)
public class LDTConverter implements AttributeConverter<LocalDate,Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate ldt) {
		if(ldt!=null)
			return java.sql.Date.valueOf(ldt);//
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqldt) {
		if(sqldt!=null)
			return sqldt.toLocalDate();
		return null;
	}

}
