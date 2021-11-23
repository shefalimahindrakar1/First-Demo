package com.firstdemo.core.services;

import com.firstdemo.core.config.DemoOSGIConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OSGIConfigModule.class,immediate = true)
@Designate(ocd = DemoOSGIConfig.class)
public class OSGIConfigModuleImpl implements OSGIConfigModule{

    private int serviceId;
    private String serviceName;
    private String serviceURL;

    @Activate
    protected void activate(DemoOSGIConfig demoOSGiConfig){
        serviceId=demoOSGiConfig.serviceID();
        serviceName=demoOSGiConfig.serviceName();
        serviceURL=demoOSGiConfig.serviceURL();
    }
    @Override
    public int getServiceId() {
        return serviceId;
    }
    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public String getServiceURL() {
        return serviceURL;
    }
}
