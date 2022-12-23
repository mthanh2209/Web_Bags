<%@page import="com.entity.BagDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
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
<title>User: Old Bag</title>
<%@ include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Bag Name</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
				User u = (User) session.getAttribute("userobj");
				String email = u.getEmail();
				BagDAOImpl dao = new BagDAOImpl(DBConnect.getConn());
				List<BagDtls> list = dao.getBagByOld(email, "Old");
				for (BagDtls b : list) {
				%>
				<tr>
					<td><%=b.getBagName()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getBagCategory()%></td>
					<td><a
						href="delete_old_bag?em=<%=email%>&&id=<%=b.getBagId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>

				<%
				}
				%>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>