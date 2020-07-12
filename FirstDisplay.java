//welcome display of the server
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FirstDisplay {

	public JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton showListButton;
	private JButton changePriceButton;
	private JTable trackTable;
	private JLabel trackTableTitle;
	private JScrollPane scrollPane_1;


	public FirstDisplay() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBackground(Color.WHITE);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 2000);
		frame.setResizable(false); 
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 89, 582, 154);
		frame.getContentPane().add(scrollPane);
	
		//display 8 stock items in a table. table is not editable and resizable
		table = new JTable();
		table.setForeground(new Color(0, 51, 102));
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"FB",StockDB.getStockUnit("FB").getSecurityName(),null},
				{"VRTU",StockDB.getStockUnit("VRTU").getSecurityName(),null},
				{"MSFT",StockDB.getStockUnit("MSFT").getSecurityName(),null},
				{"GOOGL",StockDB.getStockUnit("GOOGL").getSecurityName(),null},
				{"YHOO",StockDB.getStockUnit("YHOO").getSecurityName(),null},
				{"XLNX",StockDB.getStockUnit("XLNX").getSecurityName(),null},
				{"TSLA",StockDB.getStockUnit("TSLA").getSecurityName(),null},
				{"TXN",StockDB.getStockUnit("TXN").getSecurityName(),null}
			},
			new String[] {
				"Symbol", "Security Name", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(1000);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		JLabel titleLabel = new JLabel("Welcome To StockExchange");
		titleLabel.setForeground(new Color(204, 204, 153));
		titleLabel.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(149, 24, 657, 54);
		frame.getContentPane().add(titleLabel);
		
		showListButton = new JButton(" Show The List Of Stock Items");
		showListButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		showListButton.setBounds(666, 89, 290, 48);
		frame.getContentPane().add(showListButton);
		
		changePriceButton = new JButton("Change Current Price");
		changePriceButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		changePriceButton.setBounds(666, 195, 290, 48);
		frame.getContentPane().add(changePriceButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 347, 921, 292);
		frame.getContentPane().add(scrollPane_1);
		
		//table to show offer variation.table is not editable and resizable
		trackTable = new JTable();
		trackTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Client Name", "Symbol", "Date", "Time", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		trackTable.getColumnModel().getColumn(0).setResizable(false);
		trackTable.getColumnModel().getColumn(0).setPreferredWidth(800);
		trackTable.getColumnModel().getColumn(1).setResizable(false);
		trackTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		trackTable.getColumnModel().getColumn(2).setResizable(false);
		trackTable.getColumnModel().getColumn(2).setPreferredWidth(400);
		trackTable.getColumnModel().getColumn(3).setResizable(false);
		trackTable.getColumnModel().getColumn(3).setPreferredWidth(400);
		trackTable.getColumnModel().getColumn(4).setResizable(false);
		trackTable.getColumnModel().getColumn(4).setPreferredWidth(200);
		scrollPane_1.setViewportView(trackTable);
		
		trackTableTitle = new JLabel("Offers varied with time");
		trackTableTitle.setForeground(new Color(204, 204, 153));
		trackTableTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		trackTableTitle.setBounds(63, 304, 845, 32);
		frame.getContentPane().add(trackTableTitle);
	}
	//return buttons and tables
    public JButton getchangePriceButton () {
        return changePriceButton ;
    }

    public JButton getshowListButton() {
        return showListButton;
    }
     public JTable gettable() {
        return table;
    }
	public JTable gettrackTable() {
        return trackTable;
    }
}

