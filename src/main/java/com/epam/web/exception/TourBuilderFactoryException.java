package com.epam.web.exception;

import com.epam.web.factory.TourBuilderFactory;

public class TourBuilderFactoryException extends Exception{
    public TourBuilderFactoryException() {
        super();
    }

    public TourBuilderFactoryException(String message) {
        super(message);
    }

    public TourBuilderFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourBuilderFactoryException(Throwable cause) {
        super(cause);
    }
}
