package core.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUp {

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;

}
