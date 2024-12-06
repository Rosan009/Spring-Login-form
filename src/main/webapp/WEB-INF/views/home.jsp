<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Class Management</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        /* Ensure the footer stays at the bottom */
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        main {
            flex: 1; /* Pushes the footer to the bottom if content is small */
        }
        footer {
            background-color: #343a40; /* Dark background for footer */
            color: white;
            padding: 20px 0;
        }
    </style>
</head>
<body>
<!-- Header Section -->
<header class="bg-primary text-white text-center py-4">
    <h1>Class Management System</h1>
    <p>Manage your classes and students efficiently</p>
</header>

<!-- Main Content Section -->
<main class="container mt-5">
    <div class="row justify-content-center">
        <!-- View Class Card -->
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <i class="bi bi-eye display-4 text-primary mb-3"></i>
                    <h5 class="card-title">View Class</h5>
                    <p class="card-text">See all the details of your classes in one place.</p>
                    <a href="class/viewclass" class="btn btn-primary">
                        <i class="bi bi-eye"></i> View Class
                    </a>
                </div>
            </div>
        </div>

        <!-- Add Student Card -->
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <i class="bi bi-person-plus display-4 text-success mb-3"></i>
                    <h5 class="card-title">Add Student</h5>
                    <p class="card-text">Easily add a new student to your class list.</p>
                    <a href="student/addStudent" class="btn btn-success">
                        <i class="bi bi-person-plus"></i> Add Student
                    </a>
                </div>
            </div>
        </div>
    </div>
</main>

<!-- Enhanced Footer Section -->
<footer class="text-center">
    <div class="container">
        <div class="row">
            <!-- Branding -->
            <div class="col-md-4 mb-3">
                <h5>Class Management System</h5>
                <p>Streamline your class and student management efficiently with our system.</p>
            </div>

            <!-- Navigation Links -->
            <div class="col-md-4 mb-3">
                <h5>Quick Links</h5>
                <ul class="list-unstyled">
                    <li><a href="/viewClass" class="text-white text-decoration-none">View Class</a></li>
                    <li><a href="/addStudent" class="text-white text-decoration-none">Add Student</a></li>
                    <li><a href="/contact" class="text-white text-decoration-none">Contact Us</a></li>
                    <li><a href="/about" class="text-white text-decoration-none">About</a></li>
                </ul>
            </div>

            <!-- Social Media Links -->
            <div class="col-md-4 mb-3">
                <h5>Follow Us</h5>
                <div class="d-flex justify-content-center">
                    <a href="https://facebook.com" class="text-white me-3">
                        <i class="bi bi-facebook" style="font-size: 1.5rem;"></i>
                    </a>
                    <a href="https://twitter.com" class="text-white me-3">
                        <i class="bi bi-twitter" style="font-size: 1.5rem;"></i>
                    </a>
                    <a href="https://linkedin.com" class="text-white me-3">
                        <i class="bi bi-linkedin" style="font-size: 1.5rem;"></i>
                    </a>
                    <a href="https://instagram.com" class="text-white">
                        <i class="bi bi-instagram" style="font-size: 1.5rem;"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="text-center mt-3">
            <p class="mb-0">&copy; 2024 Class Management System. All rights reserved.</p>
        </div>
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
