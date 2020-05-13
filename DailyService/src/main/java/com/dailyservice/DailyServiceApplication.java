package com.dailyservice;

import com.dailyservice.resources.DeliveryOrderResource;
import com.dailyservice.resources.DummyResource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The java class declares root resource and provider classes.
 *
 * @author Priya Raut
 * @version 1.0
 */
@ApplicationPath("/") //Defines the base URI for all resource URIs.
public class DailyServiceApplication extends Application{

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet hashSet = new HashSet<Class<?>>();
        hashSet.add( DummyResource.class );
        return hashSet;
    }
}
