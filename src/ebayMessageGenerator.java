import java.util.ArrayList;
import java.util.Scanner;

public class ebayMessageGenerator{

  public static void genMenu(){
    Scanner genMenuInput = new Scanner(System.in);
    System.out.println("Welcome to the Ebay message generator.");
    System.out.println("Input the number corresponding to the option:");
    System.out.println("1.  For Seller Feedback");
    System.out.println("2. For Buyer feedback");
    System.out.println("3. Thanks for buying message");
   int genUserMenuInput = Integer.parseInt(genMenuInput.nextLine());
    if(genUserMenuInput == 1){
      System.out.println("Seller Feedback Selected");
      sellerFeedbackGen();
    }else if(genUserMenuInput == 2){
      System.out.println("Buyer Feedback Selected");
      sellerFeedbackGen();
    }else if(genUserMenuInput == 3){
      System.out.println("Thanks for buying message Selected");
    }
  }

  public static void buyerFeedbackGen(){
    Scanner buyerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String buyerFeedbackType = buyerPositiveOrNegativeScanner.nextLine();
    if(buyerFeedbackType.equals("Positive") || buyerFeedbackType.equals("positive")){
      buyerPosMenu();
    } else if(buyerFeedbackType.equals("Negative") || buyerFeedbackType.equals("negative")){
      buyerNegMenu();
    }
  }

  public static void sellerFeedbackGen(){
    Scanner sellerPositiveOrNegativeScanner = new Scanner(System.in);
    System.out.println("Is the feedback Positive or Negative?");
    String sellerFeedbackType = sellerPositiveOrNegativeScanner.nextLine();
    if(sellerFeedbackType.equals("Positive") || sellerFeedbackType.equals("positive")){
      sellerPosMenu();
    } else if(sellerFeedbackType.equals("Negative") || sellerFeedbackType.equals("negative")){
      sellerNegMenu();
    }
    
  }

  public static void sellerPosMenu() {
    ArrayList<String> sellerPosMessage = new ArrayList<String>();
    Scanner sellerPosMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("1. Great seller");
    System.out.println("2.A++ Seller");
    System.out.println("3. Add Quick Delivery to the message");
    System.out.println("4. Product corresponds to description");
    int sellerPosMenuInput = Integer.parseInt(sellerPosMenuScanner.nextLine());
    if (sellerPosMenuInput == 1) {
      sellerPosMessage.add("Great seller");
    } else if (sellerPosMenuInput == 2) {
      sellerPosMessage.add("A++ Seller");
    } else if (sellerPosMenuInput == 3) {
      sellerPosMessage.add("Add Quick Delivery to the message");
    } else if (sellerPosMenuInput == 4) {
      sellerPosMessage.add("Product corresponds to description");
    }
    // print out the items held in the arrayList
  }

  public static void buyerPosMenu() {
    ArrayList<String> buyerPosMessage = new ArrayList<String>();
    Scanner buyerPosMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("1. Great buyer");
    System.out.println("2. Trustworthy buyer");
    System.out.println("3. Prompt payment");
    System.out.println("4.Excellent communication  ");
    System.out.println("5. very pleased");
    System.out.println("6. fast payment");
    int buyerPosMenuInput = Integer.parseInt(buyerPosMenuScanner.nextLine());
    if (buyerPosMenuInput == 1) {
      buyerPosMessage.add("Great buyer");
    } else if (buyerPosMenuInput == 2) {
      buyerPosMessage.add("Trustworthy buyer");
    } else if (buyerPosMenuInput == 3) {
      buyerPosMessage.add("Prompt payment");
    } else if (buyerPosMenuInput == 4) {
      buyerPosMessage.add("Excellent communication ");
    }else if (buyerPosMenuInput == 5) {
      buyerPosMessage.add("very pleased");
    }else if (buyerPosMenuInput == 6) {
      buyerPosMessage.add("fast payment");
    }
    // print out the items held in the arrayList
  }

    public static void sellerNegMenu(){
      ArrayList<String> sellerNegMessage = new ArrayList<String>();
      Scanner sellerNegMenuScanner = new Scanner(System.in);
      System.out.println("Input the number corresponding to the option below:");
      System.out.println("1. Wouldn't Recommend seller");
      System.out.println("2. Avoid Seller");
      System.out.println("3. Slow Delivery");
      System.out.println("4. Product doesn't match item description");
      int sellerNegMenuInput = Integer.parseInt(sellerNegMenuScanner.nextLine());
      if (sellerNegMenuInput == 1) {
        sellerNegMessage.add("Wouldn't Recommend seller");
      } else if (sellerNegMenuInput == 2) {
        sellerNegMessage.add("Avoid Seller");
      } else if (sellerNegMenuInput == 3) {
        sellerNegMessage.add("Slow Delivery");
      } else if (sellerNegMenuInput == 4) {
        sellerNegMessage.add("Product doesn't match item description");
      }
      // print out the items held in the arrayList
    }
  public static void buyerNegMenu(){
    ArrayList<String> buyerNegMessage = new ArrayList<String>();
    Scanner buyerNegMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("1. Delayed shipping");
    System.out.println("2. Seller hard to work with");
    System.out.println("3. Item never arrived");
    System.out.println("4. Insufficient packaging. Item arrived damaged");
    int buyerNegMenuInput = Integer.parseInt(buyerNegMenuScanner.nextLine());
    if (buyerNegMenuInput == 1) {
      buyerNegMessage.add("Delayed shipping");
    } else if (buyerNegMenuInput == 2) {
      buyerNegMessage.add("Seller hard to work with");
    } else if (buyerNegMenuInput == 3) {
      buyerNegMessage.add("Item never arrived");
    } else if (buyerNegMenuInput == 4) {
      buyerNegMessage.add("Insufficient packaging. Item arrived damaged");
    }
    // print out the items held in the arrayList
  }
  }