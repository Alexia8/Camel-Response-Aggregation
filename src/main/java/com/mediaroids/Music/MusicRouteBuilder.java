package com.mediaroids.Music;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MusicRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    public void configure() {

        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/music")
                .produces("application/json")

                .get("/all").to("direct:getSongs")

                .get("/{id}").to("direct:getMusic")

                .post("/add").to("direct:addSong");


        /**
         * @returns List<Music> items
         */
        from("direct:getSongs")
                .doTry()
                    .to("http://localhost:8080/music/?bridgeEndpoint=true&urlRewrire=#urlRewruite")
                .doCatch(Exception.class)
                    .setBody(simple("[{\"title\":\"Error.\", \"description\":\"Could not fetch any song.\"}]"));

        /**
         * @param id - for music item
         * @returns Music object
         */
        from("direct:getMusic")
                .doTry()
                    .toD("http4://localhost:8080/music/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite")
                .doCatch(Exception.class)
                    .setBody(simple("{\"title\":\"Error.\", \"description\":\"Could not fetch the song.\"}"));


        from("direct:addSong")
                .to("http://localhost:8080/songs/add?bridgeEndpoint=true&urlRewrite=#urlRewrite");


    }
}