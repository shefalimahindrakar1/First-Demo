package com.firstdemo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import javax.xml.bind.annotation.*;
import java.util.*;
@Exporter(name = "firstdemoxml",extensions = "xml")
@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = XmlExporter.class,
        resourceType = ExmExporterImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@XmlRootElement(name = "firstdemo-exporter")
public class ExmExporterImpl implements XmlExporter {
    static final String RESOURCE_TYPE = "firstdemo/components/content/xmlexporter";
    private static final Logger LOG = LoggerFactory.getLogger(ExmExporterImpl.class);

    @Inject
    Resource componentResource;

    @ValueMapValue
    String xmltitle;

    @ValueMapValue
    String xmldescription;

    @ValueMapValue
    Calendar xmldate;

    @ValueMapValue
    private List<String> books;

    List<Map<String, String>> bookDetailsMap;

    @Override
    @XmlElement(name = "author-title")
    public String getTitle() {
        return xmltitle;
    }

    @Override
    @XmlElement(name = "author-description")
    public String getDescription() {
        return xmldescription;
    }

    @Override
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public List<String> getBooks() {
        if (books != null) {
            return new ArrayList<String>(books);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    @XmlElement(name = "publish-date")
    public Calendar getDate() {
        return xmldate;
    }

    @XmlElement(name = "author-name")
    public String getAuthorName() {
        return "FIRST DEMO";
    }
}
