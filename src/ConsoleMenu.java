import java.util.Scanner;

public class ConsoleMenu {
  private static Boolean end = false;

  public static void mainMenu() {
    while (end == false) {
      System.out.println("");
      System.out.println("Welcome to the Console Version of Ebay Manager.");
      Scanner MainMenuInput = new Scanner(System.in);
      System.out.println("Please input the number which corresponds to the function you want to use.");
      System.out.println("0(TEMP).Clear Products");
      System.out.println("1. Display current items");
      System.out.println("2. Add a Product using the Console");
      int mainInput = Integer.parseInt(MainMenuInput.nextLine());
      if (mainInput == 0) {
        FileHandler.clearList();
      }
      if (mainInput == 1) {
        FileHandler.displayProducts();
      }
      if (mainInput == 2) {
        FileHandler.addItem();
      }
    }
  }
}