


<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<%
	//scriplet
	//varias sentencias
	
	String name = "Pepe";
	String hora = "10.78";
%>
<h2>Hello <%=name%>!</h2>
<p>Hora: <%=hora%></p>

<a href="generar-mesa">Quieres comprar una mesa</a>
<jsp:include page="templates/footer.jsp"></jsp:include>

