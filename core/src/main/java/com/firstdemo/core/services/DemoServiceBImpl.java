package com.firstdemo.core.services;

import com.day.cq.wcm.api.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component(service = DemoServiceB.class,immediate = true)
public class DemoServiceBImpl implements DemoServiceB {
    private static final Logger LOG= LoggerFactory.getLogger(DemoServiceBImpl.class);

    /*--------Start Tutorial #30--------*/
    @Reference(target = "(component.name=com.firstdemo.core.services.MultiServiceBImpl)")
    MultiService multiService;
    public String getNameWithReference(){
        return "Response coming from  "+ multiService.getName();
    }
    /*--------End Tutorial #30--------*/
    /*--------Start Tutorial #29--------*/
    @Reference
    DemoService demoService;
    @Override
    public List<String> getPages(){
        List<String> listPages = new ArrayList<String>();
        try {
            Iterator<Page> pages=demoService.getPages();
            while (pages.hasNext()) {
                listPages.add(pages.next().getTitle());
            }
            return listPages;
        } catch (Exception e) {
            LOG.info("\n  Exception {} ",e.getMessage());
        }
        return null;
    }
    /*--------End Tutorial #29--------*/
}
