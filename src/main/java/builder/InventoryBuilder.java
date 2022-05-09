package builder;

import model.Inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class InventoryBuilder {
    public static HashMap<String, Inventory> inventoryMap=new HashMap<>();
    public static void buildInventory (String file) throws FileNotFoundException {
        try{
        BufferedReader br =new BufferedReader(new FileReader(file));
        br.readLine();
        String inventory="";
        while((inventory=br.readLine())!=null){
            String[] inventoryArr=inventory.split(",");
            String item=inventoryArr[0];
            String category=inventoryArr[1];
            int quantity=Integer.parseInt(inventoryArr[2]);
            int price=Integer.parseInt((inventoryArr[3]));
            Inventory items=new Inventory(item,category,quantity,price);
            inventoryMap.put(item,items);

        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
