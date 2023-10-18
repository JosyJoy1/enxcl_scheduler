<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>User Registration</title>

<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/Registration.css">
<link rel="stylesheet" href="alert/dist/sweetalert.css">
</head>
<body>

<input type="hidden" id="status" value="<%=request.getAttribute("Status") %>">
 <header>
    <img class="Logo-img" src="data:image/png;base64,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" alt="Logo">

<!-- <h2 class="logo">Logo</h2> -->
<nav class="navigation">
    <a href="#">Home</a>
    <a href="#">About</a>
    
    <a href="#">Contact</a>
   <a href="Login.jsp"><button class="btnlogin_popup">Login</button></a> 
</nav>
 </header>

	<div>

		<!-- Sign up form -->
	
			<div class="Wrapper">
					<div class="form-box login">
						<h2>Sign up</h2>
					
						<form method="post" action="RegistrationServlet" class="register-form" id="register-form" onsubmit= "validateForm()">
							<div class="input-box">
								<input style="color:black;" type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							
							<div class="input-box">
							 <input style="color:black; type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							
							<div class="input-box">
							<input style="color:black; type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							
							<div class="input-box">
								
								<input style="color:black; type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="input-box">
								
								<input style="color:black; type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
							<div class="login-Rem">
								<input type="checkbox" name="agree-term" id="agree-term"
									/> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div>
								<button type="submit" name="signup" id="signup"
									class="btn" value="Register" >Sign Up</button>
							</div>
						</form>
					</div>
				
				</div>
			</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	
	<script type="text/javascript">
	var st= document.getElementById("status").value;
	if(st == "Success"){
		swal("Congrats","Account created successfully","Success");
	}
	</script>
</body>
</html>