<jsp:include page="../../templates/head.jsp"></jsp:include>
<jsp:include page="../../templates/navbar.jsp"></jsp:include>
<jsp:include page="../../templates/alert.jsp"></jsp:include>



<div class="container">
	<form action="calculadora" method="post">

		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="operador1">Operador 1</label> <input type="text"
					name="operador1" class="form-control" id="operador1" placeholder="2,2">
			</div>
			<div class="form-group col-md-4">
				<label for="operacion">Operacion</label> <select id="operacion"
					name="operacion" class="form-control">
					<option selected>Elige...</option>
					<option value="0">Sumar</option>
					<option value="1">Restar</option>
					<option value="2">Multiplicar</option>
					<option value="3">Dividir</option>
				</select>
			</div>
			<div class="form-group col-md-4">
				<label for="operador2">Operador 2</label> <input type="text"
					name="operador2" class="form-control" id="operador2" placeholder="2,2">
			</div>
		</div>

		<button class="btn btn-primary btn-block" type="submit">Calcular</button>
	</form>

</div>



<jsp:include page="../../templates/footer.jsp"></jsp:include>