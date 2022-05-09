package builder;

import model.Card;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CardBuilder {
    public static HashMap<String, Card> cardMap=new HashMap<>();
    public static void buildCard(String file){
        try{
        BufferedReader br=new BufferedReader(new FileReader(file));
        br.readLine();
        String cardNumber="";
        while((cardNumber= br.readLine())!=null){
            Card card=new Card(cardNumber);
            cardMap.put(cardNumber,card);
        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
