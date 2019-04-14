<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courier</title>
</head>
<body>
	<form method = "GET" action="CourierServlet">
		<table>
			<tr>
				<td>Courier id</td>
				<td align = "right"> <input type="text" name = "courierId"></td>
			</tr>
			<tr>
				<td>Order</td>
				<td align = "right"><input type="text" name = "orderNumber"></td>
			</tr>
			<tr>
				<td align = "right" colspan = "2"><input type="submit" value="I don't have time"></td>
			</tr>	
		</table>
		<%
			String msg = (String) request.getAttribute("message");
			if(msg != null)
				out.println(msg);
		%>
	</form>
</body>
</html>