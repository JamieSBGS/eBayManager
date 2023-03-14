import java.util.Scanner;
import  java.util.ArrayList;
public class ebayItemConstructor {
    private String itemName;
    private int price;
    private int stockNum;
    private String itemType;
  
    public ebayItemConstructor(String itemName, int price, int stockNum, String itemType) {
        this.itemName = itemName;
        this.price = price;
        this.stockNum = stockNum;
        this.itemType = itemType;
    }

    public static class item extends ebayItemConstructor {
        String tempItemName;
        int tempPrice;
        int tempStockNum;
        String tempItemType;
        String tempItemCategory;
      // Implement file handling system to use different txt files to
        // input parameters and get them ready prior to making objects.

        public item(String itemName, int price, int stockNum, String itemType, String itemCategory) {
            super(itemName, price, stockNum, itemType);
            if(itemType.equals("Buy it now")){
                System.out.println("Item has been set to a 'Buy it now' item.");
            } else if(itemType.equals("Auction")){
                System.out.println("Item has been set to an 'Auction' item.");
            }else{
                System.out.println("Item type must be capitalised and must either be 'Buy it now' or 'Auction'");
            }
        }
    }
  public static void productList(){
        ArrayList<item> Products = new ArrayList<item>();
    }
}
