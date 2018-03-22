<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<!-- <form action="generar-mesa" method="POST"> -->

	

<!-- 	<label for="patas">Numero de Patas: </label> <input type="number" -->
<!-- 		required value="4" name="patas"> <input type="submit" -->
<!-- 		value="Calcular Precio"> -->
<!-- </form> -->
<%
		Mesa mesa = (Mesa) request.getAttribute("mesa");
	%>
<form action="generar-mesa" method="POST">
	<div class="form-group">
		<label for="patas">Patas: </label> <input type="number" required value="4" name="patas"
			class="form-control" id="patas" placeholder="Num. Patas">
	</div>

	<div class="form-group">
		<label for="material">Material: </label> <select class="form-control"
			id="material" name="material">
			<option value="-1">...</option>
			<option value="0">Madera</option>
			<option value="1">Acero</option>
			<option value="2">Aluminio</option>
			<option value="3">Plastico</option>
		</select>
	</div>
	color

	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

<p>
	Precio:
	<%=mesa.getPrecio()%>
	€
</p>
<jsp:include page="templates/footer.jsp"></jsp:include>