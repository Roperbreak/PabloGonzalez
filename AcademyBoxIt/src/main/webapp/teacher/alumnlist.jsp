<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<title>aPanel - AcademyBox</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins">
<link rel="icon" type="image/png" href="images/fav.png">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Poppins", sans-serif
}

body {
	font-size: 16px;
}

.w3-half img {
	margin-bottom: -6px;
	margin-top: 16px;
	opacity: 0.8;
	cursor: pointer
}

.w3-half img:hover {
	opacity: 1
}
</style>
<body>


	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 40px; margin-right: 40px">
		<div>
			<!-- Header -->
			<div class="w3-container" style="margin-top: 80px" id="showcase">
				<h1 class="w3-jumbo">
					<b>TeacherPanel Options</b>
				</h1>
			</div>
			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>DNI</th>
					<th>User type</th>
					<th>Password</th>



				</tr>
				<c:forEach items="${userlist}" var="item">
					<c:if test="${item.usertype.idtype==1}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.email}</td>
							<td>${item.dni}</td>
							<td>${item.usertype.typename}</td>

							<td>${item.password}</td>
							<td><a href="/teacherpanel/code?id=${item.id}">Codedrawer</a></td>
							<td><a href="/teacherpanel/edit?id=${item.id}">Edit
									alumn</a></td>
							<td><a href="/teacherpanel/drop?id=${item.id}">Drop
									alumn</a></td>

						</tr>
					</c:if>

				</c:forEach>

			</table>
			<c:out value="${edit}"></c:out>
		</div>

		<!-- End page content -->

	</div>
	<!-- W3.CSS Container -->
	<div class="w3-light-grey w3-container w3-padding-32"
		style="margin-top: 75px; padding-right: 58px">
		<p class="w3-right">
			Designed by Pablo <a
				href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS"
				target="_blank" class="w3-hover-opacity">with W3 Template</a>
		</p>
	</div>


</body>
</html>