/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drivesmart.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.drivesmart.bean.SessionBean;
import com.drivesmart.dao.SessionDao;

public class BookSessionServlet extends HttpServlet {
    private SessionDao dao = new SessionDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_name = request.getParameter("student_name");
        String branch_location = request.getParameter("branch_location");
        String lesson_type = request.getParameter("lesson_type");

        SessionBean session = new SessionBean();
        session.setStudent_name(student_name);
        session.setBranch_location(branch_location);
        session.setLesson_type(lesson_type);
        session.setStatus("Booked");

        dao.bookSession(session);

        response.sendRedirect("ScheduleServlet");
    }
}
