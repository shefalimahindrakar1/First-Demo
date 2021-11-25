package com.firstdemo.core.services;

import com.firstdemo.core.config.DemoOSGIFactoryConfig;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Component (service = OSGIFactoryConfig.class,configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate (ocd = DemoOSGIFactoryConfig.class, factory = true)
public class OSGIFactoryConfigImpl implements OSGIFactoryConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(OSGIFactoryConfigImpl.class);

    private int configID;
    private String serviceName;
    private String serviceURL;
    private List<OSGIFactoryConfig> configsList;

    @Activate
    @Modified
    protected void activate(final DemoOSGIFactoryConfig config) {
        configID = config.configID();
        serviceName=config.serviceName();
        serviceURL=config.serviceURL();
    }

    @Reference(service = OSGIFactoryConfig.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    public void bindOSGiFactoryConfig(final OSGIFactoryConfig config) {
        if (configsList == null){
            configsList = new ArrayList<>();
        }
        configsList.add(config);

    }

    public void unbindOSGiFactoryConfig(final OSGIFactoryConfig config) {
        configsList.remove(config);
    }

    @Override
    public int getConfigID() {
        return configID;
    }
    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public String getServiceURL() {
        return serviceURL;
    }


    @Override
    public List<OSGIFactoryConfig> getAllConfigs(){
        return configsList;
    }

    @Override
    public OSGIFactoryConfig get(int configID) {
        for (OSGIFactoryConfig confFact : configsList) {
            if (configID==confFact.getConfigID())
                return confFact;
        }
        return null;
    }
}
