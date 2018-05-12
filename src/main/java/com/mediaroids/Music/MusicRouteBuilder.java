package com.mediaroids.Music;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class MusicRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    protected JndiRegistry createRegistry() throws Exception {
        JndiRegistry jndi = new JndiRegistry();
        jndi.bind("urlRewrite", new MusicUrlRewrite());
        return jndi;
    }

    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/musics")
                .produces("application/json")

                .get().to("direct:getMusics")

                .get("/{id}").to("direct:getMusic");


        from("direct:getMusics")
                .to("http://localhost:13761/api/musics/?bridgeEndpoint=true");


        from("direct:getMusic")
                .multicast(new MusicAggregationStrategy())
                .parallelProcessing().enrich("direct:getMusicData").enrich("direct:getMusicRecommendation").end();

                //.to("direct:getMusicRecommendation", "direct:getMusicData").end().to("direct:musicData");


        from("direct:getMusicData")
                .setBody(simple("\"{\"title\":\"Back in Black\"}\""));
//                .toD("http4://localhost:13761/api/musics/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");

        from("direct:getMusicRecommendation")
                .setBody(simple("{\"recommendation\":\"You should also watch my music.\"}"));
    }
}