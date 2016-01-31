<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default no-radius">
	<div class="container-fluid">
		<div class="navbar-header">
		    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
			    <span class="sr-only">Toggle navigation</span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="<c:url value='/' />">&lt;canteen&gt;</a>
	    </div>
	    <div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href="<c:url value='/' />">
						<i class="fa fa-fw fa-dashboard"></i>
						Home <span class="sr-only">(current)</span>
					</a>
				</li>
				<li>
					<a href="<c:url value='/menu' />">
						<i class="fa fa-fw fa-cutlery"></i>
						Menu
					</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${isAdmin}">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<i class="fa fa-fw fa-database"></i>
						Manage <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="<c:url value='/admin/menus' />">
								<i class="fa fa-fw fa-calendar-plus-o"></i>
								Menus
							</a>
						</li>
						<li>
							<a href="<c:url value='/admin/orders' />">
								<i class="fa fa-fw fa-check-square-o"></i>
								Orders
							</a>
						</li>
						<li>
							<a href="<c:url value='/admin/users' />">
								<i class="fa fa-fw fa-users"></i>
								Users
							</a>
						</li>
						<li role="separator" class="divider"></li>
						<li>
							<a href="<c:url value='/admin/foods' />">
								<i class="fa fa-fw fa-cutlery"></i>
								Foods
							</a>
						</li>
						<li>
							<a href="<c:url value='/admin/side_dishes' />">
								<i class="fa fa-fw fa-plus"></i>
								Side dishes
							</a>
						</li>
						<li>
							<a href="<c:url value='/admin/flavours' />">
								<i class="fa fa-fw fa-plus"></i>
								Flavours
							</a>
						</li>
					</ul>
				</li>
				</c:if>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<i class="fa fa-fw fa-user"></i>
						${user} <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="disabled">
							<a href="<c:url value='/settings' />">
								<i class="fa fa-fw fa-gears"></i>
								Settings
							</a>
						</li>
						<li>
							<a href="<c:url value='/my-orders' />">
								<i class="fa fa-fw fa-shopping-cart"></i>
								My orders
							</a>
						</li>
						<li role="separator" class="divider"></li>
						<li>
							<a href="<c:url value='/logout' />">
								<i class="fa fa-fw fa-sign-out"></i>
								Logout
							</a>
						</li>
					</ul>
				</li>
			</ul>
	    </div>
	</div>
</nav>
<jsp:include page="alerts.jsp" />