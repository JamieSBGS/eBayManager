import java.util.ArrayList;
import java.util.Scanner;

public class ebayMessageGenerator{
  
  public static void genMenu(){
    Scanner genMenuInput = new Scanner(System.in);

    System.out.println("Welcome to the Ebay message generator.");
    System.out.println("Input the number corresponding to the option:");
    System.out.println("1. Seller Feedback");
    System.out.println("2. Buyer feedback");
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

  public static void sellerFeedbackGen(){
    Scanner positiveOrNegativeScanner = new Scanner(System.in);
    ArrayList<String> sellerFeedbackMessage = new ArrayList<String>();
    System.out.println("Is the feedback Positive or Negative?");
    String feedbackType = positiveOrNegativeScanner.nextLine();
    if(feedbackType.equals("Positive") || feedbackType.equals("positive")){
      sellerPosMenu();
    } else if(feedbackType.equals("Negative") || feedbackType.equals("negative")){
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
    }
  }