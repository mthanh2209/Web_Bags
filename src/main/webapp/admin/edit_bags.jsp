<%@page import="com.entity.BagDtls"%>
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
<title>Admin: Add Bags</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Bags</h4>
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BagDAOImpl dao = new BagDAOImpl(DBConnect.getConn());
						BagDtls b = dao.getBagById(id);
						%>

						<form action="../editbags" method="post">
							<input type="hidden" name="id" value="<%=b.getBagId()%>">

							<div class="form-gruop">
								<label for="exampleInputEmail">Bag Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=b.getBagName()%>">
							</div>

							<div class="form-gruop">
								<label for="exampleInputEmail">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=b.getPrice()%>">
							</div>

							<div class="form-group">
								<label for="inputState">Bag Status</label> <select
									id="inputState" name="bstatus" class="form-control">

									<%
									if ("Active".equals(b.getStatus())) {
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<%
									} else {
									%>
									<option value="Inactive">Inactive</option>
									<option value="Active">Active</option>
									<%
									}
									%>
								</select>
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 139px;">
		<%@include file="footer.jsp"%></div>

</body>
</html>