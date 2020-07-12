
//control the displaying stock list
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;


public class ListStockControl {
	
    private ListStockScreen window2;
	
    public ListStockControl() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window2 = new ListStockScreen();
					window2.frame3.setVisible(true);
					addToTable();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    }
	
    //add all stock item details in to the table 
    private void addToTable(){
        DefaultTableModel allitems = (DefaultTableModel)window2.gettable_stockList().getModel();
        for (StockUnit itemArray_stock : StockDB.getValues()) {
            Object[] newRow = {itemArray_stock.getSymbol(), itemArray_stock.getSecurityName(), itemArray_stock.getPrice()};
            allitems.addRow(newRow);
        }
        
    }
    
}
