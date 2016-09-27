<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || password == null || !username.equals("aviskar") || !password.equals("pass")) {
			out.print("You're not authenticated user.");
		} else {
			out.print("You're authenticated user.");
		}
	%>

</body>
</html>