/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drivesmart.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import com.drivesmart.bean.SessionBean;
import com.drivesmart.dao.SessionDao;

/**
 *
 * @author MP2-4
 */
public class ScheduleServlet extends HttpServlet{
    private SessionDao dao = new SessionDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List<SessionBean> list = dao.getAllSessions();
        request.setAttribute("sessionList", list);
        RequestDispatcher rd = request.getRequestDispatcher("schedule.jsp");
        rd.forward(request, response);
        
    }
    
}
