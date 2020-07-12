//control the server price changing gui
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import java.awt.EventQueue;


public class ChangePriceGUIControl {
    private ChangePriceGUI window;
    
    public ChangePriceGUIControl() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ChangePriceGUI();
					window.frame2.setVisible(true);
					//check if the applychanges button pressed
					window.getapplyChng().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							applyChngAction();
						}
                    });
                    //check if the search button pressed
					window.getbtnsearch().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							btnsearchAction();
						}
					});

				}
			catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
	
	public void btnsearchAction(){
		String symbol=window.gettextsymbol().getText();
		
		if(!StockDB.isExist(symbol)){ //check if searched item is available.If not show error masssage .Server can try again
           window.gettextName().setText("This Stock Item is currently unavailable");
           
		}

		else{
           window.gettextName().setText(StockDB.getStockUnit(symbol).getSecurityName()); //get name accoding to the symbol
           window.gettextprice().setText(""+StockDB.getStockUnit(symbol).getPrice()); ////get price accoding to the symbol
           window.gettextNewPrice().setEnabled(true); //allow to enter new price
           window.getapplyChng().setEnabled(true);
       }
	}
    private void applyChngAction(){
		
		try{
        
			double newPrice=Double.parseDouble(window.gettextNewPrice().getText());  //new price changed by server
			//update stockDB and OfferDB
			StockDB.setPrice(window.gettextsymbol().getText(), newPrice); 
			Offer update =new Offer("By Server", window.gettextsymbol().getText(), new Date(), newPrice);
			OfferDB.addOffer(update); 
			window.frame2.dispose();
        }
		catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Entered price is invalid"); //if value is not in correct data format
        }	
		
	}
	
	
   
    
}

