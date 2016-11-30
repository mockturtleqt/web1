package com.epam.web.parser;

import com.epam.web.builder.AbstractTourBuilder;
import com.epam.web.entity.TourVoucher;
import com.epam.web.exception.TourBuilderFactoryException;
import com.epam.web.factory.TourBuilderFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class);
    private static final String TOUR_XML = "./data/voucher.xml";
    private static final String TOUR_XSD = "./data/voucher.xsd";

    public static Set<TourVoucher> parse(HttpServletRequest request, String parserType) {
        TourBuilderFactory factory = new TourBuilderFactory();
        Set<TourVoucher> result = null;
        String rootPath = request.getServletContext().getRealPath("");

        try {
            AbstractTourBuilder builder = factory.createTourBuilder(parserType);
            builder.buildSetTours(rootPath + TOUR_XML, rootPath + TOUR_XSD);
            result = builder.getTours();
        } catch (TourBuilderFactoryException e) {
            logger.error(e);
        }

        return result;
    }

}
