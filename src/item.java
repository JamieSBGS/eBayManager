import java.util.Scanner;

public class item {
  private String itemName;
  private float price;
  private int stockNum;
  private String itemType;
  private String itemID;
  private float netProfit;

  public item(String itemName, float price, int stockNum, String itemType, String itemID) {
    this.itemName = itemName;
    this.price = price;
    this.stockNum = stockNum;
    this.itemType = itemType;
    this.itemID = itemID;
    this.netProfit = calculateNetProfit();
  }

  @Override
  public String toString() {
    return itemName + " , " + price + " , " + stockNum + " , " + itemType + " , " + itemID;
  }

  public String getItemName() {
    return itemName;
  }

  public float getPrice() {
    return price;
  }

  public int getStockNum() {
    return stockNum;
  }

  public String getItemType() {
    return itemType;
  }

  public String getItemID() {
    return itemID;
  }

  public float calculateNetProfit() {
    float tax = (float) 0.80;
    return getPrice() * tax;
  }

  public float getNetProfit() {
    return netProfit;
  }

  public void changeStockNum(int i){
    int prodNumber = i;
    Scanner stockInput = new Scanner(System.in);
    int newStockValue = Integer.parseInt(stockInput.nextLine());
    stockNum = newStockValue;
    item itemIndex = FileHandler.Products.get(prodNumber);
    String itemToPrint = itemIndex.toString();
    double netProfit = itemIndex.getNetProfit();
    itemToPrint += ", " + netProfit;
    System.out.println(itemToPrint);
  }
}
