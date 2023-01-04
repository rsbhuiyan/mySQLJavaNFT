<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Transfer</title></head>
<body>
	<center>	<h1> Transfer your NFT </h1> </center>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="transfer">
			<table border="1" cellpadding="5">
				<tr>
					<th>ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="NFTID" size="45"  value="NFT's ID" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Recipient: </th>
					<td align="center" colspan="3">
						<input type="text" name="owner" size="45" value=" Their Email " onfocus="this.value=''">
					</td>
				</tr>
			</table>
			<td align="center" colspan="5">
			<input type="submit" value="Transfer"/>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>