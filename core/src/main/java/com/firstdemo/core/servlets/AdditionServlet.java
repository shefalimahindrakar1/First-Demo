package com.firstdemo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/additionServlet")
public class AdditionServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        int int1 = Integer.parseInt(request.getParameter("first"));
        int int2 = Integer.parseInt(request.getParameter("second"));
        int num3=int1+int2;
        response.getWriter().print(num3);
    }
}
//comment needed
