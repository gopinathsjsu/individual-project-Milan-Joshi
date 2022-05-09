package response;

import builder.InventoryBuilder;
import builder.OrderBuilder;
import factory.Category;
import factory.CategoryFactory;
import model.Inventory;
import model.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;



public class ValidateOrder implements BillingHandler {
    private BillingHandler next;
    public static boolean orderValidated=false;

    @Override
    public void setBillingHandler(BillingHandler nextBillingHandler) {
        this.next=nextBillingHandler;
    }
    private static String Error_File="Error.txt";

    @Override
    public void validateStock() throws IOException {
        HashMap<String, Inventory> inventoryStock = InventoryBuilder.inventoryMap;
        List<Order> inputData = OrderBuilder.orderList;
        boolean flag = false;


        CategoryLimit categoryLimit = CategoryLimit.getInstance();
        HashMap<String, Integer> categoryLimitMap = categoryLimit.categoryLimitMap;
        FileWriter writeError = new FileWriter(Error_File);

        for(Order order : inputData) {

            String itemName = order.getItem();
            int orderQuantity = order.getQuantity();
            Inventory inventory = inventoryStock.get(itemName);
            int inventoryQuantity = inventory.getQuantity();
            String categoryStr = inventory.getCategory();

            CategoryFactory categoryFactory = new CategoryFactory();
            Category category = categoryFactory.getCategory(categoryStr);

            int currentCount = category.getCategoryCount();

            int allowedLimit = categoryLimitMap.get(categoryStr);
            boolean withInInventory = inventoryQuantity - orderQuantity >= 0;
            boolean withInAllowed = allowedLimit - (orderQuantity+currentCount) >= 0;
            if(withInInventory && withInAllowed) {
                inventory.setQuantity(inventoryQuantity - orderQuantity);
                category.setCategoryCount(orderQuantity);
            } else {
                writeError.write("Cannot proceed to payment because "+itemName +  (!withInAllowed ? " has exceeded the category("
                        + categoryStr + ") limit. Please resubmit the order with quantity no greater than "+ (allowedLimit - currentCount) : " of quantity "+orderQuantity +
                        " does not contain in the inventory. Resubmit the order with quantity no greater than "+inventoryQuantity+" for successful " +
                        "transaction") );
                writeError.write("\n");
                flag = true;
            }
        }
        if (flag) {
            try {
                writeError.close();
                System.out.println(
                        "Cannot proceed to the payment. Please check Error.txt for more details");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        orderValidated = true;
        PrintReceipt receipt = new PrintReceipt();
        this.setBillingHandler(receipt);
        next.validateStock();
    }
}
