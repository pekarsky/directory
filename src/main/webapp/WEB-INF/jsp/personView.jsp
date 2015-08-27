<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person ${person.firstName}</title>
</head>
<body>
<a href="<c:url value="${person.id}"/>">${person.id}</a>
${person.firstName} ${person.middleName} ${person.lastName}
</body>
</html>
