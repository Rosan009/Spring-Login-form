<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mark List</title>

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
<!-- Header Section -->
<header class="bg-primary text-white text-center py-3">
    <h1>Mark List</h1>
    <p class="lead">View and manage marks for the students</p>
</header>

<!-- Main Content -->
<section class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <!-- Mark List Table -->
            <div class="card shadow">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Marks for Subject: ${subjectName}</h4>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Student Name</th>
                            <th>Class</th>
                            <th>Registration Number</th>
                            <th>Marks</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Loop through students for this subject and display their marks -->
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.name}</td>
                                <td>Class ${student.studentClass}</td>
                                <td>${student.regNo}</td>
                                <td>
                                    <input type="number" class="form-control" name="marks_${student.regNo}" value="${student.marks}" min="0" max="100">
                                </td>
                                <td>
                                    <!-- Button to save/update marks -->
                                    <button class="btn btn-success" onclick="saveMarks(${student.regNo})">Save</button>
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

<script>
    function saveMarks(studentRegNo) {
        // Implement functionality to save/update the marks for the student
        alert('Marks for student ' + studentRegNo + ' saved!');
        // Make an AJAX call to save the marks
    }
</script>

</body>

</html>
