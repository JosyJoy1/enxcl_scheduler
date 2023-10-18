<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Scheduler Result</title>
</head>
<body>
    <h1>Course Scheduler Result:</h1>
    <p>Course Name: <%= request.getAttribute("courseName") %></p>
    <p>Start Date: <%= request.getAttribute("startDate") %></p>
    <p>End Date: <%= request.getAttribute("endDate") %></p>
    <div class="-card">
        <a href="SchedulerHome.jsp">
            <h4>back</h4>
            
            </a>
        </div>
</body>

</html>