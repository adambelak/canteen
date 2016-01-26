<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin page</title>
    <jsp:include page="../../templates/css.jsp" />
</head>
<body>
<jsp:include page="../../templates/header.jsp" />
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-10 col-sm-offset-1">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<strong>Warning!</strong> You are not authorized to access this page.
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../templates/script.jsp" />
</body>
</html>