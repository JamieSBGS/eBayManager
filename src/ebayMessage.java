import java.util.ArrayList;
import java.util.Scanner;

public class ebayMessage {
  static ArrayList<String> message = new ArrayList<>();

  public class ebayMessageGenerator{
    String feedbackType;
    boolean positiveOrNegative;

    public ebayMessageGenerator(String feedbackType, boolean positiveOrNegative){
      this.feedbackType = feedbackType;
      this.positiveOrNegative = positiveOrNegative;

      if ((feedbackType.equals("seller") && positiveOrNegative)){
        sellerPosMenu();
      } else if ((feedbackType.equals("seller") && !positiveOrNegative)) {
        sellerNegMenu();
      }

      if ((feedbackType.equals("buyer") && positiveOrNegative)){
        buyerPosMenu();
      } else if ((feedbackType.equals("buyer") && !positiveOrNegative)) {
        buyerNegMenu();
      }
    }
    public String getFeedbackType(){
      return feedbackType;
    }
    public boolean getpositiveOrNegative(){
      return positiveOrNegative;
    }
  }
  public static void genMenu() {
    String feedbackMode;
    message.clear();
    Scanner genMenuInput = new Scanner(System.in);
    System.out.println("Welcome to the Ebay message generator.");
    System.out.println("Input the number corresponding to the option:");
    System.out.println("1.  For Seller Feedback");
    System.out.println("2. For Buyer feedback");
    int genUserMenuInput = Integer.parseInt(genMenuInput.nextLine());
    if (genUserMenuInput == 1) {
      System.out.println("Seller Feedback Selected");
      feedbackMode = "seller";
      sellerFeedbackGen();
    } else if (genUserMenuInput == 2) {
      System.out.println("Buyer Feedback Selected");
      feedbackMode = "buyer";
      buyerFeedbackGen();
    }
  }


  public static void buyerFeedbackGen() {
    Scanner buyerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String buyerFeedbackType = buyerPositiveOrNegativeScanner.nextLine();
    if (buyerFeedbackType.equals("Positive") || buyerFeedbackType.equals("positive")) {
      buyerPosMenu();
    } else if (buyerFeedbackType.equals("Negative") || buyerFeedbackType.equals("negative")) {
      buyerNegMenu();
    } else {
      buyerFeedbackGen();
    }
  }

  public static void sellerFeedbackGen() {
    Scanner sellerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String sellerFeedbackType = sellerPositiveOrNegativeScanner.nextLine();
    if (sellerFeedbackType.equals("Positive") || sellerFeedbackType.equals("positive")) {
      sellerPosMenu();
    } else if (sellerFeedbackType.equals("Negative") || sellerFeedbackType.equals("negative")) {
      sellerNegMenu();
    } else {
      sellerFeedbackGen();
    }

  }

  public static void sellerPosMenu() {
    Scanner sellerPosMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("0. Finish,print and copy message to clipboard");
    System.out.println("1. Great seller");
    System.out.println("2. A++ Seller");
    System.out.println("3. Add Quick Delivery to the message");
    System.out.println("4. Product corresponds to description");
    System.out.println("5. Excellent customer service");
    System.out.println("6. Highly recommended");
    System.out.println("7. Smooth transaction");
    System.out.println("8. Reliable seller");
    System.out.println("9. Fast shipping");
    System.out.println("10. Impressive packaging");
    int sellerPosMenuInput = Integer.parseInt(sellerPosMenuScanner.nextLine());
    if (sellerPosMenuInput == 0) {
      FileHandler.printArrayList(message);
      FileHandler.copyToClipboard(message);
      System.out.println("successfully copied to clipboard");
      message.clear();
      System.out.println();
    } else if (sellerPosMenuInput == 1) {
      message.add("Great seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 2) {
      message.add("A++ Seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 3) {
      message.add("Quick Delivery");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 4) {
      message.add("Product corresponds to description");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 5) {
      message.add("Excellent customer service");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 6) {
      message.add("Highly recommended");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 7) {
      message.add("Smooth transaction");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 8) {
      message.add("Reliable seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 9) {
      message.add("Fast shipping");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 10) {
      message.add("Impressive packaging");
      sellerPosMenu();
    }
  }


  public static void buyerPosMenu() {
    Scanner buyerPosMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("0. Finish and print message");
    System.out.println("1. Great buyer");
    System.out.println("2. Trustworthy buyer");
    System.out.println("3. Prompt payment");
    System.out.println("4.Excellent communication  ");
    System.out.println("5. very pleased");
    System.out.println("6. fast payment");
    int buyerPosMenuInput = Integer.parseInt(buyerPosMenuScanner.nextLine());
    if (buyerPosMenuInput == 0) {
      FileHandler.printArrayList(message);
      FileHandler.copyToClipboard(message);
      System.out.println("successfully copied to clipboard");
      message.clear();
      System.out.println();
    } else if (buyerPosMenuInput == 1) {
      message.add("Great buyer");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 2) {
      message.add("Trustworthy buyer");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 3) {
      message.add("Prompt payment");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 4) {
      message.add("Excellent communication ");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 5) {
      message.add("very pleased");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 6) {
      message.add("fast payment");
      buyerPosMenu();
    }
  }

  public static void sellerNegMenu() {
    Scanner sellerNegMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("0. Finish and print message");
    System.out.println("1. Wouldn't Recommend seller");
    System.out.println("2. Avoid Seller");
    System.out.println("3. Slow Delivery");
    System.out.println("4. Product doesn't match item description");
    int sellerNegMenuInput = Integer.parseInt(sellerNegMenuScanner.nextLine());
    if (sellerNegMenuInput == 0) {
      FileHandler.printArrayList(message);
      FileHandler.copyToClipboard(message);
      System.out.println("successfully copied to clipboard");
      message.clear();
      System.out.println();
    } else if (sellerNegMenuInput == 1) {
      message.add("Wouldn't Recommend seller");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 2) {
      message.add("Avoid Seller");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 3) {
      message.add("Slow Delivery");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 4) {
      message.add("Product doesn't match item description");
      sellerNegMenu();
    }
  }

  public static void buyerNegMenu() {
    Scanner buyerNegMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("0. Finish and print message");
    System.out.println("1. Delayed shipping");
    System.out.println("2. Seller hard to work with");
    System.out.println("3. Item never arrived");
    System.out.println("4. Insufficient packaging. Item arrived damaged");
    int buyerNegMenuInput = Integer.parseInt(buyerNegMenuScanner.nextLine());
    if (buyerNegMenuInput == 0) {
      FileHandler.printArrayList(message);
      FileHandler.copyToClipboard(message);
      System.out.println("successfully copied to clipboard");
      message.clear();
      System.out.println();
    } else if (buyerNegMenuInput == 1) {
      message.add("Delayed shipping");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 2) {
      message.add("Seller hard to work with");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 3) {
      message.add("Item never arrived");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 4) {
      message.add("Insufficient packaging. Item arrived damaged");
      buyerNegMenu();
    }
  }
}