package com.example.TvShows;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class TvShowRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    protected JndiRegistry createRegistry() throws Exception {
        JndiRegistry jndi = new JndiRegistry();
        jndi.bind("urlRewrite", new TvShowsUrlRewrite());
        return jndi;
    }

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


        from("direct:getTvShow")
                .multicast(new TvShowAggregationStrategy())
                .parallelProcessing().enrich("direct:getTvShowData").enrich("direct:getTvShowRecommendation").end();

                //.to("direct:getTvShowRecommendation", "direct:getTvShowData").end().to("direct:movieData");


        from("direct:getTvShowData")
                .setBody(simple("\"{\"title\":\"Happy Gilmore\"}\""));
//                .toD("http4://localhost:13761/api/tvShows/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

        from("direct:getTvShowRecommendation")
                .setBody(simple("{\"recommendation\":\"You should also watch my movie.\"}"));
    }
}