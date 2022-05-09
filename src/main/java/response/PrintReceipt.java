package response;

import builder.InventoryBuilder;
import builder.OrderBuilder;

import model.Order;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrintReceipt implements BillingHandler{

    private BillingHandler next;

    private String OUTPUT_FILE_NAME = "Output.csv";

    public void setBillingHandler(BillingHandler nextBillingHandler) {
        this.next = nextBillingHandler;
    }

    public void validateStock() throws IOException  {

        double totalPrice = 0;
        List<Order> orderList = OrderBuilder.orderList;
        List<String[]> dataLines = new ArrayList<>();

        String[] header = { "Item", "Quantity", "Price", "Total Price" };

        dataLines.add(header);
        for (Order order : orderList) {

            String itemName = order.getItem();
            String itemQuantity = String.valueOf(order.getQuantity());
            double price_per_unit = InventoryBuilder.inventoryMap.get(order.getItem()).getPrice();
            int quantity = order.getQuantity();
            String price = String.valueOf(quantity * price_per_unit);
            String empty ="";
            dataLines.add(new String[] {itemName, itemQuantity, price, empty});
        }
        for (Order order : orderList) {

            int itemQuantity = order.getQuantity();
            double price = itemQuantity * InventoryBuilder.inventoryMap.get(order.getItem()).getPrice();
            totalPrice += price;
        }
        dataLines.get(1)[3] = String.valueOf(totalPrice);
        File csvOutputFile = new File(OUTPUT_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
        System.out.println("Receipt has been generated in Output.csv ");
    }

    public String convertToCSV(String[] data) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for(String str : data) {
            if(str == null || str.trim().isEmpty())
                break;
            sb.append(str);
            sb.append("                  ");
            sb.replace(index * 18, sb.length(), "");
            index++;
        }
        return sb.toString();
    }


}
