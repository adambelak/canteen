<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Manage flavors @ canteen</title>
    <jsp:include page="../../../templates/css.jsp" />
</head>
<body>
<jsp:include page="../../../templates/header.jsp" />
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="page-header">
				<h1 class="clearfix">
					Flavors
					<button type="button" class="btn btn-success pull-right" id="add">
						<i class="fa fa-fw fa-plus"></i>
					</button>
				</h1>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
	        <table class="table table-striped">
	        	<thead>
					<tr>
						<th>Name</th>
						<th class="text-right">Actions</th>
					</tr>
	          	<thead>
	          	<tbody>
					<c:forEach var="flavor" items="${flavorsModel.items}">
					<tr>
						<td>${flavor.name}</td>
						<td class="text-right">
							<button type="button" class="btn btn-xs btn-info" id="edit">
								<i class="fa fa-fw fa-pencil"></i>
							</button> 
							<button type="button" class="btn btn-xs btn-danger" id="remove">
								<i class="fa fa-fw fa-times"></i>
							</button>
						</td>
					</tr>
					</c:forEach>
	          	</tbody>
	        </table>
		</div>
	</div>
</div>
<jsp:include page="../../../templates/script.jsp" />
</body>
</html>