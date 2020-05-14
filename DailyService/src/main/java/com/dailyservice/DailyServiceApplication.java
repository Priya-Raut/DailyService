package com.dailyservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class provides base application path for all the resources.
 *
 * @author Priya Raut
 * @version 1.0
 */
@ApplicationPath("/") //Defines the base URI for all resource URIs.
public class DailyServiceApplication extends Application{

}
