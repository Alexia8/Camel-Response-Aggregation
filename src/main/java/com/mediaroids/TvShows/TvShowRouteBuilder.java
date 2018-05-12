package com.mediaroids.TvShows;

import com.mediaroids.Shared.CustomUrlRewrite;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class TvShowRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/tvShows")
                .produces("application/json")

                .get().to("direct:getTvShows")

                .get("/{id}").to("direct:getTvShow");


        from("direct:getTvShows")
                .to("http://localhost:13761/api/tvShows/?bridgeEndpoint=true");


        from("direct:getTvShowData")
                .setBody(simple("{\"title\":\"The Big Bang Theory\"}"));
//                .toD("http4://localhost:13761/api/tvShows/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

    }
}