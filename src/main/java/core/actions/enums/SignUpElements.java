package core.actions.enums;

import lombok.Getter;

@Getter
public enum SignUpElements {

    NEW_ACCOUNT_FORM("New account creation form"),
    GENDER("Gender"),
    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    COMPANY("Company"),
    ADDRESS_LINE_1("Address line 1"),
    ADDRESS_LINE_2("Address line 2"),
    CITY("City"),
    STATE("State"),
    POSTAL_CODE("Postal code"),
    DAYS("days"),
    MONTHS("months"),
    YEARS("years"),
    ADDITIONAL_INFORMATION("Additional information"),
    HOME_PHONE("Home phone"),
    MOBILE_PHONE("Mobile phone"),
    ADDRESS_ALIAS("Address alias");


    private String value;

    SignUpElements(String value) {
        this.value = value;
    }
}
