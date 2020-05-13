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

}
