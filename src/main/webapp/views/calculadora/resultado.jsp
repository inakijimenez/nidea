<jsp:include page="../../templates/head.jsp"></jsp:include>
<jsp:include page="../../templates/navbar.jsp"></jsp:include>

<%
	float resul = (Float) request.getAttribute("resultado");
	String operacion = (String) request.getAttribute("operacion");
%>
<h1>
	Resultado de la operacion <%=operacion %> es 
	<%=resul%></h1>


<jsp:include page="../../templates/footer.jsp"></jsp:include>


