<%@page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<h1>Login Page</h1>
<form method="post" action="/login">
    <label>UserName:</label>
    <input id="username" name="username" type="text" placeholder="Enter your username">
    <label>Password:</label>
    <input id="password" name="password" type="password" placeholder="Enter your password">
    <button type="submit">Submit</button>
    <span>or</span>
    <a href="/register">Register</a>
</form>
</body>
</html>
