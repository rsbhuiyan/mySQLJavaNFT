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

        
    <h1> Hot NFTs </h1>
   	<h1> </h1>

			
			<h1> </h1>
	<form action="hotNFT">
			<table border="1" cellpadding="5">
				
					
		<input type = "submit" value = "View NFTs"/>
	</form>
					<h1> </h1>
			
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>NFT</th> 
                <th>Number</th>   
                  
            </tr>
            
             <c:forEach var="Trans" items="${hotNFT}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                    <td><c:out value="${Trans.price}" /></td>                   
                                    
            </c:forEach>
        
        
        
        </table> 
        
        
        
             
     <h1> Common NFTS </h1>
   	<h1> </h1>
	<form action="commonNFT">
			<table border="1" cellpadding="5">
				<tr>
					<th>User 1: </th>
					<td align="center" colspan="3">
						<input type="text" name="email1" size="45"  value="Users Email" onfocus="this.value=''">
						<th>User 2: </th>
					<td align="center" colspan="3">
						<input type="text" name="email2" size="45"  value="Users Email" onfocus="this.value=''">
		<input type = "submit" value = "search User"/>
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
                <th>NFT</th>
                
            </tr>
            
            <c:forEach var="Trans" items="${commonNFT}">
                <tr style="text-align:center">
                    <td><c:out value="${Trans.transType}" /></td>   
                                    
                                    
            </c:forEach>
        </table>
        
   
          
        
        <h1><h1> </h1></h1>
        <a href="activitypage.jsp" target="_self">Back</a>
        
    </div>
    


    </body>
</html>