<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Details</title>

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet">
</head>

<body>
<!-- Header Section -->
<header class="bg-primary text-white text-center py-3">
    <h1>Student Details</h1>
    <p class="lead">View student class and subject information below</p>
</header>

<!-- Main Content -->
<section class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <!-- Student Details Table -->
            <div class="card shadow">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Student List</h4>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Class</th>
                            <th>Subject Button</th>
                            <th>Class Button</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Loop through student list and display their data dynamically -->
                        <c:forEach var="i" begin="1" end="12">
                            <tr>
                                <td>Class ${i}</td>
                                <td>
                                    <a href="/student/studentSubject/${i}" class="btn btn-success">
                                        View Subjects
                                    </a>
                                </td>
                                <!-- Class Button -->
                                <td>
                                    <a href="/student/studentList/${i}" class="btn btn-info">
                                        View Student
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-light text-center text-muted py-3 mt-4">
    &copy; 2024 Class Management System. All Rights Reserved.
</footer>

<!-- Vendor JS Files -->
<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>
