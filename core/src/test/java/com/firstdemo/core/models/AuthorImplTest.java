package com.firstdemo.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class AuthorImplTest {

    private final AemContext aemContext = new AemContext();
    Author author;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(AuthorImpl.class);
        aemContext.load().json("/com.firstdemo.core.models/Author.json","/component");
        aemContext.load().json("/com.firstdemo.core.models/Page.json","/page");
        aemContext.load().json("/com.firstdemo.core.models/Resource.json","/resource");
    }

    @Test
    void getFirstName() {
        aemContext.currentResource("/component/author");
        author = aemContext.request().adaptTo(Author.class);
        final String expected ="TOM";
        String actual = author.getFirstName();
        assertEquals(expected,actual);
    }

    @Test
    void getLastName() {
        aemContext.currentResource("/component/author");
        author = aemContext.request().adaptTo(Author.class);
        final String expected ="Harry";
        String actual = author.getLastName();
        assertEquals(expected,actual);
    }

    @Test
    void getIsProfessor() {
        aemContext.currentResource("/component/author");
        author = aemContext.request().adaptTo(Author.class);
        assertEquals(true,author.getIsProfessor());
    }

    @Test
    void getPageTitle() {
        aemContext.currentResource("/page/currentPage");
        author = aemContext.request().adaptTo(Author.class);
        assertEquals("hellopage",author.getPageTitle());
    }

    @Test
    void getRequestAttribute() {
//        aemContext.request().setAttribute("rAttribute","TestAttribute");
//        author=aemContext.request().adaptTo(Author.class);
//        assertEquals("TestAttribute","author.getRequestAttribute()");
    }

    @Test
    void getHomePageName() {
        Resource resource=aemContext.currentResource("/resource/resourcePage");
        AuthorImpl authorImpl=aemContext.registerService(new AuthorImpl());
        authorImpl.resource = resource;
        assertEquals("resourcePage",authorImpl.getHomePageName());
    }

    @Test
    void authorName() {

    }

    @Test
    void getBooks() {
        aemContext.currentResource("/component/author");
        author = aemContext.request().adaptTo(Author.class);
        assertEquals(3,author.getBooks().size());
        assertEquals("Java book",author.getBooks().get(0));

    }

    @Test
    void getBookDetailsWithMap() {
    }
}
// Adding comment