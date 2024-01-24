import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();

        do {
            Product product = getProductData(scanner);
            productList.add(product);
        } while (SafeInput.getYNConfirm(scanner, "Do you want to enter another product?"));

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save the data");

        saveDataToFile(productList, fileName);

        System.out.println("Data saved successfully!");
    }

    private static Product getProductData(Scanner scanner) {
        String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
        String name = SafeInput.getNonZeroLenString(scanner, "Enter Name");
        String description = SafeInput.getNonZeroLenString(scanner, "Enter Description");
        double cost = SafeInput.getDouble(scanner, "Enter Cost");

        return new Product(name, description, id, cost);
    }

    private static void saveDataToFile(ArrayList<Product> data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : data) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
