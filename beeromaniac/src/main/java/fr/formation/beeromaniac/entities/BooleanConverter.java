package fr.formation.beeromaniac.entities;

import javax.persistence.AttributeConverter;

public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
	return Boolean.TRUE.equals(value) ? "true" : "false";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
	return "true".equals(value);
    }

}
