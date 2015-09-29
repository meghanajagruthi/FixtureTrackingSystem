<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Login Page - Eleconor FMS</title>

<meta name="description" content="User login page">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="assets/js/spin.min.js"></script>
<script src="assets/js/ladda.min.js"></script>
<link rel="stylesheet" href="assets/css/ladda-themeless.min.css">

<!-- basic styles -->

<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/font-awesome.css">

<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<link rel="stylesheet" href="assets/css/font.css">

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css">
<link rel="stylesheet" href="assets/css/ace-rtl.min.css">

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<style>
.alert {
	padding: 8px 35px 8px 14px;
	margin-bottom: 7px;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
	background-color: #fcf8e3;
	border: 1px solid #fbeed5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	width: 97%;
	margin-left: 1.4%;
	border-radius: 10px;
	margin-top: -16px;
}

.alert-danger,.alert-error {
	color: white;
	background-color: #FE642E;
	font-size: 13px;
	border-color: #eed3d7;
}

.alert-danger h4,.alert-error h4 {
	color: #833332;
}
</style>


</head>

<body class="login-layout" style="background: white">
	<div class="navbar navbar-default navbar-fixed-top" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="index.jsp" class="navbar-brand"><img
					src="assets/img/elecnorIcon.png" width="55px" alt="Belco Logo"
					title="Home"></img> <small style="color: #FE9A2E"><b>
							FTS </b>  </small> </a>
				<!-- /.brand -->

			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" style="margin-top: 5%">
		<div class="main-content" style="width: -54%;">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<a><img src="assets/img/elecnorIcon.png" width="75px"
									height="39px" alt="Belco Logo" title="Home"
									style="margin-left: 13%; margin-top: -7px"></img></a> <span
									class="blue">FTS</span> <span class="blue">Application</span>
							</h1>
							<br>
							<h4 class="blue" style="margin-left: 13%"></h4>
						</div>

						<div class="space-3"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border"
								style="width: 115%">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<!-- style="margin-left: 7%" -->
											<!-- <i class="fa fa-coffee green"></i> -->
											Please Enter Your Credentials
										</h4>

										<div class="space-6"></div>

										<form action="login" method="post" id="formIdSubmit">
											<%
												String loginErrorMsg = (String) request
														.getAttribute("loginErrorMsg");
												if (loginErrorMsg != null && !loginErrorMsg.equals("")) {
											%>
											<div class="alert alert-error">
												<button type="button" class="close" data-dismiss="alert"
													onclick="$('.alert').hide()"
													style="position: absolute; left: 83%">x</button>
												<strong> Error !!! </strong> Incorrect Username or Password.
											</div>

											<!-- <div
												style="height: 40px; background-color: #FFBABA; border-radius: 8px; -moz-border-radius: 5px; -webkit-border-radius: 5px; margin-bottom: 20px; margin-top: -20px;">
												<label
													style="margin-left: 10px; font-size: 15px; font-weight: bold; line-height: 40px; color: #FF0000;">
													Incorrect Username or Password !!! </label> <label
													style="margin-left: 180px; font-size: 20px; font-weight: bold; line-height: 40px; color: #666666; cursor: pointer;">X
												</label>
											</div> -->
											<%
												}
											%>
											<fieldset>
												<label class="block clearfix input-group" id="userNameError">
													<span class="input-group-addon"><i
														class="fa fa-user" style="margin-left: -2%"></i> <input
														type="text" name="userName" id="userName"
														class="form-control" placeholder="Username.." 
														onkeydown="checkErrorClass('userNameError','userName',this.id)"
														style="height: 40px"> <!-- <i class="fa fa-user"></i> -->
												</span>
												</label> <label class="block clearfix input-group"
													id="passwordError"> <span class="input-group-addon"><i
														class="fa fa-lock" style="margin-left: -2%"></i> <input
														type="password" name="password" id="password"
														class="form-control" placeholder="Password.."
														onkeydown="checkErrorClass('passwordError','password',this.id)"
														style="height: 40px"> <!-- <i class="fa fa-lock"></i> -->
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix" style="text-align: center;">

													<button type="reset" onclick="resetForm()"
														class="width-45 btn btn-large btn-primary">
														<i class="fa fa-undo bigger-110"></i> Reset
													</button>

													<button type="submit" id="loginButtonId" 
													data-style="expand-right" data-color="red" data-size="xl"
														class="width-45 btn btn-large btn-primary ladda-button"
														style="margin-left: 6%">
														<i class="fa fa-key"></i> Login
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>


									</div>
									<!-- /widget-main -->

									<div class="toolbar clearfix">
										<div>
											<a href="login.jsp"
												onClick="show_box(&#39;forgot-box&#39;); return false;"
												class="forgot-password-link"> <i
												class="fa fa-arrow-left"></i> I forgot my password
											</a>
										</div>


									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border"
								style="width: 115%">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<!-- <i class="fa fa-key"> -->
											Retrieve Password
										</h4>
										<div class="space-6"></div>
										<p class="red">Enter your Email to receive instructions</p>
										<form>
											<fieldset>
												<label class="block clearfix input-group"> <span
													class="input-group-addon"><i class="fa fa-envelope"
														style="margin-left: -2%"></i> <input type="email"
														class="form-control" placeholder="Email"
														style="height: 40px"> </span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="fa fa-lightbulb"></i> Send Me!
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /widget-main -->

									<div class="toolbar center">
										<a href="login.jsp"
											onClick="show_box(&#39;login-box&#39;); return false;"
											class="back-to-login-link" style="margin-left: 65%"> Back
											to login <i class="fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /forgot-box -->

							<!-- /signup-box -->
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script src="assets/js/jquery.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='js/jquery.min.js'>"+"<"+"/script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">

	function validateForm(laddaButton) {
	 if ($('#userName').val() == '') {
	  $('#userName').attr("placeholder", "User Name cannot be empty.");
	  $('#userNameError').addClass("has-error");
	  document.getElementById('userName').focus();
	  document.getElementById('userName').style.background = '#FBEFF2' ;
	  document.getElementById('userName').style['font-size'] = '13px';
	  return false;
	 }
	 if ($('#password').val() == '') {
	  $('#password').attr("placeholder", "Password cannot be empty.");
	  $('#passwordError').addClass("has-error");
	  document.getElementById('password').focus();
	  document.getElementById('password').style.background = '#FBEFF2' ;
	  document.getElementById('password').style['font-size'] = '13px';
	  return false;
	 }
	 else
	  {
		 if(laddaButton != undefined){
		 var l = Ladda.create(laddaButton);
			l.start();
		 }
	  $("#formIdSubmit").submit();
	  }
	 }

	function checkErrorClass(divId,id, elementId){
	  
	   $('#' + divId).removeClass("has-error");
	   document.getElementById(id).style.removeProperty("background");
	   document.getElementById(id).style.removeProperty("font-size");
	  
	 }

</script>
	<script>
 function resetForm() {
	$('#userName').attr("placeholder", "Username..");
    $('#userNameError').removeClass("has-error");
    document.getElementById('userName').style.removeProperty("background");
	document.getElementById('userName').style.removeProperty("font-size"); 
	$('#password').attr("placeholder", "Password..");
	$('#passwordError').removeClass("has-error");
	 document.getElementById('password').style.removeProperty("background");
	 document.getElementById('password').style.removeProperty("font-size");
 }
 //code for ladda style on buttons
 $(function() {
		$('#loginButtonId').click(function(e) {
			validateForm(this);
			return false;
		});
	});
</script>

	<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			};
		</script>
</body>
</html>