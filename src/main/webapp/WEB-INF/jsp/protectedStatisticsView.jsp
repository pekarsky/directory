<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Protected Page: Statistics</title>
</head>
<body><h1>Protected Page: Statistics</h1>

Persons: ${personCount}<br/>
Groups: ${groupCount}
<br/>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>

<c:url value="/login?logout" var="logoutUrl" />
				<a href="${logoutUrl}">Log Out</a>
</body>
</html>
