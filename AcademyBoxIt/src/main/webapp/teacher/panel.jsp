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
		<!-- Header -->
		<div class="w3-container" style="margin-top: 80px" id="showcase">
			<h1 class="w3-jumbo">
				<b>TeacherPanel</b>
			</h1>
			<h1 class="w3-xxxlarge w3-text-blue">
				<b>Welcome teacher</b>
			</h1>
		</div>


		<div class="w3-container" id="codedrawer" style="margin-top: 5px">

			<hr style="width: 50px; border: 5px solid blue" class="w3-round">
			<label>Click on whatever you want to do</label>
			<div class="w3-container" id="teacheroptions"
				style="margin-top: 75px"></div>
			<a href="/teacherpanel/options">
				<button type="button"
					class="w3-button w3-block w3-padding-short w3-blue w3-margin-bottom">Choose
					an alumn</button>
			</a>



		</div>
		<div align="right">
			<a href="/home">Come back home</a>
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