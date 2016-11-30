package com.epam.web.controller;

import com.epam.web.builder.AbstractTourBuilder;
import com.epam.web.entity.TourVoucher;
import com.epam.web.exception.TourBuilderFactoryException;
import com.epam.web.factory.TourBuilderFactory;

import java.util.Set;

public class Main {
//    public static void main(String[] args) {
//        TourBuilderFactory factory = new TourBuilderFactory();
//        Set<TourVoucher> result = null;
//
//        try {
//            AbstractTourBuilder builder = factory.createTourBuilder("STAX");
//            builder.buildSetTours("./data/voucher.xml", "./data/voucher.xsd");
//            result = builder.getTours();
//        } catch (TourBuilderFactoryException e) {
//            // logger.error(e);
//        }
//        result.forEach(System.out::println);
//
//    }
}
