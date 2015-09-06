<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Groups</title>
</head>
<body><h1>Groups List</h1>

<c:forEach items="${personGroups}" var="group">
    <a href="<c:url value="/person/${group.id}"/>">${group.id}</a>
    ${group.name}
    <br />
</c:forEach>

</body>
</html>
