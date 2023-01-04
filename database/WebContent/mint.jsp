<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Create your NFT</title></head>
<body>
	<center>	<h1> Create your NFT </h1> </center>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="mint">
			<table border="1" cellpadding="5">
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="creator" size="45" value="Email" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="nftName" size="45" value="Name" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Description: </th>
					<td align="center" colspan="3">
						<input type="text" name="nftDescription" size="45" value="Describe the picture" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Image: </th>
					<td align="center" colspan="3">
						<input type="text" name="nftImage" size="45" value="image" onfocus="this.value=''">
					</td>
	
				</tr>
				<tr>
					<th>Price: </th>
					<td align="center" colspan="3">
						<input type="text" name="price" size="45" value="price" onfocus="this.value=''">
					</td>
	
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Create NFT"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>