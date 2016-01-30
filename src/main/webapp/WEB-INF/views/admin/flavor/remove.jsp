<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="form_action"  value="/admin/flavors/remove" />
<form:form modelAttribute="flavorRequest" action="${form_action}" method="post" >
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">Remove flavor: ${flavorRequest.name}</h4>
</div>
<div class="modal-body">
		<div class="alert alert-warning" role="alert">
			<strong>Are you sure you want to delete this item?</strong>
		</div>
		<form:hidden path="id"/>
		<div class="form-group disabled" id="input-name-group">
			<label for="input-name">Name</label>
			<form:input path="name" id="input-name" class="form-control disabled" placeholder="Name" readonly="true" />
			<span class="help-block"> </span>
		</div>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	<button type="submit" class="btn btn-danger">Remove</button>
</div>
</form:form>
<script type="text/javascript" src="<c:url value='/assets/js/form.js' />"></script>