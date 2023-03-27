import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class FileHandler {

  public static ArrayList<item> Products = new ArrayList<item>();

  public static void readCSV() {
      try {
          File csvObj = new File("C:\\Users\\Jamie\\IdeaProjects\\eBay Manager\\src\\ProductList.csv");
          BufferedReader br = new BufferedReader(new FileReader(csvObj));
          String line;
          while ((line = br.readLine()) != null) {
              String[] values = line.split(",");
              item csvProduct = new item(values[0], Float.parseFloat(values[1]), Integer.parseInt(values[2]), values[3], Double.parseDouble(values[4]));
              Products.add(csvProduct);
          }
          br.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }


  public static ArrayList<item> getList() {
    return Products;
  }

  public static void clearProductList() {
    Products.clear();
  }

  public static void addItem() {
    Scanner UserInput = new Scanner(System.in);
    System.out.println("Insert Item name");
    String fieldItemName = UserInput.nextLine();

    System.out.println("Insert Price");
    float fieldPrice = Float.parseFloat(UserInput.nextLine());

    System.out.println("Insert how much of the item is in stock");
    int fieldStockNum = Integer.parseInt(UserInput.nextLine());

    System.out.println("Insert the item's category");
    String fieldItemType = UserInput.nextLine();

    System.out.println("Insert the item's ID");
    int fieldItemID = Integer.parseInt(UserInput.nextLine());

    
    item addedProduct = new item(fieldItemName, fieldPrice, fieldStockNum, fieldItemType, fieldItemID);
    Products.add(addedProduct);
    // write the object into the CSV file here
  }

  public static void displayProducts() {
    System.out.println("");
    System.out.println("The currently stored products:");
    System.out.println("Item Name, Price, Stock Number, Item Type ");
    for (int i = 0; i < Products.size(); i++) {
      item itemIndex = Products.get(i);
      String itemToPrint = itemIndex.toString();
      System.out.println(itemToPrint);
    }
  }
}