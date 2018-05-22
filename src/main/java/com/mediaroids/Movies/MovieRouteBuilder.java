package com.mediaroids.Movies;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * A Camel Java DSL Router
 */
public class MovieRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */


    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        // Rest API
        rest("/movies")
                .produces("application/json")

                .get("/all").to("direct:getMovies")

                .get("/{id}").to("direct:getMovieData")

                .post("/add").to("direct:addMovie");



        /**
         * @return List<Movie> - list of all movies
         */
        from("direct:getMovies")
                .doTry()
                .to("http://localhost:13761/api/movies/?bridgeEndpoint=true")
                .doCatch(Exception.class)
                .setBody(simple("[{\"title\":\"Error.\", \"description\":\"An error occurred.\"}]"));

        /**
         * @returns {Movie}
         */

        from("direct:getMovieData")
                .doTry()
                .multicast(new MovieAggregationStrategy()).parallelProcessing().enrich("direct:getMovie").enrich("direct:getMovieRecommendation")
                .endDoTry()
                .doCatch(Exception.class)
                .setBody(simple("{\"title\":\"Error.\", \"description\":\"Could not fetch the movie.\"}"));


        from("direct:getMovie")
                .toD("http://localhost:8080/movies/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

        /**
         * @returns [Movies] - recommendation list
         */

        from("direct:getMovieRecommendation")
                .doTry()
                .toD("http://localhost:8080/movies/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite")
                .unmarshal().json(JsonLibrary.Jackson, Movie.class)
                .setHeader("movie", simple("${body.title}"))
                .setBody(constant(null))
                .toD("http://127.0.0.1:5000/get_recommendation?movie=${header.movie}&bridgeEndpoint=true&urlRewrite=#urlRewrite")
                .choice()
                    .when(body().isNotEqualTo(""))
                      .toD("http://localhost:8080/movies/get/${body}?bridgeEndpoint=true&urlRewrite=#urlRewrite")
                .endDoTry()
                .doCatch(Exception.class)
                    .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
                            exception.printStackTrace();
                        }
                    })
                    .setBody(simple("[{\"title\":\"Error.\", \"description\":\"Could not fetch the recommendations\"}]"));


        from("direct:addMovie")
                .doTry()
                .to("http://localhost:8080/movies/add?bridgeEndpoint=true&urlRewrite=#urlRewrite")
                .doCatch(Exception.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);

                        exception.printStackTrace();

                    }
                })
                .setBody(simple("[{\"title\":\"Error.\", \"description\":\"Could not add the movie.\"}]"));


    }
}