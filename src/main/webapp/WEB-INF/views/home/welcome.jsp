<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome page</title>
    <jsp:include page="../../templates/css.jsp" />
</head>
<body>
<jsp:include page="../../templates/header.jsp" />
<p>
Greeting : ${greeting}
This is a welcome page.
</p>
<jsp:include page="../../templates/script.jsp" />
</body>
</html>