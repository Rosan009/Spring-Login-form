<%@ page language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Style.css">
    <title>Login Page</title>
</head>
<body>
<h1>Register Page</h1>

<script>
    function myFunction(event) {
        var pass1 = document.getElementById("password").value;
        var pass2 = document.getElementById("confirmPassword").value;

        if (pass1 !== pass2) {
            document.getElementById("password").style.borderColor = "#E34234";
            document.getElementById("confirmPassword").style.borderColor = "#E34234";
            alert("Passwords do not match!");
            return false;
        } else {
            return true;
        }
    }
</script>
<form id="regForm" method="post" onsubmit="return myFunction(event)" action="/register">
    <label for="username">UserName:</label>
    <input id="username" name="username" type="text" placeholder="Enter your UserName" required>
    <label for="email">Email:</label>
    <input id="email" name="email" type="email" placeholder="Enter your email" required>
    <label for="password">Password:</label>
    <input id="password" name="password" type="password" placeholder="Enter your password" required>
    <label for="confirmPassword">Re-Enter Password:</label>
    <input id="confirmPassword" type="password" name="confirmPassword" placeholder="Re-enter your password" required>
    <button type="submit">Submit</button>
</form>
</body>
</html>
