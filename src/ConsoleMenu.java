import java.util.Scanner;

public class ConsoleMenu {

  public static void startMenu() {
    FileHandler.checkSavedPath();
    FileHandler.readCSV();
    FileHandler.Notification.stockAlert();
    System.out.println("Welcome to the Console Version of Ebay Manager.");
    applicationMode();
  }

  public static void applicationMode() {
    Scanner applicationModeSelector = new Scanner(System.in);
    System.out.println();
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


      // Prints whole menu
      System.out.println();
      System.out.println("Welcome to the Console Version of Ebay Manager.");
      Scanner MainMenuInput = new Scanner(System.in);
      System.out.println("Please input the number which corresponds to the function you want to use.");
      System.out.println("0(TEMP).Clear Products");
      System.out.println("1. Display current items");
      System.out.println("2. Add a Product using the Console");
      System.out.println("3. Remove an item");
      System.out.println("10. Input 10 to go back and select which part of the application you'd like to use.");

      // Calls different methods in FileHandler class depending on input
      int mainInput = Integer.parseInt(MainMenuInput.nextLine());
      if (mainInput == 0) {
        FileHandler.clearProductList();
      } else if (mainInput == 1) {
        FileHandler.displayProducts();
      } else if (mainInput == 2) {
        FileHandler.addItem();
      } else if (mainInput == 3) { // Need to create CSV method still!
        System.out.println("Which item would you like to remove?");
        FileHandler.removeProductByName(itemToRemoveName());
      } else if (mainInput == 10) {
        System.out.println("Going Back.");
        applicationMode();
      } else {
        System.out.println("Invalid input.");
      }
  }

  public static String itemToRemoveName(){
    Scanner removeInput = new Scanner(System.in);
    System.out.println("What is the name of the item you would like to remove?");
    return removeInput.nextLine();
  }

  public static void messageGeneratorMenu() {
      Scanner websiteSelector = new Scanner(System.in);
      System.out.println("Welcome to the Message generator area of the application.");
      System.out.println("Please select the desired website you want to generate the message for.");
      System.out.println("1. Ebay");
      System.out.println("2. AliExpress");
      System.out.println("3. Go back to mode selector");
      int webInput = Integer.parseInt(websiteSelector.nextLine());
      if (webInput == 1) {
        ebayGenMenu();
      } else if (webInput == 2) {
        aliGenMenu();
      } else if (webInput == 3) {
        applicationMode();
      }
  }

  public static void ebayGenMenu() {
    ebayMessage.message.clear();
    Scanner genMenuInput = new Scanner(System.in);
    System.out.println("Welcome to the Ebay message generator.");
    System.out.println("Input the number corresponding to the option:");
    System.out.println("1.  For Seller Feedback");
    System.out.println("2. For Buyer feedback");
    int genUserMenuInput = Integer.parseInt(genMenuInput.nextLine());
    if (genUserMenuInput == 1) {
      System.out.println("Seller Feedback Selected");
      ebaySellerFeedbackGen();
    } else if (genUserMenuInput == 2) {
      System.out.println("Buyer Feedback Selected");
      ebayBuyerFeedbackGen();
    }
  }
  public static void ebayBuyerFeedbackGen() {
    boolean posOrNeg;
    String feedbackMode = "buyer";
    Scanner buyerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String buyerFeedbackType = buyerPositiveOrNegativeScanner.nextLine();
    if (buyerFeedbackType.equals("Positive") || buyerFeedbackType.equals("positive")) {
      posOrNeg = true;
      new ebayMessage.ebayMessageGenerator(feedbackMode,posOrNeg);
    } else if (buyerFeedbackType.equals("Negative") || buyerFeedbackType.equals("negative")) {
      posOrNeg = false;
      new ebayMessage.ebayMessageGenerator(feedbackMode,posOrNeg);
    } else {
      ebayBuyerFeedbackGen();
    }
  }
  public static void ebaySellerFeedbackGen() {
      boolean posOrNeg;
      String feedbackMode = "seller";
      Scanner sellerPositiveOrNegativeScanner = new Scanner(System.in);
      System.out.println("Is the feedback Positive or Negative?");
      String sellerFeedbackType = sellerPositiveOrNegativeScanner.nextLine();
      if (sellerFeedbackType.equals("Positive") || sellerFeedbackType.equals("positive")) {
          posOrNeg = true;
          new ebayMessage.ebayMessageGenerator(feedbackMode, posOrNeg);
      } else if (sellerFeedbackType.equals("Negative") || sellerFeedbackType.equals("negative")) {
          posOrNeg = false;
          new ebayMessage.ebayMessageGenerator(feedbackMode, posOrNeg);
      } else {
          ebaySellerFeedbackGen();
      }
  }
    public static void aliGenMenu() {
        aliExpressMessage.message.clear();
        Scanner genMenuInput = new Scanner(System.in);
        System.out.println("Welcome to the Ebay message generator.");
        System.out.println("Input the number corresponding to the option:");
        System.out.println("1.  For Seller Feedback");
        System.out.println("2. For Buyer feedback");
        int genUserMenuInput = Integer.parseInt(genMenuInput.nextLine());
         if (genUserMenuInput == 1) {
            System.out.println("Seller Feedback Selected");
            aliSellerFeedbackGen();
        } else if (genUserMenuInput == 2) {
            System.out.println("Buyer Feedback Selected");
            aliBuyerFeedbackGen();
         }
    }

    public static void aliBuyerFeedbackGen() {
          String feedbackType = "buyer";
          boolean posOrNeg;
          Scanner buyerPositiveOrNegativeScanner = new Scanner(System.in);
          System.out.println("Is the feedback Positive or Negative?");
          String buyerFeedbackType = buyerPositiveOrNegativeScanner.nextLine();
          if (buyerFeedbackType.equals("Positive") || buyerFeedbackType.equals("positive")|| buyerFeedbackType.equals("p") || buyerFeedbackType.equals("P")) {
              posOrNeg = true;
              new aliExpressMessage.aliMessageGenerator(feedbackType, posOrNeg);
          } else if (buyerFeedbackType.equals("Negative") || buyerFeedbackType.equals("negative") || buyerFeedbackType.equals("n") || buyerFeedbackType.equals("N")) {
              posOrNeg = false;
              new aliExpressMessage.aliMessageGenerator(feedbackType, posOrNeg);
          } else {
             aliBuyerFeedbackGen();
          }
      }

      public static void aliSellerFeedbackGen() {
          String feedbackType = "seller";
          boolean posOrNeg;
          Scanner sellerPositiveOrNegativeScanner = new Scanner(System.in);
          System.out.println("Is the feedback Positive or Negative?");
          String sellerFeedbackType = sellerPositiveOrNegativeScanner.nextLine();
          if (sellerFeedbackType.equals("Positive") || sellerFeedbackType.equals("positive") || sellerFeedbackType.equals("P") || sellerFeedbackType.equals("p")) {
              posOrNeg = true;
              new aliExpressMessage.aliMessageGenerator(feedbackType, posOrNeg);
          } else if (sellerFeedbackType.equals("Negative") || sellerFeedbackType.equals("negative")|| sellerFeedbackType.equals("N") || sellerFeedbackType.equals("n")) {
              posOrNeg = false;
              new aliExpressMessage.aliMessageGenerator(feedbackType, posOrNeg);
          } else {
              aliSellerFeedbackGen();
          }

      }

  }

