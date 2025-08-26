package org.example.bookmyshow.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class LanguageTypeListConverter implements AttributeConverter<List<LanguageType>, String> {
    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<LanguageType> attribute) {
        if (attribute == null || attribute.isEmpty()) return "";
        return attribute.stream().map(n -> n.name()).collect(Collectors.joining(SPLIT_CHAR));
    }

    @Override
    public List<LanguageType> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return Collections.emptyList();
        return Arrays.stream(dbData.split(SPLIT_CHAR))
                .map(s->LanguageType.valueOf(s))
                .collect(Collectors.toList());
    }
}

