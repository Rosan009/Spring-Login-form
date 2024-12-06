<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subjects</title>

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
<!-- Header Section -->
<header class="bg-primary text-white text-center py-3">
    <h1>Subjects</h1>
    <p class="lead">Manage the subjects for the students</p>
</header>

<!-- Main Content -->
<section class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <!-- Subject List Table -->
            <div class="card shadow">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Subject List</h4>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Subject Name</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Loop through subjects and display their data dynamically -->
                        <c:forEach var="subject" items="${subjects}">
                            <tr>
                                <td>${subject.name}</td>
                                <td>
                                    <!-- Link to Assign Students to Subject -->
                                    <a href="/assignSubject?subjectId=${subject.id}" class="btn btn-info">
                                        Assign Students
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
