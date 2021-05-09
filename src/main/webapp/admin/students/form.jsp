<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Win10Pro
  Date: 4/23/2021
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        student = new Student("", "", "");
    }
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <style>
        .error-msg {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="">
        <form action="/admin/students/create" method="post">
            <div class="form-group">
                <label>Roll Number</label>
                <input type="text" class="form-control" name="rollNumber" placeholder="RollNumber"
                       value="<%=student.getRollNumber() %>">
                <span class="error-msg">
                    <%
                        if (errors.containsKey("rollNumber")) {
                            ArrayList<String> fullNameErrors = errors.get("rollNumber");
                            for (String msg : fullNameErrors) {
                    %>
                    <li><%=msg%></li>
                    <%
                            }
                        }%>
                </span>
            </div>
            <div class="form-group">
                <label>FullName</label>
                <input type="text" class="form-control" name="fullName" placeholder="FullName"
                       value="<%=student.getFullName() %>">
                <span class="error-msg">
                    <%
                        if (errors.containsKey("fullName")) {
                            ArrayList<String> fullNameErrors = errors.get("fullName");
                            for (String msg : fullNameErrors) {
                    %>
                    <li><%=msg%></li>
                    <%
                            }
                        }%>
                </span>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                       aria-describedby="emailHelp" placeholder="Enter email" value="<%=student.getEmail() %>">
                <span class="error-msg">
                    <%
                        if (errors.containsKey("email")) {
                            ArrayList<String> fullNameErrors = errors.get("email");
                            for (String msg : fullNameErrors) {
                    %>
                    <li><%=msg%></li>
                    <%
                            }
                        }%>
                </span>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
