<jsp:include page="../../templates/head.jsp"></jsp:include>
<jsp:include page="../../templates/navbar.jsp"></jsp:include>
<jsp:include page="../../templates/alert.jsp"></jsp:include>

<div class="container">
	<form action="login" method="post">

		<div class="form-group">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control" id="nombre" aria-describedby="nombreHelp"
				placeholder="Introduce Nombre" name="nombre"> <small
				id="nombreHelp" class="form-text text-muted">Introduce tu
				nombre.</small>
		</div>
		<div class="form-group">
			<label for="pass">Password</label> <input type="password"
				class="form-control" id="pass" placeholder="Password" name="pass">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>

<jsp:include page="../../templates/footer.jsp"></jsp:include>