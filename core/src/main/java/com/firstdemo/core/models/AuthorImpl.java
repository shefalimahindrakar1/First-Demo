package com.firstdemo.core.models;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class,
adapters = Author.class,
        resourceType = AuthorImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson",extensions = "json",selector = "first",
options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE",value = "true"),
        @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY",value = "true")
})
@JsonRootName("author-details")
public class AuthorImpl implements Author {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);
    static final String RESOURCE_TYPE="firstdemo/components/content/author";

    @OSGiService
    QueryBuilder queryBuilder;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ResourcePath(path ="/content/firstdemo/us/en/hellopage")@Via("resource")
    Resource resource;

    @ScriptVariable
    Page currentPage;

    @Inject
    @Via("resource")
    @Default(values = "Shefali")
    String fname;

    @ValueMapValue
    @Default(values = "Mahindrakar")
    String lname;

    @Inject
    @Via("resource")
    boolean professor;

    @ValueMapValue
    private List<String> books;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @JsonIgnore
    @Override
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getHomePageName() {
        return resource.getName();
    }

    @JsonProperty(value = "author-name")
    public String authorName(){
        return "FIRST DEMO";
    }

    @JsonProperty(value = "book-details")
    @Override
    public List<String> getBooks() {
        if (books != null) {
            return new ArrayList<String>(books);
            } else {
                return Collections.emptyList();
            }
        }

    @Override
    public List<Map<String,String>> getBookDetailsWithMap() {
        List<Map<String,String>> bookDetailsMap=new ArrayList<>();
        try {
            Resource bookDetail=resource.getChild("bookdetailswithmap");
            if(bookDetail!=null){
                for (Resource book : bookDetail.getChildren()) {
                    Map<String,String> bookMap=new HashMap<>();
                    bookMap.put("bookname",book.getValueMap().get("bookname",String.class));
                    bookMap.put("booksubject",book.getValueMap().get("booksubject",String.class));
                    bookMap.put("publishyear",book.getValueMap().get("publishyear",String.class));
                    bookDetailsMap.add(bookMap);
                }
            }
        }catch(Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        return bookDetailsMap;
    }

    @Override
    public Map<String, String> getBooksMap() {
        Map<String,String> mapBooks=new HashMap<>();
        mapBooks.put("attribute1","Value1");
        mapBooks.put("attribute2","Value2");
        mapBooks.put("attribute3","Value3");
        mapBooks.put("attribute4","Value4");
        mapBooks.put("attribute5","Value5");
        return mapBooks;
    }


//    @PostConstruct
//    protected void init(){
//        LOG.info("\n Inside INIT {} : {} ",currentPage.getTitle(),resource.getPath());
//    }

}
