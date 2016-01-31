<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin page</title>
    <jsp:include page="../../templates/css.jsp"/>
</head>
<body>
<div class="jumbotron jumbotron-error">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <h1>404 <i class="fa fa-fw fa-warning"></i></h1>
                <p>Sorry, but the page you are looking for was either not found or does not exist. <br/>
                    Try refreshing the page or click the button below to go back to the homepage.</p>
                <p>
                    <a class="btn btn-primary btn-lg" href="<c:url value='/' />" role="button">
                        Go back to homepage
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../templates/script.jsp"/>
</body>
</html>