<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

       

    <div align="center">

        
    <h1> Big Creators </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="bigCreator">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Creators"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>Creator</th> 
                <th>Number</th>   
                  
            </tr>
            
            <c:forEach var="NFT" items="${bigCreator}">
                <tr style="text-align:center">
                    <td><c:out value="${NFT.nftName}" /></td>   
                    <td><c:out value="${NFT.price}" /></td>                   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        <h1> Big Sellers </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="bigSeller">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Sellers"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>Seller</th> 
                <th>Number</th>   
                  
            </tr>
            
            <c:forEach var="Trans" items="${bigSeller}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                    <td><c:out value="${Trans.price}" /></td>                   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        
        <h1> Big Buyers </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="bigBuyer">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Buyers"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>Buyer</th> 
                <th>Number</th>   
                  
            </tr>
            
            <c:forEach var="Trans" items="${bigBuyer}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                    <td><c:out value="${Trans.price}" /></td>                   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        <h1> Good Buyers </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="goodBuyer">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Buyers"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>Buyer</th> 
                <th>Number</th>   
                  
            </tr>
            
            <c:forEach var="Trans" items="${goodBuyer}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                    <td><c:out value="${Trans.price}" /></td>                   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        
        
        <h1> Diamond Hands </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="diamondHands">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Users"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>User</th>       
            </tr>
            
            <c:forEach var="Trans" items="${diamondHands}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
          
        <h1> Paper Hands </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="paperHands">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View Buyers"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>User</th> 
                
                  
            </tr>
            
            <c:forEach var="Trans" items="${paperHands}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                                      
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        
        
     <h1> User's Stats </h1>
   	<h1> </h1>
	<form action="userStats">
			<table border="1" cellpadding="5">
				<tr>
					<th>Search User: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="Users Email" onfocus="this.value=''">
						
		<input type = "submit" value = "Search User"/>
	</form>
					</td>
				</tr>
			</table>
			<td align="center" colspan="5">
			
			<tr>
			<h1> </h1>
					<h1> </h1>
			</tr>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>User</th> 
                <th>Buys</th>
                <th>Sells</th>
                <th>NFTs Owned</th>
                
                  
            </tr>
            
            <c:forEach var="Trans" items="${userStats}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>  
                    <td><c:out value="${Trans.sells}" /></td>   
                    <td><c:out value="${Trans.price}" /></td>     
                    <td><c:out value="${Trans.nftO}" /></td>     
                                      
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        <h1> Inactive Users </h1>
   			<h1> </h1>
			<h1> </h1>
        
        
        <form action="inactive">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View users"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>Users</th> 
                
                  
            </tr>
            
            <c:forEach var="Trans" items="${inactive}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                                      
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
          
        
        <h1><h1> </h1></h1>
        <a href="activitypage.jsp" target="_self">Back</a>
        
    </div>
    


    </body>
</html>