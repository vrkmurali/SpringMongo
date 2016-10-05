<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form:form action="StudentUpdateForm" method="POST">
Student Id <input type="text" name="id" >
<input type="submit">
</form:form>

</body>
</html>
