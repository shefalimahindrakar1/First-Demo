package com.firstdemo.core.models;

import com.day.cq.wcm.api.Page;
import com.firstdemo.core.services.DemoService;
import com.firstdemo.core.services.DemoServiceB;
import com.firstdemo.core.services.MultiService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ServiceDemoImpl implements ServiceDemo {
    private static final Logger LOG= LoggerFactory.getLogger(ServiceDemoImpl.class);

    @OSGiService
    DemoService demoService;

    @OSGiService
    DemoServiceB demoServiceB;

    @OSGiService(filter = "(component.name=serviceA)")
    MultiService multiService;

    @OSGiService(filter = "(component.name=com.firstdemo.core.services.MultiServiceBImpl)")
    MultiService multiServiceB;

    @Override
    public Iterator<Page> getPagesList() {
        return demoService.getPages();
    }

    @Override
    public List<String> getPageTitleList() {
        return demoServiceB.getPages();
    }

    @Override
    public String getNameFromService() {
        return multiService.getName();
    }
    @Override
    public String getNameFromServiceB() {
        return multiServiceB.getName();
    }
    @Override
    public String getNameWithReference() {
        return demoServiceB.getNameWithReference();
    }
    /*--------End Tutorial #30--------*/
//    @PostConstruct
//    protected void init(){
//        LOG.trace("\n=========PRINTING LOGS FROM TRACE================");
//        LOG.debug("\n===========PRINTING LOGS FROM DEBUG=================");
//        LOG.info("\n================PRINTING LOGS FROM INFO===============");
//        LOG.warn("\n===========PRINTING LOGS FROM WARN=================");
//        LOG.error("\n==========PRINTING LOGS FROM ERROR=================");
//
//    }
}
