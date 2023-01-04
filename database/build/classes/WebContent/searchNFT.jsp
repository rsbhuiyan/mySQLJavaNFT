<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>

     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<center>	<h1> Search NFT </h1> </center>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="searchNFT">
			<table border="1" cellpadding="5">
				<tr>
					<th>NFT Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="nftName" size="45"  value="NFT Name" onfocus="this.value=''">
					</td>
				</tr>
			</table>
			<td align="center" colspan="5">
			
			<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Find NFT"/>
					</td>
			</tr>
			<a href="login.jsp" target="_self">Return to Login Page</a>
			
			 <div align="center">
    
    
	
   
        <table border="1" cellpadding="6">
 
            <tr>
                <th>NFTID</th>
                <th>Nft Name</th> 
                <th>Description</th>
                <th>nftImage</th>
                <th>Price</th>
             

            </tr>
             <c:forEach var="NFT" items="${searchNFT}">
                <tr style="text-align:center">
                    <td><c:out value="${NFT.NFTID}" /></td>
                    <td><c:out value= "${NFT.nftName}" /></td>
                    <td><c:out value="${NFT.nftDescription}" /></td>
                    <td><c:out value="${NFT.nftImage}" /></td>
                    <td><c:out value="${NFT.price}" /></td>
                                     
                    
            </c:forEach>
        </table>
    </div>
		</form>
	</div>
	

	
</body>
</html>