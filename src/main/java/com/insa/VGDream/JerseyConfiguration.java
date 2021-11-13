package com.insa.VGDream;

import com.insa.VGDream.joueurs.JoueurResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("VGDream")
@Configuration
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration(){
        register(JoueurResource.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
