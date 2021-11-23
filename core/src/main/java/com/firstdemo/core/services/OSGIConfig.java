package com.firstdemo.core.services;

public interface OSGIConfig {
   public String getServiceName();
   public int getServiceCount();
   public boolean isLiveData();
   public String[] getCountries() ;
   public String getRunModes();
}
