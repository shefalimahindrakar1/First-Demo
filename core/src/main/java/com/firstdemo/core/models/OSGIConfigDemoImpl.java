package com.firstdemo.core.models;

import com.firstdemo.core.services.OSGIFactoryConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGIConfigDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGIConfigDemoImpl implements OSGIConfigDemo{

//    @OSGiService
//    OSGIConfig oSGiConfig;


//    @Override
//    public String getServiceName() {
//        return oSGiConfig.getServiceName();
//    }
//
//    @Override
//    public int getServiceCount() {
//        return oSGiConfig.getServiceCount();
//    }
//
//    @Override
//    public boolean isLiveData() {
//        return oSGiConfig.isLiveData();
//    }
//
//    @Override
//    public String[] getCountries() {
//        return oSGiConfig.getCountries();
//    }
//
//    @Override
//    public String getRunModes() {
//        return oSGiConfig.getRunModes();
//    }

//    @OSGiService
//    OSGIConfigModule oSGiConfigModule;
//
//    @Override
//    public int getServiceId() {
//        return oSGiConfigModule.getServiceId();
//    }
//    @Override
//    public String getServiceNameModule() {
//        return oSGiConfigModule.getServiceName();
//    }
//    @Override
//    public String getServiceURL() {
//        return oSGiConfigModule.getServiceURL();
//    }
      @OSGiService
      OSGIFactoryConfig oSGiFactoryConfig;


      @Override
      public List<OSGIFactoryConfig> getAllOSGiConfigs() {
        return oSGiFactoryConfig.getAllConfigs();
     }
 }
