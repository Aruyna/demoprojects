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
				<td>Id курьера</td>
				<td align = "right"> <input type="text" name = "courierId"></td>
			</tr>
			<tr>
				<td>Заказ №</td>
				<td align = "right"><input type="text" name = "orderNumber"></td>
			</tr>
			<tr>
				<td align = "right" colspan = "2"><input type="submit" value="Не успеваю"></td>
			</tr>
			
			<%
				String msg = (String) request.getAttribute("message");
				if(msg != null)
					out.println(msg);
			%>
			
		</table>
	</form>
</body>
</html>