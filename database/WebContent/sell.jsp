<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Sell your NFT</title></head>
<body>

	<center>	<h1> Sell your NFT </h1> </center>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="sell">
			<table border="1" cellpadding="5">
				<tr>
					<th>NFT ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="NFTID" size="45"  value="NFTID" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Price: </th>
					<td align="center" colspan="3">
						<input type="text" name="price" size="45" value="Price" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Duration: </th>
					<td align="center" colspan="3">
						<input type="text" name="duration" size="45" value="how long" onfocus="this.value=''">
					</td>
	
				</tr>
				
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>