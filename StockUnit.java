
//details of one stock item

public class StockUnit {

    private String symbol;
    private double price;
    private String securityName;
	

    public StockUnit(double price, String securityName,String symbol) {
        this.symbol = symbol;
        this.price = price;
        this.securityName = securityName;
    }

    //return values
    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
