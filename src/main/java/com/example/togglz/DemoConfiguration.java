package com.example.togglz;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.togglz.core.Feature;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Configuration
public class DemoConfiguration  {

//    public Class<? extends Feature> getFeatureClass() {
//        return MyFeatures.class;
//    }
//
//    public StateRepository getStateRepository() {
//        return new FileBasedStateRepository(new File("/tmp/features.properties"));
//    }
//@Bean
//    public UserProvider getUserProvider() {
//        return new ServletUserProvider("admin");
//    }

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(MyFeatures.class);
    }

    @Bean
    public UserProvider getUserProvider() {
        return () -> new SimpleFeatureUser("admin", true);
    }

}
