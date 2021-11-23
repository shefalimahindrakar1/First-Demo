package com.firstdemo.core.models;

import com.day.cq.wcm.api.Page;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public interface AuthorBooks {
    String getAuthorName();
    List<String> getAuthorBooks();
    List<Map<String,String>> getBookDetailsWithMap();
    List<MultifieldHelper> getBookDetailsWithBean();
    List<MultifieldHelper> getBookDetailsWithNastedMultifield();
    public Calendar getPublishDate();
    public List<Page> getPageInfo();
    public Iterator<Page> getPageIterator();

}
