package com.mediaroids.ContentProviders.Sony;

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

    }

//        restConfiguration()
//                .host("localhost")
//                .port(8888);
//
//        rest("/movies")
//                .produces("application/json")
//
//                .get().to("direct:getMovies")
//
//                .get("/{id}").to("direct:getMovie");
//
//
//        from("direct:getMovies")
//                .to("http://localhost:13761/api/movies/?bridgeEndpoint=true");
//
//
//        from("direct:getMovie")
//                .multicast(new MovieAggregationStrategy())
//                .parallelProcessing().enrich("direct:getMovieData").enrich("direct:getMovieRecommendation").end();
//
//                //.to("direct:getMovieRecommendation", "direct:getMovieData").end().to("direct:movieData");
//
//
//        from("direct:getMovieData")
//                .setBody(simple("\"{\"title\":\"Happy Gilmore\"}\""));
////                .toD("http4://localhost:13761/api/movies/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");
//
//        from("direct:getMovieRecommendation")
//                .setBody(simple("{\"recommendation\":\"You should also watch my movie.\"}"));
//    }
}