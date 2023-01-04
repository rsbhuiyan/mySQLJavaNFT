<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome! You have been successfully logged in</h1> </center>

 
    <body>
     <center>
         <a href="login.jsp"target ="_self" > logout</a><br><br> 
         <p> You can view all the information about the NFTs here</p>
     </center>

       
        
        <div align = "center">


    <div align="center">
    <h1> Search for NFT </h1>
   
	
	<h1> </h1>
	<form action="searchNFT">
			<table border="1" cellpadding="5">
				<tr>
					<th>NFT Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="nftName" size="45"  value="NFT Name" onfocus="this.value=''">
		<input type = "submit" value = "search nft"/>
	</form>
					</td>
				</tr>
			</table>
			<td align="center" colspan="5">
			
			<tr>
			<h1> </h1>
					<form action="listNft">
			<table border="1" cellpadding="5">
				<tr>
					
		<input type = "submit" value = "view all nfts"/>
	</form>
					<h1> </h1>
			</tr>
	</form>
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>NFTID</th>
                <th>Nft Name</th> 
                <th>Description</th>
                <th>nftImage</th>
                <th>Price</th>
                <th><form><a href="buyNFT.jsp" target="_self">Buy</a></form> </th>
                <th><form><a href="transfer.jsp" target="_self">Transfer</a></form></th>
             

            </tr>
            <c:forEach var="NFT" items="${listNft}">
                <tr style="text-align:center">
                    <td><c:out value="${NFT.NFTID}" /></td>
                    <td><c:out value= "${NFT.nftName}" /></td>
                    <td><c:out value="${NFT.nftDescription}" /></td>
                    <td><c:out value="${NFT.nftImage}" /></td>
                    <td><c:out value="${NFT.price}" /></td>
                    <th><form><a href="buyNFT.jsp" target="_self">Buy</a></form> </th>
                	<th><form><a href="transfer.jsp" target="_self">Transfer</a></form></th>
                                     
                    
            </c:forEach>
            
            <c:forEach var="NFT" items="${searchNFT}">
                <tr style="text-align:center">
                    <td><c:out value="${NFT.NFTID}" /></td>
                    <td><c:out value= "${NFT.nftName}" /></td>
                    <td><c:out value="${NFT.nftDescription}" /></td>
                    <td><c:out value="${NFT.nftImage}" /></td>
                    <td><c:out value="${NFT.price}" /></td>
                    <th><form><a href="buyNFT.jsp" target="_self">Buy</a></form> </th>
                	<th><form><a href="transfer.jsp" target="_self">Transfer</a></form></th>
                                     
                    
            </c:forEach>
        </table> 
        
          <div align="center">
    <h1> Search for User </h1>
   	<h1> </h1>
	<form action="searchUserNFT">
			<table border="1" cellpadding="5">
				<tr>
					<th>Search a User: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="Users Email" onfocus="this.value=''">
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
                <th>NFTs Owned</th>
                <th>Balance</th>
                
                
             

            </tr>
            
            <c:forEach var="users" items="${searchUserNFT}">
                <tr style="text-align:center">
                    <td><c:out value= "${users.nftName}" /></td>
                    <td><c:out value= "${users.price}" /></td>
                    
                    
                    
                    
                    
            </c:forEach>
        </table>
        <h1><h1> </h1></h1>
        <a href="mint.jsp" target="_self">Mint a NFT!</a>
        
        <a href="mintSearch.jsp" target="_self">To Search for Purchased, Sold, and Minted items by Users, Click Here!</a>
        <h1> </h1>
        <a href="big.jsp" target="_self">Search for User trends!</a>
        <h1> </h1>
        
        <a href="nftTrends.jsp" target="_self">Search for NFT trends!</a>
        
        
    </div>
    </div>


    </body>
</html>