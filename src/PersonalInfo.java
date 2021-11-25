import java.io.Serializable;

public abstract class PersonalInfo implements Serializable {
    static final long serialVersionUID = 42L;

    protected String firstName;
    protected String lastName;
    protected String phoneNr;

    public PersonalInfo(String firstName, String lastName, String phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }
}


