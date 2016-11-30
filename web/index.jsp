<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<p>Select parser:</p>
<form action="controller" method="post">
    <input type="radio" name="XMLParser" title="DOM" value="DOM">DOM<br>
    <input type="radio" name="XMLParser" title="SAX" value="SAX">SAX<br>
    <input type="radio" name="XMLParser" title="STaX" value="STAX">STaX<br>
    <br>
    <input type="submit" name="button" value="Parse">
    <input type="hidden" name="command" value="parse">
</form>
</body>
</html>
