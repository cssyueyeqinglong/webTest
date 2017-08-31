<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
</head>
<body>

	<table border="1" align="center" width="20%">
		<tr>
			<td>商品名</td>
			<td>商品数量</td>
		</tr>
		<%
			Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
			if (map == null) {
		%>
		<tr>
			<td colspan="2">您还没有添加商品哦</td>
		</tr>

		<%
			} else {
				for (String name : map.keySet()) {
					int num = map.get(name);
					out.print("<tr>");
					out.print("<td>");
					out.print(name);
					out.print("</td>");
					out.print("<td>");
					out.print(map.get(name));
					out.print("</td>");
					out.print("</tr>");
				}
			}
		%>

	</table>
	<hr>
	<center>
		<a href="/cy_test/product_list.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;
		<a href="/cy_test/clearCart">清空购物车</a>
	</center>
</body>
</html>