<%@page import="com.entity.BagDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BagDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Bags</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	
	<h3 class="text-center">Hello Admin</h3>

	<c:if test="${not empty succMsg}">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg}">
		<h5 class="text-center text-damger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>


	<table class="table table-striped ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">Bag Name</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			BagDAOImpl dao = new BagDAOImpl(DBConnect.getConn());
			List<BagDtls> list = dao.getAllBags();
			for (BagDtls b : list) {
			%>
			<tr>
				<td><%=b.getBagId()%>></td>
				<td><img src="../book/<%=b.getPhotoName()%>"
					style="width: 50px; height: 50Px"></td>
				<td><%=b.getBagName()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getBagCategory()%></td>
				<td><%=b.getStatus()%></td>

				<td><a href="edit_bags.jsp?id=<%=b.getBagId()%>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i> Edit</a> <a
					href="../delete?id=<%=b.getBagId()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a></td>
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