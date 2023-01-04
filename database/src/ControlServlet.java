import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private nftDAO nftDAO = new nftDAO();
	    private transactionDAO transactionDAO = new transactionDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
        	 case "/mint":
                 System.out.println("The action is: mint");
         		mint(request, response);
         		break;
        	 case "/listNft": 
                 System.out.println("The action is: listNft");
                 listNFT(request, response);
                 break;
        	 case "/searchNFT": 
                 System.out.println("The action is: searchNFT");
                 searchNFT(request, response);
                 break;
        	 case "/transfer": 
                 System.out.println("The action is: transfer");
                 transfer(request, response);
                 break;
        	 case "/buyNFT": 
                 System.out.println("The action is: buyNFT");
                 buyNFT(request, response);
                 break;
        	 case "/searchUser": 
                 System.out.println("The action is: searchUser");
                 searchUser(request, response);
                 break;
        	 case "/searchUserNFT": 
                 System.out.println("The action is: searchUser");
                 searchUserNFT(request, response);
                 break;
        	 case "/searchCreator": 
                 System.out.println("The action is: searchCreator");
                 searchCreator(request, response);
                 break;
        	 case "/searchBuy": 
                 System.out.println("The action is: searchBuy");
                 searchBuy(request, response);
                 break;
        	 case "/searchSell": 
                 System.out.println("The action is: searchSell");
                 searchSell(request, response);
                 break;
        	 case "/bigCreator": 
                 System.out.println("The action is: bigCreator");
                 bigCreator(request, response);
                 break;
        	 case "/bigSeller": 
                 System.out.println("The action is: bigSeller");
                 bigSeller(request, response);
                 break;
        	 case "/bigBuyer": 
                 System.out.println("The action is: bigBuyer");
                 bigBuyer(request, response);
                 break;
        	 case "/hotNFT": 
                 System.out.println("The action is: hotNFT");
                 hotNFT(request, response);
                 break;
        	 case "/diamondHands": 
                 System.out.println("The action is: diamondHands");
                 diamondHands(request, response);
                 break;
        	 case "/goodBuyer": 
                 System.out.println("The action is: goodBuyer");
                 goodBuyer(request, response);
                 break;
        	 case "/paperHands": 
                 System.out.println("The action is: paperHands");
                 paperHands(request, response);
                 break;
        	 case "/commonNFT": 
                 System.out.println("The action is: commonNFT");
                 commonNFT(request, response);
                 break;
        	 case "/userStats": 
                 System.out.println("The action is: userStats");
                 userStats(request, response);
                 break;
                 
        	 case "/inactive": 
                 System.out.println("The action is: inactivee");
                 inactive(request, response);
                 break;
                 
	    	}
        	
        	
        	
        	
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
	    
	    private void inactive(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("inactive started: 00000000000000000000000000000000000");


	            List<Transaction> inactive = transactionDAO.inactive();
		        request.setAttribute("inactive", inactive);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("inactive finished: 111111111111111111111111111111111111");			
		}
	    
	    private void userStats(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("userStats started: 00000000000000000000000000000000000");
	    	 String email = request.getParameter("email");
	    	 
   

	            List<Transaction> userStats = transactionDAO.userStats(email);
		        request.setAttribute("userStats", userStats);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("userStats finished: 111111111111111111111111111111111111");					
		}
	    
	    
	    private void commonNFT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("commonNFT started: 00000000000000000000000000000000000");
	    	 String user1 = request.getParameter("email1");
	    	 String user2 = request.getParameter("email2");
   

	            List<Transaction> commonNFT = transactionDAO.commonNFT(user1, user2);
		        request.setAttribute("commonNFT", commonNFT);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("nftTrends.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("commonNFT finished: 111111111111111111111111111111111111");			
		}
	    
	    private void paperHands(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("paperHands started: 00000000000000000000000000000000000");


	            List<Transaction> paperHands = transactionDAO.paperHands();
		        request.setAttribute("paperHands", paperHands);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("paperHands finished: 111111111111111111111111111111111111");			
		}
	    
	    
	    private void goodBuyer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("goodBuyer started: 00000000000000000000000000000000000");


	            List<Transaction> goodBuyer = transactionDAO.goodBuyer();
		        request.setAttribute("goodBuyer", goodBuyer);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("goodBuyer finished: 111111111111111111111111111111111111");			
		}
	    
	    private void diamondHands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	 System.out.println("diaHands started: 00000000000000000000000000000000000");
	            
	            
	         List<Transaction> diamondHands = transactionDAO.diamondHands();
		     request.setAttribute("diamondHands", diamondHands);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("diaHands finished: 111111111111111111111111111111111111");				
		}
	    
	    
	    private void hotNFT(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("hotNFT started: 00000000000000000000000000000000000");


	            List<Transaction> hotNFT = transactionDAO.hotNFT();
		        request.setAttribute("hotNFT", hotNFT);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("nftTrends.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("hotNFT finished: 111111111111111111111111111111111111");			
		}
	    private void bigBuyer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("bigBuyer started: 00000000000000000000000000000000000");


	            List<Transaction> bigBuyer = transactionDAO.bigBuyer();
		        request.setAttribute("bigBuyer", bigBuyer);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("bigBuyer finished: 111111111111111111111111111111111111");			
		}
	    
	    private void bigSeller(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
	    	 System.out.println("bigSeller started: 00000000000000000000000000000000000");


	            List<Transaction> bigSeller = transactionDAO.bigSeller();
		        request.setAttribute("bigSeller", bigSeller);       
		        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
		        dispatcher.forward(request, response);
		     
		        System.out.println("bigSeller finished: 111111111111111111111111111111111111");			
		}

		private void bigCreator(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            System.out.println("bigCreator started: 00000000000000000000000000000000000");


            List<NFT> bigCreator = nftDAO.bigCreator();
	        request.setAttribute("bigCreator", bigCreator);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("big.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("bigCreator finished: 111111111111111111111111111111111111");
        }
	    
	    private void searchSell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	 System.out.println("searchSell started: 00000000000000000000000000000000000");
	         String owner = request.getParameter("owner");
	            
	            
	         List<NFT> searchSell = nftDAO.searchSell(owner);
		     request.setAttribute("searchSell", searchSell);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("mintSearch.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("searchSell finished: 111111111111111111111111111111111111");				
		}
        	
	    private void searchBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	 System.out.println("searchBuy started: 00000000000000000000000000000000000");
	         String owner = request.getParameter("owner");
	            
	            
	         List<NFT> searchBuy = nftDAO.searchBuy(owner);
		     request.setAttribute("searchBuy", searchBuy);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("mintSearch.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("searchBuy finished: 111111111111111111111111111111111111");				
		}

	    private void searchCreator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	 System.out.println("searchCreator started: 00000000000000000000000000000000000");
	         String creator = request.getParameter("creator");
	            
	            
	         List<NFT> searchCreator = nftDAO.searchCreator(creator);
		     request.setAttribute("searchCreator", searchCreator);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("mintSearch.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("searchCreator finished: 111111111111111111111111111111111111");				
		}

		private void searchUserNFT(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
			 System.out.println("searchUserNFT started: 00000000000000000000000000000000000");
	         String owner = request.getParameter("email");
	            
	            
	         List<NFT> searchUserNFT = nftDAO.searchUserNFT(owner);
		     request.setAttribute("searchUserNFT", searchUserNFT);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("searchUserNFT finished: 111111111111111111111111111111111111");			
		}

		private void searchUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
			 System.out.println("searchNFT started: 00000000000000000000000000000000000");
	         String email = request.getParameter("email");
	            
	            
	         List<user> searchUser = userDAO.searchUser(email);
		     request.setAttribute("searchUser", searchUser);       
		   	 RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
		     dispatcher.forward(request, response);
		        
		     System.out.println("searchUser finished: 111111111111111111111111111111111111");			
		}

		private void searchNFT(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
            System.out.println("searchNFT started: 00000000000000000000000000000000000");
            String nftName = request.getParameter("nftName");
            
            
            List<NFT> searchNFT = nftDAO.searchNFT(nftName);
	        request.setAttribute("searchNFT", searchNFT);       
	   	 	RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
	        dispatcher.forward(request, response);
	        
	        System.out.println("searchNFT finished: 111111111111111111111111111111111111");

		}
	    
	    private void listNFT(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            System.out.println("listNFT started: 00000000000000000000000000000000000");


            List<NFT> listNft = nftDAO.listAllnfts();
	        request.setAttribute("listNft", listNft);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listNFT finished: 111111111111111111111111111111111111");
        }

	    private void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	int NFTID = Integer.parseInt(request.getParameter("NFTID"));
	   	 	String owner = request.getParameter("owner");
	   	 	
	 		transactionDAO.insert(NFTID, owner, "t");
	    	System.out.println("transfer started: 00000000000000000000000000000000000");

	 		nftDAO.transfer(NFTID, owner);
	    	System.out.println("transfer worked");

	    	System.out.println("insert worked");


	 		RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
	        dispatcher.forward(request, response);
	        System.out.println("transfer finished: 111111111111111111111111111111111111");

		}
	    
	    private void buyNFT(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
	    	System.out.println("buy started: 00000000000000000000000000000000000");
	    	int NFTID = Integer.parseInt(request.getParameter("NFTID"));
	   	 	String owner = request.getParameter("owner");
	   	 	String prevOwner = request.getParameter("prevOwner");
	   	 	
	 		transactionDAO.insert(NFTID, owner, "b");


	 		nftDAO.transfer(NFTID, owner);
	 		userDAO.buyNFT(NFTID, prevOwner, owner);
	 		

	 		RequestDispatcher dispatcher = request.getRequestDispatcher("activitypage.jsp");       
	        dispatcher.forward(request, response);
	        System.out.println("buy finished: 111111111111111111111111111111111111");
			
		}
	    
		private void mint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	   	 	String creator = request.getParameter("creator");
	   	 	String owner = request.getParameter("creator");
	    	String nftName = request.getParameter("nftName");
	   	 	String nftDescription = request.getParameter("nftDescription");
	   	 	String nftImage = request.getParameter("nftImage");
	   	 	int price = Integer.parseInt(request.getParameter("price"));

	   	 	
	   	 	System.out.println("Registration Successful! Added NFT to database");
	   	 	NFT nfts = new NFT(nftName, creator, owner, nftDescription, nftImage, price);
	 		nftDAO.insert(nfts);
	 		response.sendRedirect("activitypage.jsp");
			
		}

		private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
		
		
		
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	 currentUser = email;
				 System.out.println("Login Successful! Redirecting");
				 request.getRequestDispatcher("activitypage.jsp").forward(request, response);
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String birthday = request.getParameter("birthday");
	   	 	String adress_street_num = request.getParameter("adress_street_num"); 
	   	 	String adress_street = request.getParameter("adress_street"); 
	   	 	String adress_city = request.getParameter("adress_city"); 
	   	 	String adress_state = request.getParameter("adress_state"); 
	   	 	String adress_zip_code = request.getParameter("adress_zip_code"); 	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, 1000,0);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    


