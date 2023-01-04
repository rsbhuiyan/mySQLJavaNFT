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
@WebServlet("/nftDAO")
public class nftDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public nftDAO(){}
	
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
    		//mysql username and password
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
    public List<NFT> listAllnfts() throws SQLException {
        List<NFT> listNft = new ArrayList<NFT>();        
        String sql = "SELECT * FROM NFT";   
        
        //mysql username and password
     	connect_func("", "");  
     	
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int NFTID = resultSet.getInt("NFTID");
            String creator = resultSet.getString("creator");
            String owner = resultSet.getString("owner");
            String nftName = resultSet.getString("nftName");
            String nftDescription = resultSet.getString("nftDescription");
            String nftImage = resultSet.getString("nftImage");
            int price = resultSet.getInt("price");
            


             
            NFT nfts = new NFT(NFTID,  nftName, creator, owner, nftDescription, nftImage, price);
            listNft.add(nfts);
        }        
        resultSet.close();
        disconnect();        
        return listNft;
    }
    
    public List<NFT> bigCreator() throws SQLException{
    	
    	List<NFT> bigCreator = new ArrayList<NFT>();        
        String sql = "select creator, Num from mostCreated where Num = (select max(num) from mostCreated);";   
        //mySQL username and password
     	connect_func("", "");       
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        System.out.println(sql + "was executed");

         
        while (resultSet.next()) {
            String creator = resultSet.getString("creator"); 
            int Num = resultSet.getInt("Num");

             
            NFT nfts = new NFT(Num , creator);
            bigCreator.add(nfts);
        }      
        

        resultSet.close();
        disconnect();        
        return bigCreator;
	}
    
    public List<NFT> searchNFT(String nftName1) throws SQLException {   
    	 List<NFT> searchNFT = new ArrayList<NFT>(); 
    	 String sql = "SELECT * FROM NFT WHERE nftName LIKE ?";
    	 
    	 //mySQL username and password
      	connect_func("", "");    
    	 
         preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
         preparedStatement.setString(1, nftName1);
         
         
         ResultSet resultSet = preparedStatement.executeQuery();

         
         
         while (resultSet.next()) {
             int NFTID = resultSet.getInt("NFTID");
             String creator = resultSet.getString("creator");
             String owner = resultSet.getString("owner");
             String nftName = resultSet.getString("nftName");
             String nftDescription = resultSet.getString("nftDescription");
             String nftImage = resultSet.getString("nftImage");
             int price = resultSet.getInt("price");    
             
             
             NFT nfts = new NFT(NFTID,  nftName, creator, owner, nftDescription, nftImage, price);
             searchNFT.add(nfts);
         }
         System.out.println(sql + "was executed");
         
         resultSet.close();
         disconnect();        
         return searchNFT;
    }
    
    public List<NFT> searchUserNFT(String owner1) throws SQLException {   

    	 List<NFT> searchUserNFT = new ArrayList<NFT>(); 
       	 String sql = "SELECT cash_bal, nftName from User, NFT Where email LIKE ? And owner like ?";
       	 
       	 //mySQL username and password
       	 connect_func("", "");    
       	 
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
            preparedStatement.setString(1, owner1);
            preparedStatement.setString(2, owner1);
    		 System.out.println("searchNFT in DAO  started");

            
            ResultSet resultSet = preparedStatement.executeQuery();

            
            
            while (resultSet.next()) {
                int price = resultSet.getInt("cash_bal");
                String nftName = resultSet.getString("nftName");    
                
                
                NFT nfts = new NFT(price, nftName);
                searchUserNFT.add(nfts);
            }
            System.out.println(sql + "was executed");
            
            resultSet.close();
            disconnect();        
            return searchUserNFT;
      }
    
    public List<NFT> searchCreator(String creator1) throws SQLException {   

   	 List<NFT> searchCreator = new ArrayList<NFT>(); 
      	 String sql = "SELECT nftName FROM NFT WHERE creator LIKE ?";
      	 
      	 //mysql username and password
      	 connect_func("", "");    
      	 
           preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
           preparedStatement.setString(1, creator1);
   		 System.out.println("searchCreator in DAO  started");

           
           ResultSet resultSet = preparedStatement.executeQuery();

           
           
           while (resultSet.next()) {
               String nftName = resultSet.getString("nftName");    
               
               
               NFT nfts = new NFT(nftName);
               searchCreator.add(nfts);
           }
           System.out.println(sql + "was executed");
           
           resultSet.close();
           disconnect();        
           return searchCreator;
     }
    
    public List<NFT> searchSell(String owner1) throws SQLException {   

     	 List<NFT> searchSell = new ArrayList<NFT>(); 
        	 String sql = "SELECT nftName from NFT Where owner <> ? And creator LIKE ?";
        	 
        	//mysql username and password
          	 connect_func("", "");     
        	 
             preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
             preparedStatement.setString(1, owner1);
             preparedStatement.setString(2, owner1);


     		 System.out.println("searchSell in DAO  started");

             
             ResultSet resultSet = preparedStatement.executeQuery();

             
             
             while (resultSet.next()) {
                 String nftName = resultSet.getString("nftName");    

                 
                 
                 NFT nfts = new NFT(nftName);
                 searchSell.add(nfts);
             }
             System.out.println(sql + "was executed");
             
             resultSet.close();
             disconnect();        
             return searchSell;
       }
    
    public List<NFT> searchBuy(String owner1) throws SQLException {   

      	 List<NFT> searchBuy = new ArrayList<NFT>(); 
         	 String sql = "SELECT nftName from NFT Where creator <> ? And owner LIKE ?";
         	 
         	//mysql username and password
          	 connect_func("", "");   
         	 
              preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
              preparedStatement.setString(1, owner1);
              preparedStatement.setString(2, owner1);


      		 System.out.println("searchBuy in DAO  started");

              
              ResultSet resultSet = preparedStatement.executeQuery();

              
              
              while (resultSet.next()) {
                  String nftName = resultSet.getString("nftName");    

                  
                  
                  NFT nfts = new NFT(nftName);
                  searchBuy.add(nfts);
              }
              System.out.println(sql + "was executed");
              
              resultSet.close();
              disconnect();        
              return searchBuy;
        }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(NFT nfts) throws SQLException {    
    	//mysql username and password
     	connect_func("", "");  
		String sql = "insert into NFT(nftName, creator, owner, nftDescription, nftImage, price) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, nfts.getNftName());
			preparedStatement.setString(2, nfts.getNftCreator());
			preparedStatement.setString(3, nfts.getNftOwner());
			preparedStatement.setString(4, nfts.getNftDescription());
			preparedStatement.setString(5, nfts.getNftImage());	
			preparedStatement.setInt(6, nfts.getPrice());	


		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
   
    
    public boolean delete(String NFTID) throws SQLException {
        String sql = "DELETE FROM nft WHERE NFTID = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, NFTID);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(NFT nfts) throws SQLException {
        String sql = "update nft set nftName=?,nftDescription =?, nftImage = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, nfts.getNftName());
		preparedStatement.setString(2, nfts.getNftCreator());
		preparedStatement.setString(3, nfts.getNftOwner());
		preparedStatement.setString(4, nfts.getNftDescription());
		preparedStatement.setString(5, nfts.getNftImage());
		preparedStatement.setInt(6, nfts.getPrice());

         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public boolean transfer(int NFTID, String owner1) throws SQLException{
		System.out.print("WORKS HERE");

    	String sql = "UPDATE NFT SET owner = ? WHERE NFTID = ?";
        connect_func();
        

        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, owner1);
        preparedStatement.setInt(2, NFTID);

        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        
        System.out.println("Transfer successful! " + owner1 + " is now the new owner");
        return rowUpdated;     
			
	}
    
    public NFT getNft(int NFTID) throws SQLException {
    	NFT nft = null;
        String sql = "SELECT * FROM nft WHERE NFTID = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, NFTID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        
         
        if (resultSet.next()) {
            String nftName = resultSet.getString("nftName");
            String creator = resultSet.getString("creator");
            String owner = resultSet.getString("owner");
            String nftDescription = resultSet.getString("nftDescription");
            String nftImage = resultSet.getString("nftImage");
            int price = resultSet.getInt("price");

            nft = new NFT(NFTID, creator, owner, nftName, nftDescription, nftImage, price);
        }
         
        resultSet.close();
        statement.close();
         
        return nft;
    }

    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists testdb; ",
					        "create database testdb; ",
					        "use testdb; ",
					        "drop table if exists NFT; ",
					        ("CREATE TABLE if not exists NFT( " +
					            "NFTID integer AUTO_INCREMENT, " + 
					            "nftName VARCHAR(100) NOT NULL, " +
					            "nftDescription VARCHAR(100) NOT NULL, " +
					            "nftImage VARCHAR(100) NOT NULL, " +
					            "creator varchar(100) NOT  NULL," + 
					            "owner varchar(100) NOT  NULL, " +
					            "mintTime datetime, " + 
					            "price DECIMAL(13,2) default 0," + 
					            "foreign key(creator) references User(email), " +
					            "foreign key(owner) references User(email), " +
					            "PRIMARY KEY (NFTID) "+"); ")
        					};
        
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        disconnect();
    }

	

	
    
    
   
    
    
    
    
    
	
	

}
