import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ChangesInGui {

	// change values of 8 stocks items
	public static void setDisplayStockUnits(FirstDisplay gui, DefaultTableModel table) {

		table.setValueAt(Double.toString(StockDB.getStockUnit("FB").getPrice()), 0, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("VRTU").getPrice()), 1, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("MSFT").getPrice()), 2, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("GOOGL").getPrice()), 3, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("YHOO").getPrice()), 4, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("XLNX").getPrice()), 5, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("TSLA").getPrice()), 6, 2);
		table.setValueAt(Double.toString(StockDB.getStockUnit("TXN").getPrice()), 7, 2);

	}

	// update display log
	public static void updateTrackTable(Offer addOffer, DefaultTableModel Tracktable) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String date = dateFormat.format(addOffer.getDate());
		String time = timeFormat.format(addOffer.getDate());
		Object newRow[] = { addOffer.getClientName(), addOffer.getSymbol(), date, time, addOffer.getPrice() };
		Tracktable.addRow(newRow);
	}

}