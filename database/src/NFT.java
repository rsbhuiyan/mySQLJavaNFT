public class NFT 
{
		protected int NFTID;
	    protected String nftName;
	    protected String nftDescription;
	    protected String nftImage;
	    protected String creator;
	    protected String owner;
	    protected int price;

	 
	    //constructors
	    public NFT() {
	    }
	    
	    public NFT(String nftName) {
	    	this.nftName = nftName;
	    }
	   
	 
	    public NFT(int NFTID) 
	    {
	        this.NFTID = NFTID;
	    }
	    public NFT(String owner, String nftName) 
	    {
	        this.owner = owner;
	        this.nftName = nftName;

	    }
	    public NFT(int price, String nftName) 
	    {
	        this.price = price;
	        this.nftName = nftName;

	    }
	 
	   
	    
	    public NFT(int NFTID, String nftName, String creator, String owner, String nftDescription, String nftImage, int price) 
	    {
	    	this(nftName, creator, owner, nftDescription, nftImage, price);
	    	this.NFTID = NFTID;
	    }
	    
	    public NFT(String nftName, String creator, String owner, String nftDescription, String nftImage, int price) 
	    {
	    	this.nftName = nftName;
	    	this.creator = creator;
	    	this.owner = owner;
	    	this.nftDescription = nftDescription;
	    	this.nftImage = nftImage;
	    	this.price = price;
	    }
	    
	 
	 
	    
	   //getter and setter methods
	    public int getNFTID() {
	        return NFTID;
	    }
	    
	    public String getNftName() {
	        return nftName;
	    }
	    public void setNftName(String nftName) {
	        this.nftName = nftName;
	    }
	    public String getNftCreator() {
	        return creator;
	    }
	    public void setNftCreator(String creator) {
	        this.creator = creator;
	    }
	    
	    public String getNftOwner() {
	        return owner;
	    }
	    public void setNftOwner(String owner) {
	        this.owner = owner;
	    }
	    
	    public String getNftDescription() {
	        return nftDescription;
	    }
	    public void setNftDescription(String nftDescription) {
	        this.nftDescription = nftDescription;
	    }
	    
	    public String getNftImage() {
	        return nftImage;
	    }
	    public void setNftImage(String nftImage) {
	        this.nftImage = nftImage;
	    }
	   
	    
	    public void setPrice(int price) {
	        this.price = price;
	    }

		public int getPrice() {
			// TODO Auto-generated method stub
			return price;
		}
	}