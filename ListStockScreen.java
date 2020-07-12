//display all stock items
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ListStockScreen {

	public JFrame frame3;
	private JTable table_stockList;

	public ListStockScreen() {
		initialize();
	}


	@SuppressWarnings("serial")
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(new Color(72, 61, 139));
		frame3.setBounds(100, 100, 1148, 773);
		frame3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel listtitle = new JLabel("Stock Items");
		listtitle.setForeground(new Color(211, 211, 211));
		listtitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 45));
		listtitle.setHorizontalAlignment(SwingConstants.CENTER);
		listtitle.setBounds(112, 33, 897, 49);
		frame3.getContentPane().add(listtitle);
		frame3.setResizable(false); 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 123, 966, 551);
		frame3.getContentPane().add(scrollPane);
		
		//create stock list table.It is not editable and resizable
		table_stockList = new JTable();
		table_stockList.setBackground(new Color(211, 211, 211));
		table_stockList.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table_stockList);
		table_stockList.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Symbol", "Security Name", "Price ($)"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_stockList.getColumnModel().getColumn(0).setResizable(false);
		table_stockList.getColumnModel().getColumn(0).setPreferredWidth(250);
		table_stockList.getColumnModel().getColumn(1).setResizable(false);
		table_stockList.getColumnModel().getColumn(1).setPreferredWidth(1000);
		table_stockList.getColumnModel().getColumn(2).setResizable(false);
		table_stockList.getColumnModel().getColumn(2).setPreferredWidth(250);
    }
    public JTable gettable_stockList(){
		return table_stockList;
	}
}


