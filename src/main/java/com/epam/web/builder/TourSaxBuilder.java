package com.epam.web.builder;

import com.epam.web.handler.TourHandler;
import com.epam.web.validation.Validation;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class TourSaxBuilder extends AbstractTourBuilder {
    private static final Logger logger = Logger.getLogger(TourSaxBuilder.class);
    private TourHandler th;
    private XMLReader reader;

    public TourSaxBuilder() {
        th = new TourHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(th);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    public void buildSetTours(String xml, String xsd) {
        if (!Validation.validateXMLSchema(xsd, xml)) {
            return;
        }
        try {
            reader.parse(xml);
        } catch (SAXException | IOException e) {
            logger.error(e);
        }
        tours = th.getTours();
    }
}
