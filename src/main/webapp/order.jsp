<%@page import="com.entity.Bag_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BagOrderImpl"%>
<%@page import="com.entity.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Bag</title>
<%@ include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>


	<div class="container p-1">
		<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">Name</th>
					<th scope="col">Bag Name</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>

				</tr>
			</thead>
			<tbody>

				<%
				User u = (User) session.getAttribute("userobj");
				BagOrderImpl dao = new BagOrderImpl(DBConnect.getConn());
				List<Bag_Order> blist = dao.getBag(u.getEmail());
				for (Bag_Order b : blist) {
				%>
				<tr>
					<th scope="row"><%=b.getOrderId()%></th>
					<td><%=b.getUsername()%></td>
					<td><%=b.getBagName()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getPaymentType()%></td>
				</tr>

				<%
				}
				%>



			</tbody>
		</table>
	</div>
	<div class="credit mt-2 text-center ">
		created by <span>3CE</span> | all rights reserved!
	</div>
</body>
</html>