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
				<td align = "right"><input type="submit" value="Найти/Показать все"></td>
			</tr>
		</table>
		<br>	
		<table>
			<tr>
				<th>Заказ</th>
				<th>Дата и время</th>
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