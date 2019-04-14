<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
	<form method = "GET" action="HomePageServlet">
		<table>
			<tr>
				<td>
					<input type="radio" name = "chooseMenu" value="call">Call-центр<br>
					<input type="radio" name = "chooseMenu" value="courier">Курьер<br>
				</td>
			</tr>
			<tr>
				<td align = "right"><input type="submit" value="Войти"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>