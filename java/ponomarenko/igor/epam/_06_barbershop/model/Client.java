package ponomarenko.igor.epam._06_barbershop.model;

/**
 * Created by Igor on 14.06.2016.
 */
public class Client  {
    private String firstName = "";
    private String lastName = "";

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
