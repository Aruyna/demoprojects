<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		    <c:forEach var="elem" items="${order}" >
		        <tr>
		        	<td><c:out value="${elem.getNumber()}"/></td>
		        	<td><c:out value="${elem.getDatetime()}"/></td>
		        </tr>
		    </c:forEach>
		</table>
	</form>
</body>
</html>