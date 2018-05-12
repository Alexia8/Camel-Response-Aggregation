package com.example;

import com.example.Movies.MovieRouteBuilder;
import com.example.Movies.MoviesUrlRewrite;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        MovieRouteBuilder builder = new MovieRouteBuilder();
        main.bind("urlRewrite", new MoviesUrlRewrite());
        main.addRouteBuilder(builder);
        main.run(args);
    }

}

