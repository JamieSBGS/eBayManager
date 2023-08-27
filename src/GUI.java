import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private static final Dimension userScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ebay Manager GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int testWidth = (userScreenSize.width / 3)- 50;
            int testHeight = userScreenSize.height / 3;

            // Create buttons
            JButton messageButton = new JButton("Message Generator");
            JButton inventoryButton = new JButton("Inventory Manager");
            JButton ChangePath = new JButton("Change Path");

            // Set layout manager
            frame.setLayout(new BorderLayout());

            // Add buttons to the content pane
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(messageButton);
            buttonPanel.add(inventoryButton);
            buttonPanel.add(ChangePath);

            frame.add(buttonPanel, BorderLayout.NORTH);

            // Load and scale the image
            ImageIcon originalImageIcon = new ImageIcon(GUI.class.getResource("/ebaymanagerlogo.png"));
            Image originalImage = originalImageIcon.getImage();
            int scaledWidth = (int) (testWidth/1.6);
            int scaledHeight = (int) (testHeight/1.6);
            Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

            // Add scaled image label to the content pane
            JLabel imageLabel = new JLabel(scaledImageIcon);
            frame.add(imageLabel, BorderLayout.CENTER);

            frame.setSize(testWidth, testHeight);
            frame.setVisible(true);

            // Add action listeners for the buttons
            messageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showMessageGeneratorMenu();
                }
            });

            inventoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showInventoryManagerMenu();
                }
            });

            ChangePath.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fieldPathName = JOptionPane.showInputDialog(frame, "Enter CSV File Path");
                    FileHandler.setPath(fieldPathName);
                }
            });
        });
    }

    public static void showMessageGeneratorMenu() {
        JFrame messageFrame = new JFrame("Message Generator");
        messageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        messageFrame.setSize(400, 300);

        // Create buttons for message generator
        JButton ebayButton = new JButton("Ebay Generator");
        JButton aliButton = new JButton("AliExpress Generator");

        // Set layout manager
        messageFrame.setLayout(new FlowLayout());

        // Add buttons to the content pane
        messageFrame.add(ebayButton);
        messageFrame.add(aliButton);

        messageFrame.setVisible(true);

        // Add action listeners for the message generator buttons
        ebayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the eBay message generator method
                ebayFeedbackType();
            }
        });

        aliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the AliExpress message generator method
                aliMessageGenerator();
            }
        });
    }

    public static void showInventoryManagerMenu() {
        JFrame inventoryFrame = new JFrame("Inventory Manager");
        inventoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inventoryFrame.setSize(400, 70);

        // Create buttons for inventory manager
        JButton displayButton = new JButton("Display Items");
        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove Item");

        // Set layout manager
        inventoryFrame.setLayout(new FlowLayout());

        // Add buttons to the content pane
        inventoryFrame.add(displayButton);
        inventoryFrame.add(addButton);
        inventoryFrame.add(removeButton);

        inventoryFrame.setVisible(true);

        // Add action listeners for the inventory manager buttons
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame displayFrame = new JFrame("Display Items");
                displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                displayFrame.setSize(600, 400);
                // Create a DefaultTableModel and JTable
                DefaultTableModel tableModel = new DefaultTableModel(
                        new Object[]{"Item Name", "Price", "Stock", "Type", "ID", "Net Profit"}, 0);

                JTable table = new JTable(tableModel);

                // Populate the table with data from the Products ArrayList
                for (item itemIndex : FileHandler.Products) {
                    Object[] rowData = {
                            itemIndex.getItemName(),
                            itemIndex.getPrice(),
                            itemIndex.getStockNum(),
                            itemIndex.getItemType(),
                            itemIndex.getItemID(),
                            itemIndex.getNetProfit()
                    };
                    tableModel.addRow(rowData);
                }

                // Set layout manager
                displayFrame.setLayout(new BorderLayout());

                // Add the table to the content pane
                JScrollPane scrollPane = new JScrollPane(table);
                displayFrame.add(scrollPane, BorderLayout.CENTER);

                displayFrame.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fieldItemName = JOptionPane.showInputDialog(inventoryFrame, "Enter Item Name:");
                String fieldPriceStr = JOptionPane.showInputDialog(inventoryFrame, "Enter Price:");
                float fieldPrice = Float.parseFloat(fieldPriceStr);
                String fieldStockNumStr = JOptionPane.showInputDialog(inventoryFrame, "Enter Stock Number:");
                int fieldStockNum = Integer.parseInt(fieldStockNumStr);
                String fieldItemType = JOptionPane.showInputDialog(inventoryFrame, "Enter Item Type:");
                String fieldItemID = JOptionPane.showInputDialog(inventoryFrame, "Enter Item ID:");

                FileHandler.addItem(fieldItemName, fieldPrice, fieldStockNum, fieldItemType, fieldItemID);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fieldItemName = JOptionPane.showInputDialog(inventoryFrame, "Enter Item Name:");
                FileHandler.removeProduct(fieldItemName);
            }
        });
    }

    public static void ebayFeedbackType() {
        JFrame FeedbackTypeFrame = new JFrame("Ebay Feedback Type");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(400, 200);

        // Create buttons for inventory manager
        JButton BuyerPos = new JButton("Buyer - Positive");
        JButton BuyerNeg = new JButton("Buyer - Negative");
        JButton SellerPos = new JButton("Seller - Positive");
        JButton SellerNeg = new JButton("Seller - Negative");

        // Set layout manager
        FeedbackTypeFrame.setLayout(new FlowLayout());

        FeedbackTypeFrame.add(BuyerPos);
        FeedbackTypeFrame.add(BuyerNeg);
        FeedbackTypeFrame.add(SellerPos);
        FeedbackTypeFrame.add(SellerNeg);

        FeedbackTypeFrame.setVisible(true);

        BuyerPos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayPositiveBuyerFeedback();
            }
        });

        BuyerNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayBuyerNegativeFeedback();
            }
        });

        SellerPos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayPositiveSellerFeedback();
            }
        });

        SellerNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebaySellerNegativeFeedback();
            }
        });
    }

    public static void ebayPositiveSellerFeedback() {
        ArrayList<String> ebayMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("Ebay Positive Seller Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~Ebay Positive Seller Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton FinishClipboard = new JButton("Finish and copy message to clipboard");
        JButton Greatseller = new JButton("Great seller");
        JButton ASeller = new JButton("A++ Seller");
        JButton AddQuickDeliverytothemessage = new JButton("Add Quick Delivery to the message");
        JButton ProductCorrespondsToDesc = new JButton("Product corresponds to description");
        JButton ExcellentCustomerService = new JButton("Excellent customer service");
        JButton HighlyRecommended = new JButton("Highly recommended");
        JButton SmoothTransaction = new JButton("Smooth transaction");
        JButton ReliableSeller = new JButton("Reliable seller");
        JButton FastShipping = new JButton("Fast shipping");
        JButton ImpressivePackaging = new JButton("Impressive packaging");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(FinishClipboard);
        FeedbackTypeFrame.add(Greatseller);
        FeedbackTypeFrame.add(ASeller);
        FeedbackTypeFrame.add(AddQuickDeliverytothemessage);
        FeedbackTypeFrame.add(ProductCorrespondsToDesc);
        FeedbackTypeFrame.add(ExcellentCustomerService);
        FeedbackTypeFrame.add(HighlyRecommended);
        FeedbackTypeFrame.add(SmoothTransaction);
        FeedbackTypeFrame.add(ReliableSeller);
        FeedbackTypeFrame.add(FastShipping);
        FeedbackTypeFrame.add(ImpressivePackaging);

        FeedbackTypeFrame.setVisible(true);

        FinishClipboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(ebayMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                ebayMessage.clear();
            }
        });
        Greatseller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Great Seller");
            }
        });
        ASeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("A++ Seller");
            }
        });
        AddQuickDeliverytothemessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Quick Delivery");
            }
        });
        ProductCorrespondsToDesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Product Corresponds to Description");
            }
        });
        ExcellentCustomerService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Excellent Customer Service");
            }
        });
        HighlyRecommended.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Highly Recommnded");
            }
        });
        SmoothTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Smooth Transaction");
            }
        });
        ReliableSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Reliable Seller");
            }
        });
        FastShipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Fast Shipping");
            }
        });
        ImpressivePackaging.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Impressive Packaging");
            }
        });

    }
    public static void ebayPositiveBuyerFeedback() {
        ArrayList<String> ebayMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("Ebay Positive Buyer Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~Ebay Positive Buyer Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton button0 = new JButton("Finish and copy message to clipboard");
        JButton button1 = new JButton("Great buyer");
        JButton button2 = new JButton("Trustworthy buyer");
        JButton button3 = new JButton("Prompt payment");
        JButton button4 = new JButton("Excellent communication");
        JButton button5 = new JButton("Very pleased");
        JButton button6 = new JButton("Fast payment");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(button0);
        FeedbackTypeFrame.add(button1);
        FeedbackTypeFrame.add(button2);
        FeedbackTypeFrame.add(button3);
        FeedbackTypeFrame.add(button4);
        FeedbackTypeFrame.add(button5);
        FeedbackTypeFrame.add(button6);

        FeedbackTypeFrame.setVisible(true);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(ebayMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                ebayMessage.clear();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Great buyer");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Trustworthy buyer");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Prompt payment");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Excellent communication");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Very pleased");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Fast payment");
            }
        });

    }
    public static void ebaySellerNegativeFeedback() {
        ArrayList<String> ebayMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("Ebay Negative Seller Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~Ebay Negative Seller Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton button0 = new JButton("Finish and copy message to clipboard");
        JButton button1 = new JButton("Wouldn't Recommend seller");
        JButton button2 = new JButton("Avoid Seller");
        JButton button3 = new JButton("Slow Delivery");
        JButton button4 = new JButton("Product doesn't match item description");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(button0);
        FeedbackTypeFrame.add(button1);
        FeedbackTypeFrame.add(button2);
        FeedbackTypeFrame.add(button3);
        FeedbackTypeFrame.add(button4);

        FeedbackTypeFrame.setVisible(true);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(ebayMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                ebayMessage.clear();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Wouldn't Recommend seller");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Avoid Seller");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Slow Delivery");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Product doesn't match item description");
            }
        });

    }
    public static void ebayBuyerNegativeFeedback() {
        ArrayList<String> ebayMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("Ebay Negative Buyer Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~Ebay Negative Buyer Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton button0 = new JButton("Finish and copy message to clipboard");
        JButton button1 = new JButton("Delayed shipping");
        JButton button2 = new JButton("Seller hard to work with");
        JButton button3 = new JButton("Item never arrived");
        JButton button4 = new JButton("Insufficient packaging. Item arrived damaged");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(button0);
        FeedbackTypeFrame.add(button1);
        FeedbackTypeFrame.add(button2);
        FeedbackTypeFrame.add(button3);
        FeedbackTypeFrame.add(button4);

        FeedbackTypeFrame.setVisible(true);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(ebayMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                ebayMessage.clear();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Delayed shipping");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Seller hard to work with");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Item never arrived");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ebayMessage.add("Insufficient packaging. Item arrived damaged");
            }
        });

    }
    public static void aliMessageGenerator() {
        JFrame FeedbackTypeFrame = new JFrame("Ebay Feedback Type");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(400, 200);

        // Create buttons for inventory manager
        JButton SellerPos = new JButton("Seller - Positive");
        JButton SellerNeg = new JButton("Seller - Negative");

        // Set layout manager
        FeedbackTypeFrame.setLayout(new FlowLayout());

        FeedbackTypeFrame.add(SellerPos);
        FeedbackTypeFrame.add(SellerNeg);

        FeedbackTypeFrame.setVisible(true);

        SellerPos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliPositiveSellerFeedback();
            }
        });
        SellerNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliNegativeSellerFeedback();
            }
        });
    }
    public static void aliNegativeSellerFeedback() {
        ArrayList<String> aliMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("AliExpress Negative Seller Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~AliExpress Negative Seller Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton button0 = new JButton("Finish and copy message to clipboard");
        JButton button1 = new JButton("Wouldn't Recommend seller");
        JButton button2 = new JButton("Avoid Seller");
        JButton button3 = new JButton("Slow Delivery");
        JButton button4 = new JButton("Product doesn't match item description");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(button0);
        FeedbackTypeFrame.add(button1);
        FeedbackTypeFrame.add(button2);
        FeedbackTypeFrame.add(button3);
        FeedbackTypeFrame.add(button4);

        FeedbackTypeFrame.setVisible(true);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(aliMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                aliMessage.clear();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Wouldn't Recommend seller");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Avoid Seller");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Slow Delivery");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Product doesn't match item description");
            }
        });

    }
    public static void aliPositiveSellerFeedback() {
        ArrayList<String> aliMessage = new ArrayList<String>();
        JFrame FeedbackTypeFrame = new JFrame("AliExpress Positive Seller Feedback");
        FeedbackTypeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FeedbackTypeFrame.setSize(700, 300);

        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append("~AliExpress Positive Seller Feedback~ To complete and copy message, press Finish and copy message to clipboard.");

        FeedbackTypeFrame.setLayout(new FlowLayout());

        // Create buttons for inventory manager
        JButton FinishClipboard = new JButton("Finish and copy message to clipboard");
        JButton Greatseller = new JButton("Great seller");
        JButton ASeller = new JButton("A++ Seller");
        JButton AddQuickDeliverytothemessage = new JButton("Add Quick Delivery to the message");
        JButton ProductCorrespondsToDesc = new JButton("Product corresponds to description");
        JButton ExcellentCustomerService = new JButton("Excellent customer service");
        JButton HighlyRecommended = new JButton("Highly recommended");
        JButton SmoothTransaction = new JButton("Smooth transaction");
        JButton ReliableSeller = new JButton("Reliable seller");
        JButton FastShipping = new JButton("Fast shipping");
        JButton ImpressivePackaging = new JButton("Impressive packaging");

        FeedbackTypeFrame.add(textArea);
        FeedbackTypeFrame.add(FinishClipboard);
        FeedbackTypeFrame.add(Greatseller);
        FeedbackTypeFrame.add(ASeller);
        FeedbackTypeFrame.add(AddQuickDeliverytothemessage);
        FeedbackTypeFrame.add(ProductCorrespondsToDesc);
        FeedbackTypeFrame.add(ExcellentCustomerService);
        FeedbackTypeFrame.add(HighlyRecommended);
        FeedbackTypeFrame.add(SmoothTransaction);
        FeedbackTypeFrame.add(ReliableSeller);
        FeedbackTypeFrame.add(FastShipping);
        FeedbackTypeFrame.add(ImpressivePackaging);

        FeedbackTypeFrame.setVisible(true);

        FinishClipboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler.copyToClipboard(aliMessage);
                JOptionPane.showMessageDialog(FeedbackTypeFrame, "Message saved to clipboard");
                aliMessage.clear();
            }
        });
        Greatseller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Great Seller");
            }
        });
        ASeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("A++ Seller");
            }
        });
        AddQuickDeliverytothemessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Quick Delivery");
            }
        });
        ProductCorrespondsToDesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Product Corresponds to Description");
            }
        });
        ExcellentCustomerService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Excellent Customer Service");
            }
        });
        HighlyRecommended.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Highly Recommnded");
            }
        });
        SmoothTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Smooth Transaction");
            }
        });
        ReliableSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Reliable Seller");
            }
        });
        FastShipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Fast Shipping");
            }
        });
        ImpressivePackaging.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aliMessage.add("Impressive Packaging");
            }
        });

    }
}