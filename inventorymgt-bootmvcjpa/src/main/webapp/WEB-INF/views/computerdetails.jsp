<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Details</title>
</head>
<body>

<h1>Computer Details </h1>

name is <c:out value="${computer.name}"  />
<br>

id is <c:out value="${computer.id}"  />
<br>
disk size is <c:out value="${computer.diskSize}"  />
<br>


</body>
</html>