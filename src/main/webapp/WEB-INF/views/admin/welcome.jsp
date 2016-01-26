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
<p>
Dear <strong>${user}</strong>, Welcome to Admin Page.
</p>
<jsp:include page="../../templates/script.jsp" />
</body>
</html>