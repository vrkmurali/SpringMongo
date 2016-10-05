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

<table>
<thead>
<tr><td>id</td>
<td>name</td>
<td>age	</td></tr>
</thead>
<tbody>
<c:forEach items="${list}" var="student">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.age}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
