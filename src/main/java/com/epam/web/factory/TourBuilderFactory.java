package com.epam.web.factory;

import com.epam.web.builder.AbstractTourBuilder;
import com.epam.web.builder.TourDomBuilder;
import com.epam.web.builder.TourSaxBuilder;
import com.epam.web.builder.TourStaxBuilder;
import com.epam.web.exception.TourBuilderFactoryException;

public class TourBuilderFactory {
    private enum ParserType {
        SAX, STAX, DOM
    }

    public AbstractTourBuilder createTourBuilder(String parserType) throws TourBuilderFactoryException {
        if (parserType == null) {
            throw new TourBuilderFactoryException("Invalid parser type.");
        }

        ParserType type;

        try {
            type = ParserType.valueOf(parserType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TourBuilderFactoryException("Invalid parser type. ");
        }

        switch (type) {
            case DOM:
                return new TourDomBuilder();
            case SAX:
                return new TourSaxBuilder();
            case STAX:
                return new TourStaxBuilder();
            default:
                throw new TourBuilderFactoryException("Invalid builder type.");
        }
    }
}
