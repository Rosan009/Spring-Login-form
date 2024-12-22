<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mark Entry</title>

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="../../../resources/static/assets/css/style.css" rel="stylesheet">
</head>

<body>

<!-- Header Section with Improved Layout -->
<header class="bg-primary text-white text-center py-5">
    <div class="container">
        <div class="row align-items-center">
            <!-- Profile Picture Section -->
            <div class="col-md-3 text-center mb-4 mb-md-0">
                <c:if test="${not empty profilePhotoBase64}">
                    <img src="data:image/jpeg;base64,${profilePhotoBase64}" alt="Profile Photo" class="img-thumbnail" style="width: 150px; height: 150px;">
                </c:if>
            </div>

            <!-- Student Information Section -->
            <div class="col-md-9 text-center text-md-left">
                <h1 class="display-4">${students[0].name}</h1>
                <h3>Class: ${students[0].className}</h3>
                <h4>Register No: ${students[0].registerNo}</h4>
                <h5>Date of Birth: ${students[0].dataOfBirth}</h5>
                <h5>Gender: ${students[0].gender}</h5>
            </div>
        </div>
    </div>
</header>

<!-- Main Content for Mark Entry -->
<section class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <!-- Mark Entry Form -->
            <div class="card shadow">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Enter Marks for Subjects</h4>
                    <form action="/student/studentList/${students[0].className}/studentMark/${students[0].registerNo}" method="PUT">
                        <div class="mb-3">
                            <label for="studentClass" class="form-label">Exam</label>
                            <select class="form-select" id="studentExam" name="studentExam" required>
                                <option value="exam" selected disabled>Select exam</option>
                                <c:forEach var="exam" items="${exams}">
                                    <option value="${exam}">${exam}</option>
                                </c:forEach>
                            </select>
                     </div>
                        <table class="table table-bordered text-center">
                            <thead>
                            <tr>
                                <th>Subject Name</th>
                                <th>Enter Marks</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="subject" items="${subjects}">
                                <tr>
                                    <td>${subject.subject1}</td>
                                    <td>
                                        <input type="number" class="form-control" name="subject1" placeholder="Enter Marks" min="0" max="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>${subject.subject2}</td>
                                    <td>
                                        <input type="number" class="form-control" name="subject2" placeholder="Enter Marks" min="0" max="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>${subject.subject3}</td>
                                    <td>
                                        <input type="number" class="form-control" name="subject3" placeholder="Enter Marks" min="0" max="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>${subject.subject4}</td>
                                    <td>
                                        <input type="number" class="form-control" name="subject4" placeholder="Enter Marks" min="0" max="100">
                                    </td>
                                </tr>
                                <tr>
                                    <td>${subject.subject5}</td>
                                    <td>
                                        <input type="number" class="form-control" name="subject5" placeholder="Enter Marks" min="0" max="100">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="text-center mt-4">
                            <button type="submit" class="btn btn-primary">
                                Submit Marks
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-light text-center text-muted py-3 mt-5">
    &copy; 2024 Class Management System. All Rights Reserved.
</footer>

<!-- Vendor JS Files -->
<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
