import java.util.Scanner;

public class ConsoleMenu {
  private static Boolean end = false;

  private static void endProgram() {
    Scanner endCheck = new Scanner(System.in);
    System.out.println("");
    System.out.println("Would you like to close the Program?");
    String endInput = endCheck.nextLine();
    if (endInput == "yes") {
      end = true;
    } else if (endInput == "y") {
      end = true;
    }
  }

  public static void startMenu() {
    System.out.println("Welcome to the Console Version of Ebay Manager.");
    applicationMode();
  }

  public static void applicationMode() {
    Scanner applicationModeSelector = new Scanner(System.in);
    System.out.println("");
    System.out.println("Input the number corresponding to the part of the application you'd like to run");
    System.out.println("1. Ebay Inventory Manager");
    System.out.println("2. Message Generator");
    int selectedMode = Integer.parseInt(applicationModeSelector.nextLine());
    if (selectedMode == 1) {
      System.out.println("launching Ebay Inventory Manager...");
      managerMainMenu();
    } else if (selectedMode == 2) {
      System.out.println("launching message generator...");
      messageGeneratorMenu();
    }
  }

  public static void managerMainMenu() {
    while (end == false) {

      // Prints whole menu
      System.out.println("");
      System.out.println("Welcome to the Console Version of Ebay Manager.");
      Scanner MainMenuInput = new Scanner(System.in);
      System.out.println("Please input the number which corresponds to the function you want to use.");
      System.out.println("0(TEMP).Clear Products");
      System.out.println("1. Display current items");
      System.out.println("2. Add a Product using the Console");
      System.out.println("3. Dump a CSV into the Product List");
      System.out.println("10. Input 10 to go back and select which part of the application you'd like to use.");

      // Calls different methods in FileHandler class depending on input
      int mainInput = Integer.parseInt(MainMenuInput.nextLine());
      if (mainInput == 0) {
        FileHandler.clearProductList();
        endProgram();
      } else if (mainInput == 1) {
        FileHandler.displayProducts();
        endProgram();
      } else if (mainInput == 2) {
        FileHandler.addItem();
        endProgram();
      } else if (mainInput == 3) { // Need to create CSV method still!
        System.out.println("Be careful! Make sure the CSV conforms to the layout of the table.");
        FileHandler.readCSV();
        endProgram();
      } else if (mainInput == 10) {
        System.out.println("Going Back.");
        applicationMode();
        endProgram();
      } else {
        System.out.println("Invalid input.");
      }
    }
  }

  public static void messageGeneratorMenu() {
    while (end == false) {
      Scanner websiteSelector = new Scanner(System.in);
      System.out.println("Welcome to the Message generator area of the application.");
      System.out.println("Please select the desired website you want to gnerate the message for.");
      System.out.println("1. Ebay");
      System.out.println("2. AliExpress");
      System.out.println("3. Go back to mode selector");
      int webInput = Integer.parseInt(websiteSelector.nextLine());
      if (webInput == 1) {
        ebayMessageGenerator.genMenu();
        endProgram();
      } else if (webInput == 2) {
        System.out.println("Implement AliExpress message gen");
        endProgram();
      } else if (webInput == 3) {
        applicationMode();
      }
    }
  }
}