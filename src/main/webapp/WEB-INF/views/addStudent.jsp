<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet">

    <style>
        .profile-container {
            text-align: center; /* Center the icon and image preview */
            margin-bottom: 15px;
        }

        .profile-icon {
            font-size: 100px; /* Set size of the icon */
            color: #6c757d;   /* Set color of the icon */
            cursor: pointer;  /* Make the icon clickable */
        }

        .profile-container {
            display: flex;
            flex-direction: column;
            align-items: center; /* Center horizontally */
            justify-content: center; /* Center vertically */
            margin-bottom: 15px;
        }

        .profile-preview {
            max-width: 150px;
            max-height: 150px;
            border-radius: 50%;
            margin-top: 10px; /* Space between icon and image */
            object-fit: cover; /* Ensures the image fits within the circle */
        }

        /* Initially, hide the upload input */
        #profilePhotoInput {
            display: none;
        }

        /* Optional: Add a margin to the image preview for better spacing */
        .profile-preview {
            margin-top: 15px;
        }

        .gender-radio {
            display: inline-block;
            margin-right: 10px;
        }
    </style>
</head>

<body>
<!-- Header Section -->
<header class="bg-primary text-white text-center py-3">
    <h1>Add Student</h1>
    <p class="lead">Enter the student's details below</p>
</header>

<!-- Main Content -->
<section class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <!-- Add Student Form -->
            <div class="card shadow">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Student Information</h4>
                    <form  method="POST" action="/student/addStudent"enctype="multipart/form-data">
                        <!-- Profile Icon (Bootstrap Icon) -->
                        <div class="mb-3 profile-container">
                            <label for="profilePhotoInput">
                                <!-- Bootstrap Icon for Profile -->
                                <i id="profileIcon" class="bi bi-person profile-icon"></i>
                            </label>
                            <input type="file" class="form-control" id="profilePhotoInput" name="profilePhoto" accept="image/*" onchange="toggleProfileIcon(event)" >
                            <!-- Profile Image Preview -->
                            <img id="profilePreview" src="" alt="Profile Photo Preview" class="profile-preview" style="display:none;">
                        </div>

                        <!-- Student Name -->
                        <div class="mb-3">
                            <label for="studentName" class="form-label">Student Name</label>
                            <input type="text" class="form-control" id="studentName" name="studentName" required placeholder="Enter full name">
                        </div>

                        <!-- Class -->
                        <div class="mb-3">
                            <label for="studentClass" class="form-label">Class</label>
                            <select class="form-select" id="studentClass" name="studentClass" required>
                                <option value="" selected disabled>Select class</option>
                                <% for (int i = 1; i <= 12; i++) { %>
                                <option value="<%= i %>">Class <%= i %></option>
                                <% } %>
                            </select>
                        </div>

                        <!-- Registration Number -->
                        <div class="mb-3">
                            <label for="regNo" class="form-label">Registration Number</label>
                            <input type="text" class="form-control" id="regNo" name="regNo" required placeholder="Enter registration number">
                        </div>

                        <!-- Date of Birth -->
                        <div class="mb-3">
                            <label for="dob" class="form-label">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob" required>
                        </div>

                        <!-- Gender -->
                        <div class="mb-3">
                            <label class="form-label">Gender</label><br>
                            <div class="gender-radio">
                                <input type="radio" id="male" name="gender" value="Male" required>
                                <label for="male" class="form-label">Male</label>
                            </div>
                            <div class="gender-radio">
                                <input type="radio" id="female" name="gender" value="Female" required>
                                <label for="female" class="form-label">Female</label>
                            </div>
                            <div class="gender-radio">
                                <input type="radio" id="other" name="gender" value="Other" required>
                                <label for="other" class="form-label">Other</label>
                            </div>
                        </div>

                        <!-- Form Buttons -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-secondary">Reset</button>
                        </div>
                    </form>
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
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script>
    function toggleProfileIcon(event) {
        var profileIcon = document.getElementById('profileIcon');
        var profilePreview = document.getElementById('profilePreview');
        var profilePhotoInput = document.getElementById('profilePhotoInput');

        // Hide the profile icon and show the image preview when a file is selected
        if (event.target.files && event.target.files[0]) {
            profileIcon.style.display = 'none'; // Hide the profile icon
            profilePreview.style.display = 'block'; // Show the image preview
            profilePreview.src = URL.createObjectURL(event.target.files[0]); // Set the preview image source
        } else {
            profileIcon.style.display = 'block'; // Show the profile icon if no file is selected
            profilePreview.style.display = 'none'; // Hide the preview if no file is selected
        }
    }
</script>
</body>

</html>
