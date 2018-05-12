package com.mediaroids.ContentProviders.Sony;

import SonyClient.proxy.SonyService;
import SonyClient.proxy.SonyServiceService;
import com.mediaroids.Movies.MovieAggregationStrategy;
import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class SonyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */


    public void configure() {

        SonyService service = new SonyServiceService().getSonyServicePort();
        System.out.println(service.sendMovies("MediaRoids"));

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/contentProviders")
                .produces("application/json")

                .get().to("direct:getFromSony")

                .get("/{id}").to("direct:getFromSony");


        from("direct:getFromSony")
                .setBody(simple(service.sendMovies("Mediaroids").toString()));

//simple("{\"recommendation\":\"You should also watch my movie.\"}")

    }
}