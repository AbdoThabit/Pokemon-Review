package com.pokemonreview.api.Exceptions;

public class ReviewNotFoundException extends RuntimeException {
    // private static final long serialVerisionUID = 2;
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
