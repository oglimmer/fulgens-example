<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Hello World!</h1>
	<p>
		This is what we got from the database: <c:out value="${DBACCESS.something}"/>
	</p>
</body>
</html>
