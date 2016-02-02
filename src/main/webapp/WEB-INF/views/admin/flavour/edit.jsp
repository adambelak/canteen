<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="form_action" value="/admin/flavours/edit"/>
<form:form modelAttribute="flavourRequest" action="${form_action}" method="post">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">
		<spring:message code="flavour.edit.header" arguments="${flavourRequest.name}" />
	</h4>
</div>
<div class="modal-body">
	<form:hidden path="id"/>
	<div class="form-group" id="input-name-group">
		<label for="input-name"><spring:message code="flavour.form.label.name" /></label>
		<spring:message code="flavour.form.placeholder.name" var="name_placeholder" />
		<form:input path="name" id="input-name" class="form-control" placeholder="${name_placeholder}" />
		<span class="help-block"> </span>
	</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">
		<spring:message code="flavour.form.button.close" />
	</button>
	<button type="submit" class="btn btn-primary">
		<spring:message code="flavour.form.button.save" />
	</button>
</div>
</form:form>
<script type="text/javascript" src="<c:url value='/assets/js/form.js' />"></script>