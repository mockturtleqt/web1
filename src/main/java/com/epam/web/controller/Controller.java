package com.epam.web.controller;

import com.epam.web.builder.AbstractTourBuilder;
import com.epam.web.entity.TourVoucher;
import com.epam.web.exception.TourBuilderFactoryException;
import com.epam.web.factory.TourBuilderFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parser = request.getParameter("XMLParser");

        TourBuilderFactory factory = new TourBuilderFactory();
        Set<TourVoucher> result = null;

        try {
            AbstractTourBuilder builder = factory.createTourBuilder(parser);
            builder.buildSetTours("./data/voucher.xml", "./data/voucher.xsd");
            result = builder.getTours();
        } catch (TourBuilderFactoryException e) {
           // logger.error(e);
        }
        String tour = null;
        for (TourVoucher voucher : result) {
            tour += voucher;
        }
        request.setAttribute("parser", tour);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);

        /*GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String timeJSP = request.getParameter("time");
        String name = request.getParameter("name");
        request.setAttribute("outputName", name);
        float delta = ((float) (gregorianCalendar.getTimeInMillis() - Long.parseLong(timeJSP))) / 1000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);*/
    }
}
