package com.epam.web.builder;

import com.epam.web.entity.TourVoucher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractTourBuilder {
    protected Set<TourVoucher> tours;

    public AbstractTourBuilder() {
        tours = new HashSet<>();
    }

    public Set<TourVoucher> getTours() {
        return tours;
    }

    public List<String> getToursString() {
        return tours
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public abstract void buildSetTours(String xml, String xsd);
}
