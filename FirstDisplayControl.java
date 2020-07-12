//control welcome gui of server
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

public class FirstDisplayControl extends Thread {

    private static FirstDisplay gui_1;

    public FirstDisplayControl() {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui_1 = new FirstDisplay();
                    gui_1.frame.setVisible(true);

                    // Action listner for change price button
                    gui_1.getchangePriceButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            changePrice();
                        }
                    });
                    // Action listner for show stock list button
                    gui_1.getshowListButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            listStock();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // change price by server
    private void changePrice() {
        new ChangePriceGUIControl();
    }

    // display the stock list
    private void listStock() {
        new ListStockControl();
    }

    // update the price of 8 items in the display
    private void loop() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Logger.getLogger(FirstDisplayControl.class.getName()).log(Level.SEVERE, null, e);
            }
            DefaultTableModel table = (DefaultTableModel) gui_1.gettable().getModel();
            ChangesInGui.setDisplayStockUnits(gui_1, table);
        }
    }

    // update the log table to show offer variation
    public static void addDetailsToTable(Offer addOffer) {
        DefaultTableModel Tracktable = (DefaultTableModel) gui_1.gettrackTable().getModel();
        ChangesInGui.updateTrackTable(addOffer, Tracktable);
      
        
    }
    

    
    public void run() {
        loop();
    }
    
    
    
}

