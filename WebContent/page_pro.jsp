<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页展示数据</title>
</head>
<body>

<table border="1" width="80%" align="center">
    <tr>
        <td width='8%'>商品id</td>
        <td width='8%'>商品图片</td>
        <td width='8%'>商品名称</td>
        <td width='8%'>市场价</td>
        <td width='8%'>出售价</td>
        <td width='8%'>上传日期</td>
        <td>商品描述</td>
    </tr>

    <c:forEach var="p" items="${bean.list}">
        <tr>
            <td width='1%'><input type="checkbox" name="pid" value="${p.pid }"></td>
            <td width='8%'>${p.pid }</td>
            <td width='8%'><img alt="" src="${pageContext.request.contextPath }/${p.pimage}" width="80"></td>
            <td width='8%'>${p.pname }</td>
            <td width='8%'>${p.market_price }</td>
            <td width='8%'>${p.shop_price }</td>
            <td width='8%'>${p.pdate }</td>
            <td>${p.pdesc }</td>
            <td width='8%'>
                <a href="${pageContext.request.contextPath}/query_pro?pid=${p.pid}">修改</a>
                |
                <a href="javascript:void(0)" onclick="deleteP('${p.pid}')">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
<center>
    <c:if test="${bean.currentPage!=1}">
        <a href="${pageContext.request.contextPath}/pro_list_by_page?currentPage=1">[首页]</a>
        <a href="${pageContext.request.contextPath}/pro_list_by_page?currentPage=${bean.currentPage-1}">[上一页]</a>
    </c:if>
    <c:if test="${bean.currentPage!=bean.totalPage}">
        <a href="${pageContext.request.contextPath}/pro_list_by_page?currentPage=${bean.currentPage+1}">[下一页]</a>
        <a href="${pageContext.request.contextPath}/pro_list_by_page?currentPage=${bean.totalPage}">[尾页]</a>
    </c:if>
    <br>
    <c:forEach begin="1" end="${bean.totalPage}" var="page">
        <c:if test="${page==bean.currentPage}">
            ${page}
        </c:if>
        <c:if test="${page!=bean.currentPage}">
            <a href="${pageContext.request.contextPath}/pro_list_by_page?currentPage=${page}">${page}</a>
        </c:if>
    </c:forEach>
    当前页${bean.currentPage}/${bean.totalPage}


</center>
</body>
</html>
