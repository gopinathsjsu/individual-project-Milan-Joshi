package builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.Card;

public class OrderBuilder {
    public static List<Order> orderList=new ArrayList<>();
    public static void buildOrder(String file){
        boolean header=false;
        try{

            BufferedReader br=new BufferedReader(new FileReader(file));
            String orderStr="";
            while ((orderStr=br.readLine())!=null){
                if(!header) {
                    header = true;
                    continue;
                }
                String[] orderArr=orderStr.split(",");
                String item=orderArr[0];

                int quantity=Integer.parseInt(orderArr[1]);
                Card card=null;
                if(orderArr.length > 2) {
                    String cardNumber = orderArr[2];
                    if(!cardNumber.trim().isEmpty() && !CardBuilder.cardMap.containsKey(cardNumber)) {
                        card = new Card(cardNumber);
                        CardBuilder.cardMap.put(cardNumber, card);
                    }
                    card = new Card(cardNumber);


                }
                Order order=new Order(item,quantity,card);
                orderList.add(order);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
