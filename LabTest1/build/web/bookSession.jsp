<%-- 
    Document   : bookSession
    Created on : 16 Jun 2026, 3:12:10 PM
    Author     : MP2-4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Session</title>
    </head>
    <body>
        <h1>Book a driving lesson</h1>
        
        <form method="POST" action="BookSessionServlet">
          
            Student Name: <input type="text" name="student_name" required><br>
            Branch Location: <input type="text" name="branch_location" required><br>
            
            Lesson type:
            <select name="lesson_type">
                <option>Motorcycle</option>
                <option>Manual Car</option>
                <option>Automatic Car</option>
            </select><br>
            
            <input type="submit" value="Book Session">
                    
                    
        </form>
    </body>
</html>
