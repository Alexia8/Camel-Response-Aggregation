package com.mediaroids.UserActivity;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class UserActivityRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */


    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/userActivities")
                .produces("application/json")

                .get().to("direct:getUserActivities")

                .get("/{id}").to("direct:getUserActivity");


        from("direct:getUserActivities")
                .to("http://localhost:13761/api/userActivities/?bridgeEndpoint=true");

        

        from("direct:getUserActivityData")
                .setBody(simple("{\"title\":\"The Big Bang Theory\"}"));
//                .toD("http4://localhost:13761/api/userActivities/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");
        
    }
}