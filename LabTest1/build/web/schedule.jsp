<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.drivesmart.bean.SessionBean" %>
<html>
<head><title>Schedule Dashboard</title></head>
<body>
<h2>Centralized Training Schedule</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Student</th><th>Branch</th><th>Lesson Type</th><th>Status</th>
    </tr>
    <%
        List<SessionBean> list = (List<SessionBean>) request.getAttribute("sessionList");
        for(SessionBean s : list) {
    %>
    <tr>
        <td><%= s.getSession_id() %></td>
        <td><%= s.getStudent_name() %></td>
        <td><%= s.getBranch_location() %></td>
        <td><%= s.getLesson_type() %></td>
        <td><%= s.getStatus() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>