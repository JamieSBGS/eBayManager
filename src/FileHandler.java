import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Toolkit;


public class FileHandler {
  static int stockSoldPerMonth;
  static int stockSoldPerYear;
  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  public static ArrayList<item> Products = new ArrayList<>();
  private static String Path;

  public static ArrayList<Float> monthlyNetGain = new ArrayList<>();
  public static ArrayList<Float> yearlyNetGain = new ArrayList<>();
  public static java.time.LocalDate programStartDate = firstOpen();
  public static java.time.LocalDate targetMonth;
  public static java.time.LocalDate targetYear;
  public static java.time.LocalDate currentDate = java.time.LocalDate.now();

  static {
    if (programStartDate != null) {
      targetMonth = programStartDate.plusMonths(1);
      targetYear = programStartDate.plusYears(1);
    }
  }

  public static LocalDate firstOpen() {
    try {
      File configFile = new File("config.txt");
      if (!configFile.exists()) {
        System.out.println("Couldn't find file");
        writeToConfig(localDateToString(currentDate));
        return currentDate;
      }

      try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
        String line;
        int lineCount = 1;
        while ((line = br.readLine()) != null) {
          if (lineCount == 2) {
            if (!line.isEmpty()) {
              try {
                return LocalDate.parse(line, formatter);
              } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format in config file. Writing current date.");
                br.close(); // Close the reader before writing to the file
                writeToConfig(localDateToString(currentDate));
                stockSoldPerMonth = 0;
                stockSoldPerYear = 0;
                return currentDate;
              }
            } else {
              // If the line is empty, write the current date to the config file and return it
              br.close(); // Close the reader before writing to the file
              writeToConfig(localDateToString(currentDate));
              return currentDate;
            }
          }
          lineCount++;
        }
      }

