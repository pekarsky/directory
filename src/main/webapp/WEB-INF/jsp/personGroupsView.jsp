<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Groups for Person ${person.lastName}</title>
</head>
<body><h1>Groups List for Person ${person.lastName}</h1>

<c:forEach items="${allPersonGroups}" var="group">
    <a href="<c:url value="/group/${group.id}"/>">${group.id}</a>
    ${group.name}
    <br />
</c:forEach>

</body>
</html>
