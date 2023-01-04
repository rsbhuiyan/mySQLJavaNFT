import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/transactionDAO")
public class transactionDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public transactionDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		 //mySQL username and password
         	connect_func("", "");
         	
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<Transaction> searchTransaction(String seller1) throws SQLException {   
    	 List<Transaction> searchTransaction = new ArrayList<Transaction>(); 
    	 String sql = "SELECT * FROM Transaction WHERE seller LIKE ?";
    	 
    	 //mySQL username and password
      	connect_func("", "");   
    	 
         preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
         preparedStatement.setString(1, seller1);
         
         ResultSet resultSet = preparedStatement.executeQuery();

         
         
         while (resultSet.next()) {
             int transID = resultSet.getInt("transID");
             String nameNFT = resultSet.getString("nameNFT");
             String seller = resultSet.getString("seller");
             String buyer = resultSet.getString("buyer");
             String transType = resultSet.getString("transType");
             int price = resultSet.getInt("price");    
             
             
             Transaction Transactions = new Transaction(transID, nameNFT, seller, buyer, transType, price);
             searchTransaction.add(Transactions);
         }
         System.out.println(sql + "was executed");
         
         resultSet.close();
         disconnect();        
         return searchTransaction;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    
    
    public void insert(int NFTID, String owner, String type) throws SQLException {  

    	 //mySQL username and password
     	connect_func("", "");
		String sql = "insert into Transaction (nameNFT, seller, buyer, transType, price) values ((SELECT nftName from NFT WHERE NFTID= ?), (SELECT owner from NFT WHERE NFTID= ?), ?, ?, (SELECT price from NFT WHERE NFTID= ?))";

		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, NFTID);
			preparedStatement.setInt(2, NFTID);
			preparedStatement.setString(3, owner);
			if(type == "t") {
				preparedStatement.setString(4, type);

			}
			else {
				preparedStatement.setString(4, type);

			}
			preparedStatement.setInt(5, NFTID);	


		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
   
    
    public boolean delete(String transID) throws SQLException {
        String sql = "DELETE FROM Transaction WHERE transID = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, transID);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(Transaction Transactions) throws SQLException {
        String sql = "update Transaction set seller=?,buyer =?, transType = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, Transactions.getTransactionSeller());
		preparedStatement.setString(2, Transactions.getTransactionBuyer());
		preparedStatement.setString(3, Transactions.getTransType());
		preparedStatement.setInt(4, Transactions.getPrice());

         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }

    
    public Transaction getTransaction(int transID) throws SQLException {
    	Transaction Transaction = null;
        String sql = "SELECT * FROM Transaction WHERE transID = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, transID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        
         
        if (resultSet.next()) {
        	String nameNFT = resultSet.getString("nameNFT");
            String seller = resultSet.getString("seller");
            String buyer = resultSet.getString("buyer");
            String transType = resultSet.getString("transType");
            int price = resultSet.getInt("price");

            Transaction = new Transaction(transID, nameNFT, seller, buyer, transType, price);
        }
         
        resultSet.close();
        statement.close();
         
        return Transaction;
    }

    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists testdb; ",
					        "create database testdb; ",
					        "use testdb; ",
					        "drop table if exists Transaction; ",
					        ("CREATE TABLE if not exists Transaction( " +
					            "transID integer AUTO_INCREMENT, " + 
					        	"nameNFT varchar(100) NOT  NULL," +
					            "seller VARCHAR(100) NOT NULL, " +
					            "buyer VARCHAR(100) NOT NULL, " +
					            "transtype char(1), " +
					            "timestamp DATETIME, " + 
					            "price DECIMAL(13,2), " +
					            "foreign key(seller) references User(email), " +
					            "foreign key(buyer) references User(email), " +
					            "PRIMARY KEY (transId) "+"); ")
        					};
        
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        disconnect();
    }

public List<Transaction> bigSeller() throws SQLException{
    	
    	List<Transaction> bigSeller = new ArrayList<Transaction>();        
        String sql = "select seller, Num from mostSold where Num = (select max(num) from mostSold)";  
        
        //mySQL username and password
     	connect_func("", ""); 
     	
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        System.out.println(sql + "was executed");

         
        while (resultSet.next()) {
            String seller = resultSet.getString("seller"); 
            int price = resultSet.getInt("Num");

            System.out.println(seller + "was executed");

            Transaction trans = new Transaction(price,seller);
            bigSeller.add(trans);
        }        
        resultSet.close();
        disconnect();        
        return bigSeller;
	}

