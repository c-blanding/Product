import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");



        boolean done = false;

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;

        do {

            ID = SafeInput.getNonZeroLenString(sc, "Enter the ID [6 Digits]");
            name = SafeInput.getNonZeroLenString(sc, "Enter the name of the product");
            description = SafeInput.getNonZeroLenString(sc, "Enter the description of the product");
            cost = SafeInput.getRangedDouble(sc, "Enter the cost of the product ", 100, 9999);

            String personRec = ID + ", " + name + ", " + description + ", " + cost;
            products.add(new Product(name, description, ID, cost));

            done = SafeInput.getYNConfirm(sc, "Are you done?");
        } while (!done);

        for( Product p: products)
            System.out.println(p.toCSVDataRecord());



        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product rec : products)
            {
                writer.write(rec.toCSVDataRecord(), 0, rec.toCSVDataRecord().length());
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}