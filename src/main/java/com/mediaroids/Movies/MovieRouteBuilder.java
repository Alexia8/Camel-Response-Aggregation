package com.mediaroids.Movies;

import org.apache.camel.builder.RouteBuilder;

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

            .get().to("direct:getMovies")

            .get("/{id}").to("direct:getMovie");


        /**
         * @return List<Movie> - list of all movies
         */
        from("direct:getMovies")
                .to("http://localhost:13761/api/movies/?bridgeEndpoint=true");


        // FROM 'getMovie' --> getMovieData (Content Layer) + --> 'getMovieRecommendation' (API Recommendation Queue)
//        from("direct:getMovie")
//            .multicast(new MovieAggregationStrategy())
//            .parallelProcessing().enrich("direct:getMovieData").enrich("direct:getMovieRecommendation").end();
//            //.to("direct:getMovieRecommendation", "direct:getMovieData").end().to("direct:movieData");


        /**
         * @returns {Movie}
         */
        from("direct:getMovieData")
            .setBody(simple("\"{\"title\":\"Happy Gilmore\"}\"")) // Swap for Real URL (like below)
            .multicast(new MovieAggregationStrategy())
            .parallelProcessing().enrich("direct:getMovieRecommendation").enrich("direct:movieDetailsResult");
                //.toD("http4://localhost:13761/api/movies/${header.id}?bridgeEndpoint=true&urlRewrite=#urlRewrite");


        /**
         * @returns [Movies] - recommendation list
         */
        from("direct:getMovieRecommendation")
//            .to("http://localhost:5000/api/movieRecommendation?title=${movie.title}&description=${movie.description}")
           .setBody(simple("{\"recommendation\":\"You should also watch my movie.\"}"));


    }
}