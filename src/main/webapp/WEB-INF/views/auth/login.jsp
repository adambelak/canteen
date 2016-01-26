<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login @ Canteen</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
    <link href="<c:url value='/assets/css/login.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid login-container">
	<div class="row">
		<form method="POST" action="<c:url value="/login"/>">
			<div class="col-xs-12 col-sm-10 col-md-6 col-sm-offset-1 col-md-offset-3">
				<div class="row login-alerts-container">
					<div class="col-xs-12 col-sm-12 col-md-12 login-alerts">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Error!</strong> Invalid username or password.
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<strong>Success!</strong> You have been logged out successfully.
							</div>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2">
						<fieldset>
							<legend>Login</legend>
							<div class="form-group">
								<label for="username-field" class="sr-only">Username</label>
								<input type="text" class="form-control" name="username" id="username-field" placeholder="Username" />					
							</div>
							<div class="form-group">
								<label for="password-field" class="sr-only">Password</label>
								<input type="password" class="form-control" name="password" id="password-field" placeholder="Password" />	
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<button type="submit" class="btn btn-block btn-primary btn-default">Login</button>
						</fieldset>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
</body>
</html>