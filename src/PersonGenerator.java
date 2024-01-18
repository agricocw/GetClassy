import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> personList = new ArrayList<>();

        do {
            Person person = getPersonData(scanner);
            personList.add(person);
        } while (SafeInput.getYNConfirm(scanner, "Do you want to enter another person?"));

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save the data");

        saveDataToFile(personList, fileName);

        System.out.println("Data saved successfully!");
    }

    public static Person getPersonData(Scanner scanner) {
        String id = SafeInput.getRegExString(scanner, "Enter ID (6 digits)", "\\d{6}");
        String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
        String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
        String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
        int yearOfBirth = SafeInput.getRangedInt(scanner, "Enter Year of Birth (1940-2000)", 1940, 2000);

        return new Person(firstName, lastName, id, title, yearOfBirth);
    }

    public static void saveDataToFile(ArrayList<Person> data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : data) {
                writer.write(person.toCSVDataRecord());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}