package core.models;

import lombok.Getter;

@Getter
//@NoArgsConstructor
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

    public SignUp() {
//        this.emailAddress = setEmailAddress();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.additionalInformation = additionalInformation;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public void setEmailAddress() {
        this.emailAddress = emailAddress;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public void setPassword() {
        this.password = password;
    }

    public void setCompany() {
        this.company = company;
    }

    public void setAddressLine1() {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2() {
        this.addressLine2 = addressLine2;
    }

    public void setCity() {
        this.city = city;
    }

    public void setState() {
        this.state = state;
    }

    public void setPostalCode() {
        this.postalCode = postalCode;
    }

    public void setCountry() {
        this.country = country;
    }

    public void setAdditionalInformation() {
        this.additionalInformation = additionalInformation;
    }

    public void setHomePhone() {
        this.homePhone = homePhone;
    }

    public void setMobilePhone() {
        this.mobilePhone = mobilePhone;
    }

    public void setAddressAlias() {
        this.addressAlias = addressAlias;
    }
}
