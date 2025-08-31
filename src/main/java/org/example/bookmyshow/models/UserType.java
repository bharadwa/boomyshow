package org.example.bookmyshow.models;

public enum UserType {

    ADMIN,
    CUSTOMER;
    public static  UserType fromString(String value) {
        for (UserType userType : UserType.values()) {
            if (userType.name().equalsIgnoreCase(value)) {
                return userType;
            }
        }
        return null;
    }
}
