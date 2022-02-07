
/**
 * Program to perform CRUD (Create, Read, Update, Destroy) operations on excel/csv files
 *
 * @authors Sparkling Barracudas
 */

import java.io.*;
import java.util.*;

public class Crud {

    private static Crud firstInstance = null;

    // Constuctor for crud
    private Crud() {
    }

    /**
     * Creates new instance of Crud and if there is already an instance
     * running, will not do anything
     * 
     * @return returns the instance that's running or creates a new one
     */
    public static Crud getInstance() {
        if (firstInstance == null) {
            firstInstance = new Crud();
        }

        return firstInstance;
    }

    /**
 * Method to create new entry on CSV file.
 * Gets user input and adds data to new line.
 * @throws IOException 
 */
    public void create() throws IOException{
     //Asking for user input   
     Scanner data = new Scanner(System.in);
     System.out.println("Enter Product ID : ");
     String productID = data.nextLine();
     
     System.out.println("Enter Quantity : ");
     int quantity = data.nextInt();
     
     System.out.println("Enter Wholesale Cost : ");
     double wholesaleCost = data.nextDouble();
     data.nextLine();
     
     System.out.println("Enter Sale Price : ");
     double salePrice = data.nextDouble();
     data.nextLine();
     
     System.out.println("Enter Supplier ID : ");
     String supplierID = data.nextLine();
     
     String combinedStrings = productID + "," + quantity + "," + wholesaleCost
             + "," + salePrice + "," + supplierID;
     //Writing to a new line at the end of the CSV file
     try {
     
         FileWriter csvFile = new FileWriter(
                 "C:\\Users\\Nathan\\Documents\\School\\SWDev\\"
                         + "inventory_team3.csv", true);
     
         csvFile.append(combinedStrings);
         csvFile.append("\n");
         csvFile.close();
     }
     catch (Exception e) {
         
     }
    }
    /**
     * Method to read an individual line from the CSV file
     * Gets user input for product ID and prints entire line containing 
     * that product ID
     * @return used to break out of the method after entry is found
     * @throws IOException 
     */
    public List<String[]> read() throws IOException {
        //Creating arrayList to store data from CSV file
       ArrayList<String> arrayList = new ArrayList<>();
       
       Scanner sc = new Scanner(System.in);
       //User input for Product ID
       System.out.println("Enter the Product ID for the item : ");
       String productID = sc.nextLine();
       //reading lines from file into an array list
       try (BufferedReader reader = new BufferedReader(new FileReader(
               "C:\\Users\\Nathan\\Documents\\School\\SWDev\\"
                + "inventory_team3.csv"))) {
            while (reader.ready()) {
                arrayList.add(reader.readLine());
            }
        }
        catch (IOException e) {
        // Handle a potential exception
        }
       //searching through arrayList to find matching product ID
       for (String line : arrayList) {
            if (line.contains(productID)){
                System.out.println(line);
                return null; // breaks out of method once product ID is printed
            }
        }
       System.out.println("Entry not found.");
       return null; //breaks out of method if product ID is not found
    }

    public void update() {
    }

    public void delete() {
    }

}