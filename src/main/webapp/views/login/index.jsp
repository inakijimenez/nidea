<jsp:include page="../../templates/head.jsp"></jsp:include>
<jsp:include page="../../templates/navbar.jsp"></jsp:include>
<jsp:include page="../../templates/alert.jsp"></jsp:include>

<div class="container">
	<form action="login" method="post">

		<div class="form-group">
			<input type="text" class="form-control" id="nombre"
				placeholder="Nombre Usuario" name="nombre" required autofocus>
				<label for="nombre">Nombre de Usuario</label>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pass"
				placeholder="Contraseña" name="pass" required>
				<label for="pass">Contraseña</label>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>

<jsp:include page="../../templates/footer.jsp"></jsp:include>