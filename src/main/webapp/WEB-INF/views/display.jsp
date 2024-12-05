<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<script>
  function enableEdit(button)
  {
    const row = button.parentElement.parentElement;

    if (button.innerText === "Edit")
    {
      button.innerText = "Submit";
      button.className = "submit-button";
      for (let i = 0; i < row.cells.length - 2; i++)
      {
        row.cells[i].setAttribute("contenteditable", "true");
        row.cells[i].style.border = "1px solid #ddd";
      }
    }
    else
    {
      button.innerText = "Edit";
      button.className = "edit-button";
      for (let i = 0; i < row.cells.length - 2; i++)
      {
        row.cells[i].removeAttribute("contenteditable");
        row.cells[i].style.border = "none";
      }
    }
      const id = row.cells[0].innerText;
      const username = row.cells[1].innerText;
      const email = row.cells[2].innerText;

      const data = {id, username, email};
      fetch("/display", {
        method: "PUT",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams(data),
      })
              // .then((response) => response.text())
              // .then((result) => {
              //   alert("Data updated successfully!");
              // })
              // .catch((error) => {
              //   alert("Error updating data: " + error.message);
              // });
    }
  function del(button)
  {
    const row = button.parentElement.parentElement;
    const id = row.cells[0].innerText;
    fetch("/display", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: new URLSearchParams({ id })
    })
  }
</script>
<h1>User List</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Action</th>
    <th>Delete</th>
  </tr>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td><button class="edit-button" onclick="enableEdit(this)">Edit</button></td>
      <td><button class="delete-button" onclick="del(this)">Delete</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
