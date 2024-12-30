<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Marks</title>
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../../../resources/static/assets/css/style.css" rel="stylesheet">
</head>
<body>
    <!-- Header Section -->
    <header class="bg-primary text-white text-center py-3">
        <h1>Student Marks</h1>
        <p class="lead">View detailed marks for the selected student</p>
    </header>

    <!-- Student Information Section -->
    <div class="container my-4">
        <div class="row">
            <div class="col-md-4">
                <p><strong>Student Name:</strong> ${student.name}</p>
            </div>
            <div class="col-md-4">
                <p><strong>Register No:</strong> ${student.registerNo}</p>
            </div>
            <div class="col-md-4">
                <p><strong>Class Name:</strong> ${student.className}</p>
            </div>
        </div>
    </div>

    <!-- Exam Type Selection Section -->
    <div class="container mb-4">
        <form method="get" action="">
            <div class="row">
                <div class="col-md-4">
                    <label for="examType">Select Exam Type:</label>
                    <select class="form-select" id="examType" name="examtype" onchange="this.form.submit()">
                        <option value="" disabled selected>Select Exam</option>
                        <c:forEach var="exam" items="${exams}">
                            <option value="${exam}" ${exam == param.examtype ? 'selected' : ''}>${exam}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </form>
    </div>

   <div class="container">
       <c:choose>
           <c:when test="${not empty marks}">
               <table class="table table-bordered">
                   <thead>
                       <tr>
                           <th>Subject</th>
                           <th>Marks</th>
                       </tr>
                   </thead>
                   <tbody>
                       <c:forEach var="mark" items="${marks}">
                           <tr>
                               <td>${mark.subject}</td>
                               <td>${mark.mark}</td>
                           </tr>
                       </c:forEach>
                       <tr>
                           <th>Total</th>
                           <th>${totalMark}</th>
                       </tr>
                   </tbody>
               </table>
           </c:when>
           <c:otherwise>
               <p class="text-danger">${noMarksMessage}</p>
           </c:otherwise>
       </c:choose>
   </div>

    <!-- Footer -->
    <footer class="bg-light text-center text-muted py-3 mt-4">
        &copy; 2024 Class Management System. All Rights Reserved.
    </footer>

    <!-- Vendor JS Files -->
    <script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
