import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Toolkit;


public class FileHandler {
  public static ArrayList<item> Products = new ArrayList<>();
  private static String Path;

  public static void checkSavedPath() {
    try {
      FileReader fr = new FileReader("config.txt");
      BufferedReader br = new BufferedReader(fr);
      Path = br.readLine();
      readCSV();
    } catch (FileNotFoundException e) {
      System.out.println("Saved path not found. Please enter a new path.");
      setPath();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void savePath() {
    String fileName = "config.txt";
    try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, false))) {
      pr.println(Path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String setPath() {
    Scanner userPathInput = new Scanner(System.in);
    System.out.println("Insert path name of the .csv file which contains the product list");
    String inputtedPath = userPathInput.nextLine();

    if (inputtedPath != null && inputtedPath.endsWith(".csv")) {
      Path = inputtedPath;
      savePath();
      return Path;
    } else {
      System.out.println("Invalid path inputted or the file doesn't have a .csv extension. Please try again.");
      System.out.println();
      return setPath(); // Recursive call to restart the method
    }
  }

  public static String getPath() {
    return Path;
  }

  public static void readCSV() {
    try {
      File csvObj = new File(getPath());
      BufferedReader br = new BufferedReader(new FileReader(csvObj));
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        item csvProduct = new item(values[0], Float.parseFloat(values[1]), Integer.parseInt(values[2]), values[3],
            values[4]);
        Products.add(csvProduct);
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void updateProductListFile() {
    String filePath = getPath();
    try (FileWriter writer = new FileWriter(filePath)) {
      // Write the header
      writer.write("Item Name, Price, Stock Number, Item Type, Item ID, Net Profit\n");
      // Write each item
      for (item item : getProducts()) {
        writer.write(item.getItemName() + ",");
        writer.write(item.getPrice() + ",");
        writer.write(item.getStockNum() + ",");
        writer.write(item.getItemType() + ",");
        writer.write(item.getItemID() + ",");
        writer.write(item.getNetProfit() + "\n");
      }
      System.out.println("Data has been written to the file successfully.");
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }
  }

  public static ArrayList<item> getProducts() {
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
    String fieldItemID = UserInput.nextLine();

    item addedProduct = new item(fieldItemName, fieldPrice, fieldStockNum, fieldItemType, fieldItemID);
    Products.add(addedProduct);

    // Writing to CSV file part
    String[] addedProdFields = { addedProduct.getItemName(), String.valueOf(addedProduct.getPrice()),
        String.valueOf(addedProduct.getStockNum()), addedProduct.getItemType(), addedProduct.getItemID() };

    try {
      String addPath =getPath();
      FileWriter writer = new FileWriter(addPath, true);
      writer.append("\n");
      for (int i = 0; i < addedProdFields.length; i++) {
        writer.append(addedProdFields[i]);

        if (i != addedProdFields.length - 1) {
          writer.append(",");
        }
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public static void printArrayList(ArrayList<String> arrList) {
    for (int i = 0; i < arrList.size(); i++) {
      System.out.print(arrList.get(i));
      if (i != arrList.size() - 1) { // Only add comma and space if not the last element
        System.out.print(", ");
      } else { // Add a full stop at the end of the ArrayList
        System.out.print(".");
      }
    }
    System.out.println(); // Print a newline character after the ArrayList is printed
  }
  public static void removeProductByName(String itemName) {
    item itemToRemove = null;
    for (item item : Products) {
      if (item.getItemName().equals(itemName)) {
        itemToRemove = item;
      }
    }
    if (itemToRemove != null) {
      Products.remove(itemToRemove);
      updateProductListFile();
      System.out.println("Item removed successfully.");
    } else {
      System.out.println("Item not found.");
    }
  }

  public static void displayProducts() {
    System.out.println();
    System.out.println("The currently stored products:");
    System.out.println("Item Name, Price, Stock Number, Item Type, Item ID, Net Profit");
    for (int i = 0; i < Products.size(); i++) {
      item itemIndex = Products.get(i);
      String itemToPrint = itemIndex.toString();
      double netProfit = itemIndex.getNetProfit();
      itemToPrint += ", " + netProfit;
      System.out.println(itemToPrint);
    }
  }
  public static void copyToClipboard(ArrayList<String> arraylistToCopy) {
    String myString = arraylistToCopy.toString();
    StringSelection stringSelection = new StringSelection(myString);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);
  }

  public static class Notification {
    public static void stockAlert() {
      for (item item : Products) {
        if (item.getStockNum() == 1) {
          System.out.println("Alert: Only 1 " + item.getItemName() + " left.");
        } else if (item.getStockNum() == 0) {
          System.out.println("Alert: " + item.getItemName() + " is out of stock.");
        }
      }
    }
  }
}