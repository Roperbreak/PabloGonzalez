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
					<th>Postdate</th>
					<th>Mark</th>
					<th>Content</th>
				</tr>

				<c:forEach items="${user.codelist}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.postdate}</td>
						<td>${item.marks}</td>
						<td>${item.content}</td>
						<td><form:form modelAttribute="code" method="POST"
								action="markcode?id=${item.id}">
								<form:input path="marks" type="number" />
								<input type="submit" value="Mark" />
							</form:form></td>
					</tr>
					<br>

				</c:forEach>
			</table>
		</div>
		<br> <br> To resolve the view of code: copy and paste on
		programming too and do "format code".
		<div align="right">
			<a href="/teacherpanel">Come back home</a>
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
