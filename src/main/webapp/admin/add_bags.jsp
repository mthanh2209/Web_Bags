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
	<c:if test="${empty userobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Add Bags</h4>

						<c:if test="${not empty failedMsg}">
							<p class="text-center text-damger">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="../add_bags" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<label for="exampleInputEmail">Bag Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1">
							</div>



							<div class="form-group">
								<label for="inputState">Bag Categories</label> <select
									id="inputState" name="btype" class="form-control">
									<option selected>--select--</option>
									<option value="New">New Bag</option>
								</select>
							</div>

							<div class="form-group">
								<label for="inputState">Bag Status</label> <select
									id="inputState" name="bstatus" class="form-control">
									<option selected>--Select--</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>

							<div class="form-group">
								<label for="exampleControlFile1">Upload Photo</label> <input
									name="bimg" type="file" class="form-control-file"
									id="exampleControlFile1">
							</div>

							<button type="submit" class="btn btn-primary">Add</button>
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