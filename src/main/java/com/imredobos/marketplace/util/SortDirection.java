package com.imredobos.marketplace.util;

import com.imredobos.marketplace.service.exception.InvalidSortDirectionException;

public enum SortDirection {
    ASCENDING("asc"),
    DESCENDING("desc");

    private String text;

    SortDirection(String text) {
        this.text = text;
    }

    public static SortDirection getDirection(String direction) {
        if (ASCENDING.text.equals(direction)) {
            return ASCENDING;
        } else if (DESCENDING.text.equals(direction)) {
            return DESCENDING;
        } else {
            throw new InvalidSortDirectionException(direction);
        }
    }
}
