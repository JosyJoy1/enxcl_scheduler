<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Admin.css">
</head>
<body>
<form action="saveTopics" method="post" class="Wrapper">

<table>
<tr><td>Select Course :  <select name="course">
<option value="select">----select-----</option>
<option value="java">Java</option>
<option value="python">Python</option>
<option value="software testing">Software Testing</option>

</select></td></tr>
<tr><td>Topics:<input type="text" name="topic"></td></tr>
<tr><td>Duration:<input type="number" name="duration"><br></td></tr>
<tr><td><input class="btn" type="submit" value="Add to Curriculum"><br></td></tr>
</table>
</form>
<form >
<div class="data-card">
        <a href="viewcourseTopics.jsp">
            <h2>View Existing Topics</h2>
            
            </a>
        </div>

</form>
</body>
</html>