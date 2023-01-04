<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Transfer</title></head>
<body>
	<center>	<h1> Buy your NFT </h1> </center>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="buyNFT">
			<table border="1" cellpadding="5">
				<tr>
					<th>ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="NFTID" size="45"  value="NFT's ID" onfocus="this.value=''">
					</td>
				</tr>
				<th>Owner: </th>
					<td align="center" colspan="3">
						<input type="text" name="prevOwner" size="45" value=" Owner's Email " onfocus="this.value=''">
					</td>
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="owner" size="45" value=" Your Email " onfocus="this.value=''">
					</td>
				</tr>
			</table>
			<td align="center" colspan="5">
			<input type="submit" value="Buy"/>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>