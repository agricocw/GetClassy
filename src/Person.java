import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Overloaded Constructor for testing purposes
    public Person(String firstName, String lastName, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = "";
        this.title = "";
        this.YOB = YOB;
    }
