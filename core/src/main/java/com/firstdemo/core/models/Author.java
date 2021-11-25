package com.firstdemo.core.models;
import java.util.List;
import java.util.Map;

public interface Author {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
    String getPageTitle();
    String getRequestAttribute();
    String getHomePageName();
    List<String> getBooks();
    List<Map<String,String>> getBookDetailsWithMap();
    public Map<String,String> getBooksMap();
}
