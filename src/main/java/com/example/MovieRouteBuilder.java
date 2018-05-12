package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * A Camel Java DSL Router
 */
public class MovieRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    protected JndiRegistry createRegistry() throws Exception {
        JndiRegistry jndi = new JndiRegistry();
        jndi.bind("urlRewrite", new MoviesUrlRewrite());
        return jndi;
    }

    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/movies")
                .produces("application/json")

                .get().to("direct:getMovies")

                .get("/{id}").to("direct:getMovie");


        from("direct:getMovies")
                .to("http://localhost:13761/api/movies/?bridgeEndpoint=true");


        from("direct:getMovie")
                .multicast(new MovieAggregationStrategy())
                .parallelProcessing().enrich("direct:getMovieData").enrich("direct:getMovieRecommendation").end();

                //.to("direct:getMovieRecommendation", "direct:getMovieData").end().to("direct:movieData");


        from("direct:getMovieData")
                .toD("http4://localhost:13761/api/movies/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

        from("direct:getMovieRecommendation")
                .setBody(simple("{\"recommendation\":\"You should also watch my movie.\"}"));
    }
}