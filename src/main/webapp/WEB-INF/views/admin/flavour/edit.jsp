<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="form_action" value="/admin/flavours/edit"/>
<form:form modelAttribute="flavourRequest" action="${form_action}" method="post">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">Edit flavour: ${flavourRequest.name}</h4>
</div>
<div class="modal-body">
		<form:hidden path="id"/>
		<div class="form-group" id="input-name-group">
			<label for="input-name">Name</label>
			<form:input path="name" id="input-name" class="form-control" placeholder="Name" />
			<span class="help-block"> </span>
		</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	<button type="submit" class="btn btn-primary">Save</button>
</div>
</form:form>
<script type="text/javascript" src="<c:url value='/assets/js/form.js' />"></script>