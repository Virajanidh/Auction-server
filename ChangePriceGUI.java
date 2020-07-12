//Gui that use to change price of a stock item by server
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangePriceGUI {
	
	public JFrame frame2;
	private JTextField textsymbol;
	private JTextField textprice;
	private JTextField textNewPrice;
	private JTextField textName;
	private JButton applyChng;
	private JButton btnsearch;

	public ChangePriceGUI() {
		initialize();
	}

	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		frame2.getContentPane().setBackground(new Color(0, 51, 102));
		frame2.getContentPane().setForeground(new Color(0, 0, 0));
		frame2.setBounds(100, 100, 1313, 732);
		frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel priceChange = new JLabel("Change Price");
		priceChange.setHorizontalAlignment(SwingConstants.CENTER);
		priceChange.setFont(new Font("Tahoma", Font.PLAIN, 43));
		priceChange.setForeground(new Color(238, 232, 170));
		priceChange.setBounds(221, 25, 655, 55);
		frame2.getContentPane().add(priceChange);
		
		JLabel lblEnterThe = new JLabel("Enter the Symbol of StockItem :");
		lblEnterThe.setForeground(new Color(255, 255, 255));
		lblEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterThe.setBounds(57, 167, 512, 41);
		frame2.getContentPane().add(lblEnterThe);
		
		textsymbol = new JTextField();
		textsymbol.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textsymbol.setBounds(603, 167, 306, 47);
		frame2.getContentPane().add(textsymbol);
		textsymbol.setColumns(10);
		
		JLabel lblCurrentPrice = new JLabel("Current Price :");
		lblCurrentPrice.setForeground(new Color(255, 255, 255));
		lblCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCurrentPrice.setBounds(57, 352, 512, 41);
		frame2.getContentPane().add(lblCurrentPrice);
		
		textprice = new JTextField();
		textprice.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textprice.setColumns(10);
		textprice.setBounds(603, 352, 612, 47);
		frame2.getContentPane().add(textprice);
		
		applyChng = new JButton("Apply Changes");
		applyChng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		applyChng.setBounds(994, 597, 221, 61);
		frame2.getContentPane().add(applyChng);
		
		JLabel lblEnterNewPrice = new JLabel("Enter New Price :");
		lblEnterNewPrice.setForeground(new Color(255, 255, 255));
		lblEnterNewPrice.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterNewPrice.setBounds(57, 467, 512, 41);
		frame2.getContentPane().add(lblEnterNewPrice);
		
		textNewPrice = new JTextField();
		textNewPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textNewPrice.setColumns(10);
		textNewPrice.setBounds(603, 467, 612, 47);
		frame2.getContentPane().add(textNewPrice);
		
		JLabel lblNameOfThe = new JLabel("Name of the Stock Item :");
		lblNameOfThe.setForeground(Color.WHITE);
		lblNameOfThe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNameOfThe.setBounds(57, 282, 512, 41);
		frame2.getContentPane().add(lblNameOfThe);
		
		textName = new JTextField();
		textName.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textName.setColumns(10);
		textName.setBounds(603, 282, 612, 47);
		frame2.getContentPane().add(textName);
		
		btnsearch = new JButton("Search");
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnsearch.setBackground(new Color(176, 224, 230));
		btnsearch.setBounds(1020, 172, 195, 42);
		frame2.getContentPane().add(btnsearch);
	}
 
 //return buttons and text fields
	public JButton getapplyChng() {
        return applyChng;
    }
	public JButton getbtnsearch() {
        return btnsearch;
    }
	
	public JTextField gettextsymbol() {
        return textsymbol;
    }
	public JTextField gettextprice() {
        return textprice;
    }
	public JTextField gettextNewPrice() {
        return textNewPrice;
    }
	public JTextField gettextName() {
        return textName;
    }

}


