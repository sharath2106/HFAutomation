package core.models;

public class Login {
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Login() {
    }

    public Login(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String emailAddress;

    private String password;

}
