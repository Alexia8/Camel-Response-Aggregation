package com.mediaroids;

import com.mediaroids.Movies.MovieRouteBuilder;
import com.mediaroids.Movies.MoviesUrlRewrite;
import com.mediaroids.Music.MusicRouteBuilder;
import com.mediaroids.TvShows.TvShowRouteBuilder;
import com.mediaroids.TvShows.TvShowsUrlRewrite;
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

        // Add our routes to the main application
        MovieRouteBuilder movieRouteBuilder = new MovieRouteBuilder();
        main.bind("urlRewrite", new MoviesUrlRewrite());
        main.addRouteBuilder(movieRouteBuilder);

        TvShowRouteBuilder tvShowRouteBuilder = new TvShowRouteBuilder();
        main.bind("urlRewrite", new TvShowsUrlRewrite());
        main.addRouteBuilder(tvShowRouteBuilder);

        MusicRouteBuilder musicRouteBuilder = new MusicRouteBuilder();
        main.bind("urlRewrite", new MoviesUrlRewrite());
        main.addRouteBuilder(musicRouteBuilder);


        main.run(args);
    }

}

