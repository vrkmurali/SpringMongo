<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="${pageContext.request.contextPath}/StudentSaveForm">Student save</a><br>
<a href="${pageContext.request.contextPath}/StudentupdateFormField">Student update</a><br>
<a href="${pageContext.request.contextPath}/StudentDeleteFormField">Student delete</a><br>
<a href="${pageContext.request.contextPath}/FindStudents">Find Students</a><br>
</body>
</html>
