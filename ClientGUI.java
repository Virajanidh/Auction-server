import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
//client gui that visible to clients
public class ClientGUI {

	public JFrame frame4;
	private JTextField txtSymbol;
	private JTextField textCname;
	private JTextField txtName;
	private JTextField textCprice;
	private JTextField textstatus;
	private JTextField txtNewBid;
	private JButton btnConfirmAndBid;
	private JButton btnConfirm;
	private JButton btnOk;
	private JButton btnSearch;

	public ClientGUI() {
		initialize();
	}

	private void initialize() {
		frame4 = new JFrame();
		frame4.getContentPane().setBackground(new Color(0, 0, 51));
		frame4.getContentPane().setLayout(null);
		frame4.setSize(1000, 2200);

		JLabel lbltitle = new JLabel("Welcome To Stock Exchange");
		lbltitle.setForeground(new Color(204, 204, 102));
		lbltitle.setBackground(new Color(204, 204, 102));
		lbltitle.setBounds(115, 50, 764, 52);
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Sylfaen", Font.BOLD, 40));
		frame4.getContentPane().add(lbltitle);
		frame4.setResizable(false);

		JLabel lblName = new JLabel("Enter Your Name :");
		lblName.setForeground(new Color(153, 204, 204));
		lblName.setBounds(33, 153, 426, 35);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame4.getContentPane().add(lblName);

		JLabel lblsymbol = new JLabel("Symbol you are willing to bid on :");
		lblsymbol.setForeground(new Color(153, 204, 204));
		lblsymbol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsymbol.setBounds(33, 200, 426, 35);
		frame4.getContentPane().add(lblsymbol);

		JLabel lblSecurityName = new JLabel("Security Name :");
		lblSecurityName.setForeground(new Color(153, 204, 204));
		lblSecurityName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecurityName.setBounds(33, 246, 426, 35);
		frame4.getContentPane().add(lblSecurityName);

		JLabel lblCurrentPrice = new JLabel("Current Price :");
		lblCurrentPrice.setForeground(new Color(153, 204, 204));
		lblCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentPrice.setBounds(33, 298, 426, 35);
		frame4.getContentPane().add(lblCurrentPrice);

		JLabel lblbid = new JLabel("Place a new Bid :");
		lblbid.setForeground(new Color(153, 204, 204));
		lblbid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblbid.setBounds(33, 344, 426, 35);
		frame4.getContentPane().add(lblbid);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setForeground(new Color(153, 204, 204));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatus.setBounds(33, 390, 426, 35);
		frame4.getContentPane().add(lblStatus);

		txtSymbol = new JTextField();
		txtSymbol.setBounds(456, 199, 370, 36);
		frame4.getContentPane().add(txtSymbol);
		txtSymbol.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(836, 200, 89, 35);
		frame4.getContentPane().add(btnSearch);

		textCname = new JTextField();
		textCname.setColumns(10);
		textCname.setBounds(456, 153, 466, 35);
		frame4.getContentPane().add(textCname);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setEditable(false);
		txtName.setBounds(456, 246, 466, 35);
		frame4.getContentPane().add(txtName);

		textCprice = new JTextField();
		textCprice.setColumns(10);
		textCprice.setEditable(false);
		textCprice.setBounds(456, 292, 466, 35);
		frame4.getContentPane().add(textCprice);

		textstatus = new JTextField();
		textstatus.setColumns(10);
		textstatus.setEditable(false);
		textstatus.setBounds(456, 390, 466, 35);
		frame4.getContentPane().add(textstatus);

		txtNewBid = new JTextField();
		txtNewBid.setColumns(10);
		txtNewBid.setBounds(456, 344, 370, 36);
		frame4.getContentPane().add(txtNewBid);

		btnOk = new JButton("OK");
		btnOk.setBounds(833, 344, 89, 35);
		frame4.getContentPane().add(btnOk);

		btnConfirm = new JButton("Quit");
		btnConfirm.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		btnConfirm.setBounds(33, 552, 418, 52);
		frame4.getContentPane().add(btnConfirm);

		btnConfirmAndBid = new JButton(" Confirm and Bid again");
		btnConfirmAndBid.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		btnConfirmAndBid.setBounds(456, 552, 466, 52);
		frame4.getContentPane().add(btnConfirmAndBid);
	}

	public JButton getbtnSearch() {
		return btnSearch;
	}

	public JButton getbtnOK() {
		return btnOk;
	}

	public JButton getbtnConfirm() {
		return btnConfirm;
	}

	public JButton getbtnConfirmAndBid() {
		return btnConfirmAndBid;
	}

	public JTextField gettxtSymbol() {
		return txtSymbol;
	}

	public JTextField gettxtName() {
		return txtName;
	}

	public JTextField gettxtCprice() {
		return textCprice;
	}

	public JTextField gettxtNewBid() {
		return txtNewBid;
	}

	public JTextField gettxtStatus() {
		return textstatus;
	}

	public JTextField gettxtCname() {
		return textCname;
	}
}
