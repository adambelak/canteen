<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="alerts" id="alerts">
	<c:if test="${not empty successMessage}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		${successMessage}
		</div>
	</c:if>
</div>