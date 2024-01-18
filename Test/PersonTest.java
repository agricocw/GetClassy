import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testFullName() {
        Person person = new Person("John", "Doe", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    void testFormalName() {
        Person person = new Person("John", "Doe", "123456", "Mr.", 1980);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        // Assuming the current year is 2023
        int currentYear = 2023;

        // Creating a Person instance with a year of birth (YOB) of 1979
        Person person = new Person("John", "Doe", 1979);

        // Calculating the expected age based on the current year
        int expectedAge = currentYear - person.getYOB();

        // Getting the actual age from the Person instance
        String actualAge = person.getAge(currentYear);

        // Asserting that the actual age matches the expected age
        assertEquals("Age: " + expectedAge, actualAge);
    }

    @Test
    void testGetAgeWithSpecificYear() {
        Person person = new Person("John", "Doe", 1980);
        assertEquals("Age: 30", person.getAge(2010));
    }

    @Test
    void testToCSVDataRecord() {
        Person person = new Person("John", "Doe", "123456", "Mr.", 1980);
        assertEquals("123456, John, Doe, Mr., 1980", person.toCSVDataRecord());
    }

    @Test
    void testConstructorWithID() {
        Person person = new Person("John", "Doe", "123456", "Mr.", 1980);
        assertEquals("123456", person.getID());
    }

    @Test
    void testSetAndGetID() {
        Person person = new Person("John", "Doe", 1980);
        person.setID("654321");
        assertEquals("654321", person.getID());
    }

    @Test
    void testSetAndGetTitle() {
        Person person = new Person("John", "Doe", 1980);
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle());
    }

    @Test
    void testInvalidYearOfBirth() {
        try {
            new Person("John", "Doe", "123456", "Mr.", 2025);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        };
    }

