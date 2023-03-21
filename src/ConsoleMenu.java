import java.util.Scanner;

public class ConsoleMenu {
  private static Boolean end = false;

  public static void startMenu(){
    System.out.println("Welcome to the Console Version of Ebay Manager.");
    applicationMode();
  }

  public static void applicationMode(){
    Scanner applicationModeSelector = new Scanner(System.in);
     System.out.println("");
     System.out.println("Input the number corresponding to the part of the application you'd like to run");
     int selectedMode = Integer.parseInt(applicationModeSelector.nextLine());
     if(selectedMode == 1){
       
     }
  }

  public static void managerMainMenu() {
    while (end == false) {

      //Prints whole menu
      System.out.println("");
      System.out.println("Welcome to the Console Version of Ebay Manager.");
      Scanner MainMenuInput = new Scanner(System.in);
      System.out.println("Please input the number which corresponds to the function you want to use.");
      System.out.println("0(TEMP).Clear Products");
      System.out.println("1. Display current items");
      System.out.println("2. Add a Product using the Console");
      System.out.println("3. Dump a CSV into the Product List");
      System.out.println("10. Input 10 to go back and select which part of the application you'd like to use.");

      //Calls different functions depending on input
      int mainInput = Integer.parseInt(MainMenuInput.nextLine());
      if (mainInput == 0) {
        FileHandler.clearList();
      }
      else if (mainInput == 1) {
        FileHandler.displayProducts();
      }
      else if (mainInput == 2) {
        FileHandler.addItem();
      }
      else if(mainInput ==3 ){
        System.out.println("Be careful! Make sure the CSV conforms to the layout of the table.");
      }
      else if(mainInput == 10){
        System.out.println("Going Back.");
        applicationMode();
      }else{
        System.out.println("Invalid input.");
      }
    }
  }
}