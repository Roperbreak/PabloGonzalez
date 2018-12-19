<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<title>Welcome to Academybox</title>
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

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-blue w3-collapse w3-top w3-large w3-padding"
		style="z-index: 3; width: 300px; font-weight: bold;" id="mySidebar">
		<br> <a href="javascript:void(0)" onclick="w3_close()"
			class="w3-button w3-hide-large w3-display-topleft"
			style="width: 100%; font-size: 22px">Close Menu</a>
		<div class="w3-container">
			<h3 class="w3-padding-64">
				<b>AcademyBox<br></b>
			</h3>
		</div>
		<div class="w3-bar-block">
			<a href="#" onclick="menu_close()"
				class="w3-bar-item w3-button w3-hover-white">Home</a> <a
				href="#newtask" onclick="menu_close()"
				class="w3-bar-item w3-button w3-hover-white">Create a new task</a> <a
				href="#ranking" onclick="menu_close()"
				class="w3-bar-item w3-button w3-hover-white">Take a look into
				the ranking</a> <a href="#contact" onclick="menu_close()"
				class="w3-bar-item w3-button w3-hover-white">Ask a doubt to the
				teacher</a>
			<c:if test="${sessionUser.usertype.idtype==2}">
				<a href="#teacherpanel" onclick="menu_close()"
					class="w3-bar-item w3-button w3-hover-white">Teacher panel</a>
			</c:if>
			<c:if test="${sessionUser.usertype.idtype==3}">
				<a href="#adminpanel" onclick="menu_close()"
					class="w3-bar-item w3-button w3-hover-white">Admin panel</a>
			</c:if>
			<c:if test="${not empty sessionUser}">
				<a href="logout" class="w3-bar-item w3-button w3-hover-white">Logout</a>
			</c:if>
		</div>
	</nav>

	<!-- Top menu on small screens -->
	<header
		class="w3-container w3-top w3-hide-large w3-blue w3-xlarge w3-padding">
		<a href="javascript:void(0)" class="w3-button w3-blue w3-margin-right"
			onclick="menu_open()">MENU</a> <span>AcademyBox</span>
	</header>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="menu_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 340px; margin-right: 40px">
		<h1>
			Welcome
			<c:out value="${sessionUser.name}"></c:out>
		</h1>


		<!-- Header -->
		<div class="w3-container" style="margin-top: 80px" id="showcase">
			<h1 class="w3-jumbo">
				<b>AcademyBox</b>
			</h1>
			<h1 class="w3-xxxlarge w3-text-blue">
				<b>Evolute your classes</b>
			</h1>
		</div>

		<!-- NewTask -->
		<div class="w3-container" id="newtask" style="margin-top: 75px">
			<h1 class="w3-xxxlarge w3-text-blue">
				<b>Go coding!</b>
			</h1>
			<hr style="width: 50px; border: 5px solid blue" class="w3-round">
			<a href="newtask"><button type="button"
					class="w3-button w3-block w3-padding-short w3-blue w3-margin-bottom">Get
					a new task</button></a>

		</div>

		<!-- Ranking -->
		<div class="w3-container" id="ranking" style="margin-top: 75px">
			<h1 class="w3-xxxlarge w3-text-blue">
				<b>Ranking</b>
			</h1>
			<hr style="width: 50px; border: 5px solid blue" class="w3-round">
			<p>Class ranking</p>
			<p>This function is under maintenance and it's optional for
				alumns</p>

		</div>

		<!-- Doubts falta form de Spring-->
		<c:if test="${sessionUser.usertype.idtype==1}">
			<div class="w3-container" id="contact" style="margin-top: 75px">
				<h1 class="w3-xxxlarge w3-text-blue">
					<b>Ask to a teacher</b>
				</h1>
				<hr style="width: 50px; border: 5px solid blue" class="w3-round">
				<p>Do you need help from the teacher? Ask him whatever do you
					want.</p>
				<form action="sendoubt" method="POST">
					<div class="w3-section">
						<label>Doubt:</label> <input class="w3-input w3-border"
							type="text" name="doubt" required>
					</div>
					<input type="submit" value="send" />
				</form>
			</div>
		</c:if>

		<c:if test="${sessionUser.usertype.idtype==2}">
			<div class="w3-container" id="teacherpanel" style="margin-top: 75px">
				<h1 class="w3-xxxlarge w3-text-blue">
					<b>Teacher</b>
				</h1>
				<hr style="width: 50px; border: 5px solid blue" class="w3-round">
				<p>Teacher panel</p>
				<p>
					Correct code, solve doubts or change alumn data(SOON). <a
						href="teacherpanel">Click here to get in tPanel</a>
				</p>

			</div>
		</c:if>
		<c:if test="${sessionUser.usertype.idtype==3}">
			<div class="w3-container" id="adminpanel" style="margin-top: 75px">
				<h1 class="w3-xxxlarge w3-text-blue">
					<b>Admin</b>
				</h1>
				<hr style="width: 50px; border: 5px solid blue" class="w3-round">
				<p>Admin panel</p>
				<p>
					View, delete or create (SOON) options. <a href="adminpanel">Click
						here to get in aPanel</a>
				</p>

			</div>
		</c:if>

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

	<script>
		// Script to open and close sidebar
		function menu_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}

		function menu_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}

		// Modal Image Gallery
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
			var captionText = document.getElementById("caption");
			captionText.innerHTML = element.alt;
		}
	</script>

</body>
</html>
