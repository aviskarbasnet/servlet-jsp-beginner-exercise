<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("name", "Aviskar");
		out.print("Name :: " + request.getAttribute("name"));
	%>

</body>
</html>