<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="AddLocation" method="post" >

    <label for="localisation">Localisation:</label><br>
    <input type="text" id="localisation" name="localisation" required="required"/><br>

    <label for="profondeur">Profondeur:</label><br>
    <input type="number" id="profondeur" name="profondeur" required="required"/><br>

    <button type="submit">Save</button>
</form>
</body>
</html>
