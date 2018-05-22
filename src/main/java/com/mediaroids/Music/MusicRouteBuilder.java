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

        /**
         * Endpoints:
         * @GET {/music/all} - sends all music in the DB to `getSongs` Queue
         * @GET {/music/id} -  sends a single movie and its data to `getMusic` Queue
         * @POST {/music/add} - receives a list of music from Sony, add the list to `addSong` Queue
         */
        rest("/music")
                .produces("application/json")

                .get("/all").to("direct:getSongs")

                .get("/{id}").to("direct:getMusic")

                .post("/add").to("direct:addSong");


        /**
         * @queue {getSongs}
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


        /**
         * @queue {addSong} - sends Song to Music Microservice
         */
        from("direct:addSong")
                .to("http://localhost:8080/songs/add?bridgeEndpoint=true&urlRewrite=#urlRewrite");


    }
}