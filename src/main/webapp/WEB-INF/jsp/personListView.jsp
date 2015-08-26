<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Persons</title>
</head>
<body>
<h1>Persons List</h1>

<c:forEach items="${personList}" var="person">
    ${person.firstName} ${person.middleName} ${person.lastName}
    <br />
</c:forEach>

</body>
</html>
