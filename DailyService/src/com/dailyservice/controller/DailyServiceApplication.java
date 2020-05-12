package com.dailyservice.controller;

import com.dailyservice.resources.DummyResource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class DailyServiceApplication extends Application{

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet hashSet = new HashSet<Class<?>>();
        hashSet.add( DummyResource.class );
        return hashSet;
    }
}
