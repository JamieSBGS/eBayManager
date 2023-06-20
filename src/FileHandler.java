import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static ArrayList<item> Products = new ArrayList<item>();
    private  static String Path;

    public static String checkSavedPath(){
        return Path;
    }

    public static void savePath(){
        String fileName = "config.txt";
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter("config.txt", append))) {
            pr.println(Path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static String setPath() {
        Scanner userPathInput = new Scanner(System.in);
        System.out.println("Insert path name of the .csv file which contains the product list");
        String inputtedPath = userPathInput.nextLine();

        if (inputtedPath != null && inputtedPath.endsWith(".csv")) {
            Path = inputtedPath;
            return Path;
        } else {
            System.out.println("Invalid path inputted or the file doesn't have a .csv extension. Please try again.");
            System.out.println("");
            return setPath(); // Recursive call to restart the method
        }
    }

    public static String getPath(){
        return Path;
    }

    public static void readCSV() {
        try {
            File csvObj = new File(getPath());
            BufferedReader br = new BufferedReader(new FileReader(csvObj));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                item csvProduct = new item(values[0], Float.parseFloat(values[1]), Integer.parseInt(values[2]), values[3],
                        values[4]);
                Products.add(csvProduct);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<item> getList() {
        return Products;
    }

    public static void clearProductList() {
        Products.clear();
    }

    public static void addItem() {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Insert Item name");
        String fieldItemName = UserInput.nextLine();

        System.out.println("Insert Price");
        float fieldPrice = Float.parseFloat(UserInput.nextLine());

        System.out.println("Insert how much of the item is in stock");
        int fieldStockNum = Integer.parseInt(UserInput.nextLine());

        System.out.println("Insert the item's category");
        String fieldItemType = UserInput.nextLine();

        System.out.println("Insert the item's ID");
        String fieldItemID = UserInput.nextLine();

        item addedProduct = new item(fieldItemName, fieldPrice, fieldStockNum, fieldItemType, fieldItemID);
        Products.add(addedProduct);

        // Writing to CSV file part
        String[] addedProdFields = { addedProduct.getItemName(), String.valueOf(addedProduct.getPrice()),
                String.valueOf(addedProduct.getStockNum()), addedProduct.getItemType(), addedProduct.getItemID() };

        try {
            FileWriter writer = new FileWriter("C:\\Users\\Jamie\\IdeaProjects\\eBay Manager\\src\\ProductList.csv", true);
            writer.append("\n");
            for (int i = 0; i < addedProdFields.length; i++) {
                writer.append(addedProdFields[i]);

                if (i != addedProdFields.length - 1) {
                    writer.append(",");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayProducts() {
        System.out.println("");
        System.out.println("The currently stored products:");
        System.out.println("Item Name, Price, Stock Number, Item Type, Item ID ");
        for (int i = 0; i < Products.size(); i++) {
            item itemIndex = Products.get(i);
            String itemToPrint = itemIndex.toString();
            System.out.println(itemToPrint);
        }
    }

    public static class Notification {
        public static void stockAlert() {
            for (item item : Products) {
                if (item.getStockNum() == 1) {
                    System.out.println("Alert: Only 1 " + item.getItemName() + " left.");
                } else if (item.getStockNum() == 0) {
                    System.out.println("Alert: " + item.getItemName() + " is out of stock.");
                }
            }
        }
    }
}