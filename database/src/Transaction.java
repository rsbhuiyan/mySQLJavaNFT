public class Transaction 
{
	protected int transId;
    protected String nameNFT;
    protected String seller;
    protected String buyer;
    protected String transType;
    protected int sells;
    protected int nftO;
    protected int price;

 
    //constructors
    public Transaction() {
    }
 
    public Transaction(int transId) 
    {
        this.transId = transId;
    }
    
    public Transaction(int price, String transType) 
    {
        this.price = price;
    	this.transType = transType;

    }
    public Transaction(String transType, int sells, int price, int nftO) 
    {
    	this.transType = transType;
    	this.sells = sells;
        this.price = price;
        this.nftO = nftO;
    	

    }
    
    public Transaction(String transType) 
    {
    	this.transType = transType;

    }
    
    public Transaction(int transId, String nameNFT, String seller, String buyer, String transType, int price) 
    {
    	this(nameNFT, seller, buyer, transType, price);
    	this.transId = transId;
    }
    
    public Transaction(String nameNFT, String seller, String buyer, String transType, int price) 
    {
    	this.nameNFT = nameNFT;
    	this.seller = seller;
    	this.buyer = buyer;
    	this.transType = transType;
    	this.price = price;
    }
    
 
 
    
   //getter and setter methods
    public int getTransId() {
        return transId;
    }
    
    public String getTransactionNameNFT() {
        return nameNFT;
    }
    public int getSells() {
        return sells;
    }
    
    public void setSells(int sells) {
        this.sells = sells;
    }
    
    public int getnftO() {
        return nftO;
    }
    
    public void setnftO(int nftO) {
        this.nftO = nftO;
    }
    public void setTransactionNameNFT(String nameNFT) {
        this.nameNFT = nameNFT;
    }
    
    public String getTransactionSeller() {
        return seller;
    }
    public void setTransactionSeller(String seller) {
        this.seller = seller;
    }
    
    public String getTransactionBuyer() {
        return buyer;
    }
    public void setTransactionBuyer(String buyer) {
        this.buyer = buyer;
    }
    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

	public int getPrice() {
		return price;
	}
}