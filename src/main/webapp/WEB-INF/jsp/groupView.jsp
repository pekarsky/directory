<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group ${group.name}</title>
</head>
<body>
<a href="<c:url value="${group.id}"/>">${group.id}</a>
${group.name}
</body>
</html>
