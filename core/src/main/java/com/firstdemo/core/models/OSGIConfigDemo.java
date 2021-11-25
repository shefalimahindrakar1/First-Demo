package com.firstdemo.core.models;

import com.firstdemo.core.services.OSGIFactoryConfig;
import java.util.List;

public interface OSGIConfigDemo {
//    public String getServiceName();
//    public int getServiceCount();
//    public boolean isLiveData();
//    public String[] getCountries() ;
//    public String getRunModes();

//    public int getServiceId();
//    public String getServiceNameModule() ;
//    public String getServiceURL() ;

    public List<OSGIFactoryConfig> getAllOSGiConfigs();
}
