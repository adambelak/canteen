<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title><spring:message code="sidedish.page.title" /> @ canteen</title>
<jsp:include page="../../../templates/css.jsp" />
</head>
<body>
	<jsp:include page="../../../templates/header.jsp" />
	<div class="container" id="page-content">
		<div class="row">
			<div class="col-xs-12">
				<div class="page-header">
					<h1 class="clearfix">
						<spring:message code="sidedish.page.header" />
						<a href="<c:url value='/admin/side_dishes/add' />" class="btn btn-default pull-right"
						   data-toggle="modal" data-target="#side-dish-modal" data-backdrop="static">
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
							<th><spring:message code="sidedish.table.name.label" /></th>
							<th class="text-right"><spring:message code="sidedish.table.actions.label" /></th>
						</tr>
					<thead>
					<tbody>
					<c:forEach var="sideDish" items="${sideDishesModel.items}">
							<tr>
								<td>${sideDish.name}</td>
								<td class="text-right">
									<a href="<c:url value='${sideDish.editUrl}' />" class="btn btn-xs btn-primary"
									   data-toggle="modal" data-target="#side-dish-modal" data-backdrop="static">
										<i class="fa fa-fw fa-pencil"></i>
									</a>
									<a href="<c:url value='${sideDish.removeUrl}' />" class="btn btn-xs btn-danger"
									   data-toggle="modal" data-target="#side-dish-modal" data-backdrop="static">
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
	<div class="modal fade" id="side-dish-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content"></div>
		</div>
	</div>
	<jsp:include page="../../../templates/script.jsp" />
</body>
</html>