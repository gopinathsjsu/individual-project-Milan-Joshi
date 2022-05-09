import builder.InventoryBuilder;
import builder.OrderBuilder;
import builder.CardBuilder;
import response.ValidateOrder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Billing {

    private static String Inventory_Details="Inventory.csv";
    private static String Card_Details="Card.csv";
    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Please enter the input file name");
        String inputData=scanner.nextLine();
        //Inventory build
       InventoryBuilder.buildInventory(Inventory_Details);
        //Card data build
        CardBuilder.buildCard(Card_Details);
        //Input build
        OrderBuilder.buildOrder(inputData);

        //validation
        ValidateOrder validateOrder = new ValidateOrder();
        validateOrder.validateStock();

    }

}
