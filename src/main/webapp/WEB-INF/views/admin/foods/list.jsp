<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title><spring:message code="food.page.title" /> @ canteen</title>
<jsp:include page="../../../templates/css.jsp" />
</head>
<body>
	<jsp:include page="../../../templates/header.jsp" />
	<div class="container" id="page-content">
		<div class="row">
			<div class="col-xs-12">
				<div class="page-header">
					<h1 class="clearfix">
						<spring:message code="food.page.header" />
						<a href="<c:url value='/admin/foods/add' />" class="btn btn-default pull-right"
						   data-toggle="modal" data-target="#food-modal" data-backdrop="static">
							<i class="fa fa-fw fa-plus"></i>
						</a>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><spring:message code="food.table.picture.label" /></th>
							<th><spring:message code="food.table.name.label" /></th>
							<th><spring:message code="food.table.description.label" /></th>
							<th class="text-right"><spring:message code="food.table.actions.label" /></th>
						</tr>
					<thead>
					<tbody>
					<c:forEach var="food" items="${foodsModel.items}">
							<tr>
								<td>
									<div class="thumbnail thumbnail-food">
										<img src="<c:url value='${food.pictureUrl}' />" alt="${food.name}" class="img-responsive img-food">
										<div class="caption">
											<a href="<c:url value='${food.uploadUrl}' />" class="btn btn-primary btn-xs btn-block" >
												<i class="fa fa-fw fa-upload"></i>
											</a>
										</div>
									</div>
								</td>
								<td>${food.name}</td>
								<td>${food.description}</td>
								<td class="text-right">
									<a href="<c:url value='${food.editUrl}' />" class="btn btn-xs btn-primary"
									   data-toggle="modal" data-target="#food-modal" data-backdrop="static">
										<i class="fa fa-fw fa-pencil"></i>
									</a>
									<a href="<c:url value='${food.removeUrl}' />" class="btn btn-xs btn-danger"
									   data-toggle="modal" data-target="#food-modal" data-backdrop="static">
										<i class="fa fa-fw fa-times"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="food-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content"></div>
		</div>
	</div>
	<jsp:include page="../../../templates/script.jsp" />
</body>
</html>