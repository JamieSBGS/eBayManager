import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

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
    }else if(genUserMenuInput == 3){
      System.out.println("Thanks for buying message Selected");
    }
  }

  public static void sellerFeedbackGen(){
    Scanner positiveOrNegativeScanner = new Scanner(System.in);
    Boolean posOrNeg;
    // Pos = True, Neg = False
    ArrayList<String> sellerFeedbackMessage = new ArrayList<String>();
    System.out.println("Is the feedback Positive or Negative?");
    String feedbackType = positiveOrNegativeScanner.nextLine();
    if(feedbackType == "Positive" || feedbackType == "positive"){
      posOrNeg = true;
    } else if(feedbackType == "Negative" || feedbackType == "negative"){
      posOrNeg = false;
    }
    
  }

  public void sellerPosMenu(){
    int i =0;
    Scanner posMenuScanner = new Scanner(System.in);
    System.out.println("Input the number corresponding to the option below:");
    System.out.println("1. Great seller");
    System.out.println("2.A++ Seller");
    System.out.println("3. Add Quick Delivery to the message");
    System.out.println("4. Product corresponds to description");
    
  }
}