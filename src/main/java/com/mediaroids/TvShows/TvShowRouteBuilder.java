package com.mediaroids.TvShows;

import com.mediaroids.Shared.CustomUrlRewrite;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

import java.net.ConnectException;
import java.sql.SQLOutput;

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


        rest("/shows")
                .produces("application/json")
                // Get from Content Layer
                .get("/all").to("direct:getTvShows")
                // Get specific movie from Content Layer
                .get("/{id}").to("direct:getTvShow")
                // Add new show to Content Layer
                .post("/add").to("direct:addShow");

        from("direct:getTvShows")
                .doTry()
                    .to("http://localhost:8080/shows/all?bridgeEndpoint=true&urlRewrire=#urlRewrite")
                .doCatch(Exception.class)
                    .setBody(simple("[{\"title\":\"Error.\", \"description\":\"An error occurred.\"}]"));
        ;

        from("direct:getTvShow")
           .doTry()
                .toD("http://localhost:8080/shows/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite")
           .doCatch(Exception.class)
                .setBody(simple("{\"title\":\"Error.\", \"description\":\"An error occurred.\"}"));

        from("direct:addShow")
                .to("http://localhost:8080/shows/add?bridgeEndpoint=true&urlRewrite=#urlRewrite");


        from("direct:transformMovie")
                .to("jolt:file:data/joltProcessors/ContentAppToNetflixShowProcessor.json");


    }
}