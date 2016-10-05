<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form:form action="StudentSave"  commandName="student" method="post" >
<form:label path="name">student name</form:label><form:input path="name"/><br>
<form:label path="age">student age</form:label><form:input path="age"/><br>
<form:label path="id">student id</form:label><form:input path="id"/><br>
<input type="submit" value="Submit" />
</form:form>

</body>
</html>
