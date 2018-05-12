package com.mediaroids.User;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class UserRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    protected JndiRegistry createRegistry() throws Exception {
        JndiRegistry jndi = new JndiRegistry();
        jndi.bind("urlRewrite", new UserUrlRewrite());
        return jndi;
    }

    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/users")
                .produces("application/json")

                .get().to("direct:getUsers")

                .get("/{id}").to("direct:getUser");


        from("direct:getUsers")
                .to("http://localhost:13761/api/users/?bridgeEndpoint=true");


        from("direct:getUser")
                .multicast(new UserAggregationStrategy())
                .parallelProcessing().enrich("direct:getUserData").enrich("direct:getUserRecommendation").end();

                //.to("direct:getUserRecommendation", "direct:getUserData").end().to("direct:userData");


        from("direct:getUserData")
                .setBody(simple("\"{\"name\":\"Stormy Daniels\"}\""));
//                .toD("http4://localhost:13761/api/users/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

    }
}