<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ViewCourse" >
<label>Select the Course Name:</label>
<select name="course">
<option value="">-------Select--------</option>
<option value="java">Java</option>
<option value="python">Python</option>
<option value="Software Testing">Software Testing</option>

</select>
<br>
<input type="Submit" value="Submit">
<div class="data-card">
        <a href="Adminhome.jsp">
            <h4>Go Back</h4>
            
            </a>
        </div>
</body>
</html>