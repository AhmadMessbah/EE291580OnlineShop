<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h4 style="color: red">${sessionScope.error}</h4>
<form action="/login.do" method="post">
    <label for="userId">UserName</label>
    <input id="userId" type="text" name="username" placeholder="Username" value="${cookie.username.value}">

    <label for="passId">Password</label>
    <input id="passId" type="password" name="password" placeholder="Password" value="${cookie.password.value}">

    <label for="rememberId">Remember Me</label>
    <input id="rememberId" type="checkbox" name="remember">
    <input type="submit" value="Login">
</form>
</body>
</html>
