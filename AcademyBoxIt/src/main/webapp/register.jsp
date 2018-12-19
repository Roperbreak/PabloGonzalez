<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="images/fav.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins">
<link rel="stylesheet" type="text/css" href="CSS\style.css">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="app.name" /></title>
</head>
<body>

	<h1 align="center">
		<spring:message code="app.welcome" />
	</h1>
	<div align="center">

		<%-- <tr><td><label for="session"><spring:message code="login.dontlogout"/></label><input type="checkbox" name="session" id="session"></td>
 --%>
		<form:form modelAttribute="user" method="POST" action="register">

			<table>
				<tr>
					<td><spring:message code="login.name" /></td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="login.dni" /></td>
					<td><form:input path="dni" /></td>
					<td><form:errors path="dni" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="login.email" /></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>
				</tr>
				<tr>
					<td><spring:message code="login.password" /></td>
					<td><form:input path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="login.course" /></td>
					<td><form:select path="course.idclass" items="${courselist}"
							itemLabel="coursename" itemValue="idclass" /></td>
				</tr>

				<tr>
				<tr>
					<td><input type="submit"
						value=<spring:message code="register.submit"/>></td>
				</tr>
			</table>
		</form:form>
		<a href=login><spring:message code="back.page" /></a>
	</div>
	<p align=center>
		<a href="?lang=es"> <img
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Flag_of_Spain_%28Civil%29.svg/200px-Flag_of_Spain_%28Civil%29.svg.png"
			alt="img.alt.es" style="width: 20px; height: 30x; border: 0;">
		</a> <a href="?lang=en"> <img
			src="https://upload.wikimedia.org/wikipedia/commons/b/be/Flag_of_England.svg"
			alt="img.alt.en" style="width: 20px; height: 30x; border: 0;">
		</a> <br>
		<spring:message code="french.notready" />

		<img src="http://banderasmundo.es/banderas/francia.png"
			alt="img.alt.fr" style="width: 20px; height: 30x; border: 0;">

	</p>

</body>
</html>