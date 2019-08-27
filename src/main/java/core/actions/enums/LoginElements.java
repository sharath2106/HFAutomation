package core.actions.enums;

import lombok.Getter;

@Getter
public enum LoginElements {

    LOGIN("Login"),
    EMAIL_ADDRESS("Email address"),
    PASSWORD("Password"),
    SUBMIT("Submit"),
    MY_ACCOUNT("MY ACCOUNT"),
    WELCOME_TO_MY_ACCOUNT("Welcome to your account.");

    private String value;

    LoginElements(String value) {
        this.value = value;
    }
}
