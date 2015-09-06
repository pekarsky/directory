<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Persons</title>
</head>
<body>
<h1>Persons List</h1>

<c:forEach items="${personList}" var="person">
    <a href="<c:url value="/person/${person.id}"/>">${person.id}</a>
    ${person.firstName} ${person.middleName} ${person.lastName}
    <a href="<c:url value="/group/${person.id}"/>">member of</a>
    <br />
</c:forEach>

</body>
</html>
