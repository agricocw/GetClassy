import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            try {
                displayProductFile(selectedFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void displayProductFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("ID      Name                          Description                  Cost");
            System.out.println("=======================================================================");


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",\\s*|\\s{2,}");

                if (parts.length >= 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String description = parts[2];
                    String cost = parts[3];

                    System.out.printf("%-8s%-30s%-30s%-10s%n", id, name, description, cost);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        }
    }
}