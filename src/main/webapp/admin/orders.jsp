<%@page import="com.entity.Bag_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BagOrderImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Orders</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello Admin</h3>

	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Ph No</th>
				<th scope="col">Bag Name</th>
				<th scope="col">Price</th>
				<th scope="col">Payment type</th>

			</tr>
		</thead>
		<tbody>

			<%
			BagOrderImpl dao = new BagOrderImpl(DBConnect.getConn());
			List<Bag_Order> blist = dao.getAllOrder();
			for (Bag_Order b : blist) {
			%>
			<tr>
				<th scope="row"><%=b.getOrderId()%></th>
				<td><%=b.getUsername()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getFulladd()%></td>
				<td><%=b.getPhno()%></td>
				<td><%=b.getBagName()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getPaymentType()%></td>

			</tr>
			<%
			}
			%>


		</tbody>
	</table>
	<div style="margin-top: 139px;">
		<%@include file="footer.jsp"%></div>
</body>
</html>