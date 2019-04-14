<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "GET" action="CallCenterServlet">
		<table>
			<tr>
				<td><input type="text" name = "findNumber"></td>
				<td align = "right"><input type="submit" value="Find/show all"></td>
			</tr>
		</table>
		<br>	
		<table>
			<tr>
				<th>Order</th>
				<th>Date and time</th>
			</tr>
			<%
 				Map<String, String> list = (Map<String, String>) request.getAttribute("order");
				if(list != null){
					for(Map.Entry<String, String> entry : list.entrySet()){
						out.println("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
					}
				} 
			%>
		</table>	
	</form>
</body>
</html>