public List<Transaction> bigBuyer() throws SQLException{
	
	List<Transaction> bigBuyer = new ArrayList<Transaction>();        
    String sql = "select buyer, Num from mostBought where Num = (select max(num) from mostBought)";   
    
    //mySQL username and password
 	connect_func("", "");
 	
    statement = (Statement) connect.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    
    System.out.println(sql + "was executed");

     
    while (resultSet.next()) {
        String buyer = resultSet.getString("buyer"); 
        int price = resultSet.getInt("Num");


        Transaction trans = new Transaction(price,buyer);
        bigBuyer.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return bigBuyer;
}

public List<Transaction> goodBuyer() throws SQLException{
	
	List<Transaction> goodBuyer = new ArrayList<Transaction>();        
    String sql = "SELECT buyer, COUNT(*) as count FROM Transaction GROUP BY buyer HAVING COUNT(*) >= 3";   
    
    //mySQL username and password
 	connect_func("", "");   
 	
    statement = (Statement) connect.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    
    System.out.println(sql + "was executed");

     
    while (resultSet.next()) {
        String buyer = resultSet.getString("buyer"); 
        int price = resultSet.getInt("count");


        Transaction trans = new Transaction(price,buyer);
        goodBuyer.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return goodBuyer;
}


public List<Transaction> hotNFT() throws SQLException{
	
	List<Transaction> hotNFT = new ArrayList<Transaction>();        
    String sql = "select nameNFT, Num from mostOwned where Num = (select max(num) from mostOwned)";   
    
    //mySQL username and password
 	connect_func("", "");   
 	     
    statement = (Statement) connect.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    
    System.out.println(sql + "was executed");

     
    while (resultSet.next()) {
        String nameNFT = resultSet.getString("nameNFT"); 
        int price = resultSet.getInt("Num");


        Transaction trans = new Transaction(price,nameNFT);
        hotNFT.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return hotNFT;
}



public List<Transaction> diamondHands() throws SQLException {   

 	 List<Transaction>  diamondHands = new ArrayList<Transaction>(); 
 	 String sql = "select distinct buyer from Transaction t where not exists (select * from Transaction where t.buyer=seller)";
 	 
     //mySQL username and password
  	connect_func("", "");   
  	     
     statement = (Statement) connect.createStatement();
     ResultSet resultSet = statement.executeQuery(sql);
     
     System.out.println(sql + "was executed");

      
     while (resultSet.next()) {
         String buyer = resultSet.getString("buyer"); 


         Transaction trans = new Transaction(buyer);
         diamondHands.add(trans);
     }        
     resultSet.close();
     disconnect();        
     return diamondHands;
   }

public List<Transaction> paperHands() throws SQLException {   

	 List<Transaction>  paperHands = new ArrayList<Transaction>(); 
	String sql = "select * from paperhands";
	 
    //mySQL username and password
 	connect_func("", "");   
 	     
    statement = (Statement) connect.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    
    System.out.println(sql + "was executed");

     
    while (resultSet.next()) {
        String buyer = resultSet.getString("email"); 


        Transaction trans = new Transaction(buyer);
        paperHands.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return paperHands;
  }

public List<Transaction> commonNFT(String user1, String user2) throws SQLException{
	
	List<Transaction> commonNFT = new ArrayList<Transaction>();        
    String sql = "SELECT Transaction.nameNFT FROM Transaction WHERE (Transaction.seller  = ? and Transaction.buyer  = ?) or (Transaction.seller  = ? and Transaction.buyer  = ?)";
    		   
    
    //mySQL username and password
 	connect_func("", "");   
 	     
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, user1);
    preparedStatement.setString(2, user2);
    preparedStatement.setString(3, user2);
    preparedStatement.setString(4, user1);


		 System.out.println("commonNFT in DAO  started");

    
    ResultSet resultSet = preparedStatement.executeQuery();
     
    while (resultSet.next()) {
        String nameNFT = resultSet.getString("nameNFT"); 
        


        Transaction trans = new Transaction(nameNFT);
        commonNFT.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return commonNFT;
}


public List<Transaction> userStats(String user1) throws SQLException{
	
	List<Transaction> userStats = new ArrayList<Transaction>();        
    String sql = "select * from userStats where email = ?";
    		   
    
    //mySQL username and password
 	connect_func("", "");   
 	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    preparedStatement.setString(1, user1);
    System.out.println("userStats in DAO  started");

    
    ResultSet resultSet = preparedStatement.executeQuery();
     
    while (resultSet.next()) {
        String transType = resultSet.getString("email");
        
        int sells = resultSet.getInt("buys");
        
        int price = resultSet.getInt("sells");
        
        int nftO = resultSet.getInt("nftsOwned");
        
       
        
        


        Transaction trans = new Transaction(transType, sells, price, nftO);
        userStats.add(trans);
    }        
    resultSet.close();
    disconnect();        
    return userStats;
}
    
   
    
public List<Transaction> inactive() throws SQLException {   

	 List<Transaction>  inactive = new ArrayList<Transaction>(); 
	String sql = "select * from inactive";
	 
    //mySQL username and password
 	connect_func("", "");   
 	      
   statement = (Statement) connect.createStatement();
   ResultSet resultSet = statement.executeQuery(sql);
   
   System.out.println(sql + "was executed");

    
   while (resultSet.next()) {
       String email = resultSet.getString("email"); 


       Transaction trans = new Transaction(email);
       inactive.add(trans);
   }        
   resultSet.close();
   disconnect();        
   return inactive;
 }
    
    
    
    
	
	

}
