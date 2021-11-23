package com.lab2.entity.criteria;

public class Criteria {
    private final String searchCriteria;

    private final String searchType;

    private final Object value;

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public String getSearchType() {
        return searchType;
    }

    public Object getValue() {
        return value;
    }

    public Criteria(String searchCriteria, String searchType, Object value) {
        this.searchCriteria = searchCriteria;
        this.searchType = searchType;
        this.value = value;
    }
}
