
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import java.util.Random;

//database for stock items. details are read  from stocks.csv file
public class StockDB {
    private static HashMap<String, StockUnit> mapToDB;
    private String csvFile = "stocks.csv";
    private BufferedReader bRead = null;
    private int rangeMin = 1;
    private int rangeMax = 10;
    Random rand = new Random();
    // symbol is used as the key of hash map

    public StockDB() {

        mapToDB = new HashMap<String, StockUnit>();
        try {

            bRead = new BufferedReader(new FileReader(csvFile));
            String line = null;

            while ((line = bRead.readLine()) != null) {
                String str[] = line.split(",");

                // price value is a random value
                double price = Math.round((rangeMin + (rangeMax - rangeMin) * rand.nextDouble()) * 100.0) / 100.0;
                StockUnit newItem = new StockUnit(price, str[1], str[0]);
                mapToDB.put(str[0], newItem);
            }

            if (bRead != null)
                bRead.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static StockUnit getStockUnit(String symbol) {
        return mapToDB.get(symbol);
    }

    public static void setPrice(String symbol, double price) {
        StockUnit item = mapToDB.get(symbol);
        item.setPrice(price);
        mapToDB.put(symbol, item); // put updated price in stock database
    }

    //check if symbol is exists
    public static boolean isExist(String symbol) {
        return mapToDB.containsKey(symbol);
    }

    //get the details of one stock item
    public static Collection<StockUnit> getValues() {
        return mapToDB.values();
    }

}
