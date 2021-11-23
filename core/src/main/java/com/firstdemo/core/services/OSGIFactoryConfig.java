package com.firstdemo.core.services;

import java.util.List;

public interface OSGIFactoryConfig {
    public int getConfigID();
    public String getServiceName();
    public String getServiceURL();
    public OSGIFactoryConfig get(int configID);
    public List<OSGIFactoryConfig> getAllConfigs();
}
