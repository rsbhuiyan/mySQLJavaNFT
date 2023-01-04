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

        
    <h1> Search NFTS minted by User </h1>
   	<h1> </h1>
	<form action="searchCreator">
			<table border="1" cellpadding="5">
				<tr>
					<th>Search a User: </th>
					<td align="center" colspan="3">
						<input type="text" name="creator" size="45"  value="Creators Email" onfocus="this.value=''">
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
                <th>NFTs Created</th>
             

            </tr>
            
            <c:forEach var="nfts" items="${searchCreator}">
                <tr style="text-align:center">
                    <td><c:out value= "${nfts.nftName}" /></td>
                    
                    
                    
            </c:forEach>
        </table>
        
        
        
          <h1> Buy History for User </h1>
   	<h1> </h1>
	<form action="searchBuy">
			<table border="1" cellpadding="5">
				<tr>
					<th>Search a User: </th>
					<td align="center" colspan="3">
						<input type="text" name="owner" size="45"  value="User's Email" onfocus="this.value=''">
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
                <th>NFTs Bought</th>
                
             

            </tr>
            
            <c:forEach var="nfts" items="${searchBuy}">
                <tr style="text-align:center">
                    <td><c:out value= "${nfts.nftName}" /></td>
                    
                    
            </c:forEach>
        </table>
        
        
        
        
            <h1> Sell History by User </h1>
   	<h1> </h1>
	<form action="searchSell"> 
			<table border="1" cellpadding="5">
				<tr>
					<th>Search a User: </th>
					<td align="center" colspan="3">
						<input type="text" name="owner" size="45"  value="User's Email" onfocus="this.value=''">
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
                <th>NFTs Sold</th>
             

            </tr>
            
            <c:forEach var="nfts" items="${searchSell}">
                <tr style="text-align:center">
                    <td><c:out value= "${nfts.nftName}" /></td>
                    
                    
                    
            </c:forEach>
        </table>
        
        <h1><h1> </h1></h1>
        <a href="activitypage.jsp" target="_self">Back</a>
        
    </div>
    


    </body>
</html>