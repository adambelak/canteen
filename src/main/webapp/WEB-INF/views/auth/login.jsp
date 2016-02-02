<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="login.page.title" /> @ Canteen</title>
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
								<spring:message code="login.form.error" />
							</div>
						</c:if>
						<c:if test="${not empty logout}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<spring:message code="logout.form.success" />
							</div>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2">
						<fieldset>
							<legend><spring:message code="login.form.legend" /></legend>
							<div class="form-group">
								<label for="username-field" class="sr-only"><spring:message code="login.form.label.username" /></label>
								<input type="text" class="form-control" name="username" id="username-field" placeholder="<spring:message code="login.form.label.username" />" />					
							</div>
							<div class="form-group">
								<label for="password-field" class="sr-only">Password</label>
								<input type="password" class="form-control" name="password" id="password-field" placeholder="<spring:message code="login.form.label.password" />" />	
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<button type="submit" class="btn btn-block btn-primary btn-default">
								<spring:message code="login.form.button.submit" />
							</button>
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