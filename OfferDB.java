
import java.util.ArrayList;

//bid records of clients are stored in offerArray
public class OfferDB {
    private static ArrayList<Offer> offerArray;
    
    public OfferDB() {
        offerArray =new ArrayList<Offer>(); 
    }
    
    public static void addOffer(Offer new_offer){
        offerArray.add(new_offer);
        FirstDisplayControl.addDetailsToTable(new_offer);
    }
    
}
