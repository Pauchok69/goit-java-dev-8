package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    public static final String DEFAULT_TIME_ZONE = "UTC";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh-mm-ss VV";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(DEFAULT_TIME_ZONE));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(now.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        resp.getWriter().close();
    }
}
