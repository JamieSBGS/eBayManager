import java.util.ArrayList;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class aliExpressMessageGenerator {
  static ArrayList<String> aliSellerPosMessage = new ArrayList<>();
  static ArrayList<String> aliBuyerPosMessage = new ArrayList<>();
  static ArrayList<String> aliSellerNegMessage = new ArrayList<>();
  static ArrayList<String> aliBuyerNegMessage = new ArrayList<>();

  public static void genMenu() {
    Scanner genMenuInput = new Scanner(System.in);
    System.out.println("Welcome to the AliExpress message generator.");
    System.out.println("Input the number corresponding to the option:");
    System.out.println("1.  For Seller Feedback");
    System.out.println("2. For Buyer feedback");
    System.out.println("3. Thanks for buying message");
    int genUserMenuInput = Integer.parseInt(genMenuInput.nextLine());
    if (genUserMenuInput == 1) {
      System.out.println("Seller Feedback Selected");
      sellerFeedbackGen();
    } else if (genUserMenuInput == 2) {
      System.out.println("Buyer Feedback Selected");
      buyerFeedbackGen();
    } else if (genUserMenuInput == 3) {
      System.out.println("Thanks for buying message Selected");
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

  public static void buyerFeedbackGen() {
    Scanner buyerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String buyerFeedbackType = buyerPositiveOrNegativeScanner.nextLine();
    if (buyerFeedbackType.equals("Positive") || buyerFeedbackType.equals("positive")|| buyerFeedbackType.equals("p") || buyerFeedbackType.equals("P")) {
      buyerPosMenu();
    } else if (buyerFeedbackType.equals("Negative") || buyerFeedbackType.equals("negative") || buyerFeedbackType.equals("n") || buyerFeedbackType.equals("N")) {
      buyerNegMenu();
    } else {
      buyerFeedbackGen();
    }
  }

  public static void sellerFeedbackGen() {
    Scanner sellerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String sellerFeedbackType = sellerPositiveOrNegativeScanner.nextLine();
    if (sellerFeedbackType.equals("Positive") || sellerFeedbackType.equals("positive") || sellerFeedbackType.equals("P") || sellerFeedbackType.equals("p")) {
      sellerPosMenu();
    } else if (sellerFeedbackType.equals("Negative") || sellerFeedbackType.equals("negative")|| sellerFeedbackType.equals("N") || sellerFeedbackType.equals("n")) {
      sellerNegMenu();
    } else {
      sellerFeedbackGen();
    }

  }

  public static void copyToClipboard(ArrayList<String> arraylistToCopy) {
    String myString = arraylistToCopy.toString();
    StringSelection stringSelection = new StringSelection(myString);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);
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
      printArrayList(aliSellerPosMessage);
      copyToClipboard(aliSellerPosMessage);
      System.out.println("successfully copied to clipboard");
      aliSellerPosMessage.clear();
      System.out.println();
    } else if (sellerPosMenuInput == 1) {
      aliSellerPosMessage.add("Great seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 2) {
      aliSellerPosMessage.add("A++ Seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 3) {
      aliSellerPosMessage.add("Quick Delivery");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 4) {
      aliSellerPosMessage.add("Product corresponds to description");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 5) {
      aliSellerPosMessage.add("Excellent customer service");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 6) {
      aliSellerPosMessage.add("Highly recommended");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 7) {
      aliSellerPosMessage.add("Smooth transaction");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 8) {
      aliSellerPosMessage.add("Reliable seller");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 9) {
      aliSellerPosMessage.add("Fast shipping");
      sellerPosMenu();
    } else if (sellerPosMenuInput == 10) {
      aliSellerPosMessage.add("Impressive packaging");
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
      printArrayList(aliBuyerPosMessage);
      copyToClipboard(aliBuyerPosMessage);
      System.out.println("successfully copied to clipboard");
      aliBuyerPosMessage.clear();
      System.out.println();
    } else if (buyerPosMenuInput == 1) {
      aliBuyerPosMessage.add("Great buyer");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 2) {
      aliBuyerPosMessage.add("Trustworthy buyer");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 3) {
      aliBuyerPosMessage.add("Prompt payment");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 4) {
      aliBuyerPosMessage.add("Excellent communication ");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 5) {
      aliBuyerPosMessage.add("very pleased");
      buyerPosMenu();
    } else if (buyerPosMenuInput == 6) {
      aliBuyerPosMessage.add("fast payment");
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
      printArrayList(aliSellerNegMessage);
      copyToClipboard(aliSellerNegMessage);
      System.out.println("successfully copied to clipboard");
      aliSellerNegMessage.clear();
      System.out.println();
    } else if (sellerNegMenuInput == 1) {
      aliSellerNegMessage.add("Wouldn't Recommend seller");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 2) {
      aliSellerNegMessage.add("Avoid Seller");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 3) {
      aliSellerNegMessage.add("Slow Delivery");
      sellerNegMenu();
    } else if (sellerNegMenuInput == 4) {
      aliSellerNegMessage.add("Product doesn't match item description");
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
      printArrayList(aliBuyerNegMessage);
      copyToClipboard(aliBuyerNegMessage);
      System.out.println("successfully copied to clipboard");
      aliBuyerNegMessage.clear();
      System.out.println();
    } else if (buyerNegMenuInput == 1) {
      aliBuyerNegMessage.add("Delayed shipping");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 2) {
      aliBuyerNegMessage.add("Seller hard to work with");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 3) {
      aliBuyerNegMessage.add("Item never arrived");
      buyerNegMenu();
    } else if (buyerNegMenuInput == 4) {
      aliBuyerNegMessage.add("Insufficient packaging. Item arrived damaged");
      buyerNegMenu();
    }
  }
}