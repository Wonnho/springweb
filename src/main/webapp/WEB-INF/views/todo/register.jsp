<@taglib prefix="form" url="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
<title>register</title>
</head>

<body>
<form action="/todo/register" method="post" >
<div>
TITLE: <input type="text" name="title" placeholder="INSERT TITLE">
</div>


<div>
DueDate: <input type="date" name="dueDate" value="2026-05-08">
</div>

<div>
Writer: <input type="text" name="writer">
</div>

<div>
Done: <input type="checkbox" name="done">
</div>

<div>
<button type="submit">Register</button>
</form>

</body>

</html>