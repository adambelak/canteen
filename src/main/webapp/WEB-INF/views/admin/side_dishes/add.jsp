<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="form_action" value="/admin/side_dishes/add"/>
<form:form modelAttribute="sideDishRequest" action="${form_action}" method="post">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title"><spring:message code="sidedish.add.header" /></h4>
</div>
<div class="modal-body">
		<div class="form-group" id="input-name-group">
			<label for="input-name"><spring:message code="sidedish.form.label.name" /></label>
			<spring:message code="sidedish.form.placeholder.name" var="name_placeholder" />
			<form:input path="name" id="input-name" class="form-control" placeholder="${name_placeholder}" />
			<span class="help-block"> </span>
		</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">
		<spring:message code="sidedish.form.button.close" />
	</button>
	<button type="submit" class="btn btn-primary">
		<spring:message code="sidedish.form.button.save" />
	</button>
</div>
</form:form>
<script type="text/javascript" src="<c:url value='/assets/js/form.js' />"></script>