      // If line 2 is not found, write the current date to the config file and return it
      writeToConfig(localDateToString(currentDate));
      return currentDate;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
  public static void writeToConfig(String desiredText){
    try (PrintWriter pr = new PrintWriter(new FileWriter("config.txt", true))) {
      pr.println(desiredText);
      System.out.println("Successfully written to config");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Unsuccessfully written to config");
    }
  }
  public static void writeToMonthAndYearFile(float desiredNum, String additionalText){
    try (PrintWriter pr = new PrintWriter(new FileWriter("MonthlyYearlyProfit.txt", true))) {
      String desiredText = Float.toString(desiredNum);
      pr.println(additionalText + desiredText);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void writeToMonthAndYearFile(int NumStock, String additionalText){
    try (PrintWriter pr = new PrintWriter(new FileWriter("MonthlyYearlyProfit.txt", true))) {
      String desiredText = Integer.toString(NumStock);
      pr.println(additionalText + desiredText);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String localDateToString(LocalDate date) {
    if (date == null) {
      return ""; // Return an empty string or any appropriate default value if date is null
    }
    return date.format(formatter);
  }
  public static void timeCheck(){
    checkMonth();
    checkYear();
  }

  public static void printDateDifference() {
    Period period = Period.between(currentDate, targetYear);
    int years = Math.abs(period.getYears());
    int months = Math.abs(period.getMonths());
    int days = Math.abs(period.getDays());

    System.out.printf("Difference between Current Date and Target Year: %d years, %d months, %d days%n", years, months, days);

     period = Period.between(currentDate, targetMonth);
     years = Math.abs(period.getYears());
     months = Math.abs(period.getMonths());
     days = Math.abs(period.getDays());

    System.out.printf("Difference between Current Date and next month of : %d years, %d months, %d days%n", years, months, days);
  }

  public static void checkMonth() {
    if (currentDate.isAfter(targetMonth)) {
      String datesToPrint = "From (Month): " + targetMonth + " to " + targetMonth.plusMonths(1).minusDays(1);
      printArrayList(convertFloatListToStringList(monthlyNetGain));
      float sum = timeNetTotal(monthlyNetGain);
      writeToMonthAndYearFile(sum, datesToPrint);
      writeToMonthAndYearFile(stockSoldPerMonth, "Stock Sold in month:");
      System.out.println("Successfully written this month's income to file: MonthlyYearlyProfit.txt");
      targetMonth = targetMonth.plusMonths(1);
    }
  }
  public static void checkYear() {
    if (currentDate.isAfter(targetYear)) {
      String datesToPrint = "From (Year): " + targetYear + " to " + targetYear.plusYears(1).minusDays(1);
      printArrayList(convertFloatListToStringList(yearlyNetGain));
      float sum = timeNetTotal(yearlyNetGain);
      writeToMonthAndYearFile(sum, datesToPrint);
      writeToMonthAndYearFile(stockSoldPerYear, "Stock Sold in year:");
      System.out.println("Successfully written this year's income to file: MonthlyYearlyProfit.txt");
      targetYear = targetYear.plusYears(1);
    }
  }
  public static ArrayList<String> convertFloatListToStringList(ArrayList<Float> floatList) {
    ArrayList<String> stringList = new ArrayList<>();

    for (Float f : floatList) {
      String str = Float.toString(f);
      stringList.add(str);
    }
    return stringList;
  }
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


  public static float timeNetTotal(ArrayList<Float> floatList) {
    float sum = 0.0f;

    for (Float f : floatList) {
      sum += f;
    }

    return sum;
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
  public static String setPath(String inputtedPath) {
    if (inputtedPath != null && inputtedPath.endsWith(".csv")) {
      Path = inputtedPath;
      savePath();
      return Path;
    }else{
      Path = null;
      return Path;
    }
  }

  public static String getPath() {
    return Path;
  }

  public static void readCSV() {
    try {
      File csvObj = new File(getPath());
      BufferedReader br = new BufferedReader(new FileReader(csvObj));

      // Skip the header row
      String header = br.readLine();

      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");

        // Make sure you're only parsing numeric values where appropriate
        String itemName = values[0].trim();
        float price = 0.0f; // Default value
        int stockNum = 0;   // Default value
        String itemType = "";
        String itemID = "";

        // Parse numeric values only if they are present and not column names
        if (values.length >= 2) {
          try {
            price = Float.parseFloat(values[1].trim());
          } catch (NumberFormatException ignored) {
          }
        }
        if (values.length >= 3) {
          try {
            stockNum = Integer.parseInt(values[2].trim());
          } catch (NumberFormatException ignored) {
          }
        }

        if (values.length >= 4) {
          itemType = values[3].trim();
        }

        if (values.length >= 5) {
          itemID = values[4].trim();
        }

        item csvProduct = new item(itemName, price, stockNum, itemType, itemID);
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

  public static void addItem(String fieldItemName, float fieldPrice, int fieldStockNum,String fieldItemType, String fieldItemID) {
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
  public static void removeProduct(String itemName) {
    item itemToRemove = null;
    for (item item : Products) {
      if (item.getItemName().equals(itemName)) {
        itemToRemove = item;
      }
    }
    if (itemToRemove != null) {
      removeStock(itemToRemove.getItemName());
      Products.remove(itemToRemove);
      updateProductListFile();
      System.out.println("Item removed successfully.");
    } else {
      System.out.println("Item not found.");
    }
  }

  public static void removeStock(String itemName){
    for (item item : Products) {
      if (item.getItemName().equals(itemName)) {
         float netValue = item.getNetProfit();
         monthlyNetGain.add(netValue);
         yearlyNetGain.add(netValue);
         stockSoldPerMonth++;
         stockSoldPerYear++;
         item.setStockNum(item.getStockNum()-1);
      }
    }
  }

  public static void displayProducts() {
    System.out.println();
    System.out.println("The currently stored products:");
    System.out.println("Item Name, Price, Stock Number, Item Type, Item ID, Net Profit");
    for (item itemIndex : Products) {
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