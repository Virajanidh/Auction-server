import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
//control client gui functionality

public class ClientControl {
	private ClientGUI window3;
	private String ClientName; // variable for client's name
	private String symbol; // variable to get symbol of security
	private static HashMap<String, String> userName = new HashMap<String, String>();
	// this userName HashMap will store the details of client name and symbol.
	// client name is the key
	private int count = 1;

	public ClientControl() {

		window3 = new ClientGUI();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window3.frame4.setVisible(true);

					// search button action
					window3.getbtnSearch().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							btnSearchAction();
						}
					});
					// OK button action
					window3.getbtnOK().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							btnOKAction();
						}
					});
					// Confirm button action
					window3.getbtnConfirm().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							btnConfirmAction();
						}
					});
					// Confirm and bid again button action
					window3.getbtnConfirmAndBid().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							btnConfirmAndBidAction();
						}
					});

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	public void btnSearchAction() {

		symbol = window3.gettxtSymbol().getText(); // get symbol
		ClientName = window3.gettxtCname().getText(); // get client name

		if (ClientName.isEmpty()) { // check if user name is available.If not show error masssage.
			window3.gettxtStatus().setText("Please enter a valid name first");
		}

		else if (!StockDB.isExist(symbol)) { // check if searched item is available.If not show error masssage .Client
												// can try again
			window3.gettxtStatus().setText("Please enter a valid Symbol");
		} else { // when given symbol is available
			window3.gettxtStatus().setText("This Stock Item is available");
			window3.gettxtName().setText(StockDB.getStockUnit(symbol).getSecurityName()); // get name accoding to the
																							// symbol
			window3.gettxtCprice().setText("" + StockDB.getStockUnit(symbol).getPrice()); //// get current price
																							//// accoding to the symbol
			window3.gettxtNewBid().setEnabled(true); // allow to enter new price
			window3.getbtnConfirm().setEnabled(true);
			window3.getbtnConfirmAndBid().setEnabled(true);
		}
	}

	// confirm button is used when client wand to finish after bidding
	private void btnConfirmAction() {

		// client name is checked in button confirm action too
		if (userName.containsKey(ClientName)) {
			userName.remove(ClientName); // remove client from server
			window3.frame4.dispose();
		} else {
			window3.frame4.dispose();
		}

	}

	// confirm and Bid button used when Client want to bid on the given Symbol again
	private void btnConfirmAndBidAction() {

		try {
			// client name is checked in button confirm action too
			if (userName.containsKey(ClientName) && count == 1) {
				JOptionPane.showMessageDialog(null, "Entered name is not available.");
				// window3.getbtnConfirmAndBid().setEnabled(false);
				// window3.getbtnConfirm().setEnabled(false);

			} else {
				updateDB(); // update databases
				window3.gettxtNewBid().setText(""); // clear new bid text box
				window3.gettxtCprice().setText("" + StockDB.getStockUnit(symbol).getPrice()); // show updated current
																								// price
				window3.gettxtStatus().setText(""); // clear new bid text box
				window3.gettxtCname().setEnabled(false);
				count += 1;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Entered price is invalid"); // if value is not in correct data format
		}
	}

	private void btnOKAction() {

		try {

			symbol = window3.gettxtSymbol().getText(); // get symbol
			ClientName = window3.gettxtCname().getText(); // get client name
			double newPrice = Double.parseDouble(window3.gettxtNewBid().getText());

			if (ClientName.isEmpty()) { // check if user name is available.If not show error masssage.
				// if value is not in correct data format
				window3.gettxtStatus().setText("Please enter a valid name first");
			} else if (!StockDB.isExist(symbol)) { // check if user name is available.If not show error masssage.
				window3.gettxtStatus().setText("Please enter a valid symbol");
			}
			// bid value must be higher than current price .check it
			else if (newPrice <= StockDB.getStockUnit(symbol).getPrice()) {
				window3.gettxtStatus().setText("Bid must be higher than current price");
			} else {
				window3.gettxtStatus().setText("price is acceptable");
			}
		} catch (NumberFormatException e) {
			window3.gettxtStatus().setText("Invalid Bid format");
		}

	}

	private void updateDB() {

		try {

			symbol = window3.gettxtSymbol().getText(); // get symbol

			// only one stock unit is put to Stock Database in 500ms
			StockUnit item = StockDB.getStockUnit(symbol);
			synchronized (item) {
				ClientName = window3.gettxtCname().getText(); // get client name
				double newPrice = Double.parseDouble(window3.gettxtNewBid().getText());

				if (ClientName.isEmpty()) { // check if user name is available.If not show error masssage.
					window3.gettxtStatus().setText("Please enter a valid name first");
				} else if (!StockDB.isExist(symbol)) { // check if user name is available.If not show error masssage.
					window3.gettxtStatus().setText("Please enter a valid symbol");
				}
				// bid value must be higher than current price .check it
				else if (newPrice > StockDB.getStockUnit(symbol).getPrice()) {
					StockDB.setPrice(window3.gettxtSymbol().getText(), newPrice);
					Offer update = new Offer(ClientName, window3.gettxtSymbol().getText(), new Date(), newPrice);
					OfferDB.addOffer(update);
					userName.put(ClientName, symbol);

				}

				else {
					window3.gettxtStatus().setText("Please enter valid data");
				}
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Entered bid price is invalid"); // if value is not in correct data
																					// format
		}

	}

}
