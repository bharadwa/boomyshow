package org.example.bookmyshow.models;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FormatTypeListConvertor implements AttributeConverter<List<FormatType>,String> {

    private static final String SEPARATOR = ",";
    @Override
    public String convertToDatabaseColumn(List<FormatType> formatTypeList) {
        if(formatTypeList==null || formatTypeList.isEmpty()) return "";
        return formatTypeList.stream().map(Enum::name).collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<FormatType> convertToEntityAttribute(String data) {
          if(data==null || data.isEmpty()) return Collections.EMPTY_LIST;
          return Arrays.stream(data.split(SEPARATOR)).map(s -> FormatType.valueOf(s)).collect(Collectors.toList());
    }
}
