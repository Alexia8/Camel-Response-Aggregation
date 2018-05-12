package com.mediaroids;

import com.mediaroids.Movies.MovieRouteBuilder;
import com.mediaroids.Music.MusicRouteBuilder;
import com.mediaroids.Shared.CustomUrlRewrite;
import com.mediaroids.TvShows.TvShowRouteBuilder;
import com.mediaroids.User.UserRouteBuilder;
import com.mediaroids.UserActivity.UserActivityRouteBuilder;
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
        // For URLS to work properly we need to reWrite them /object instead of
        // /object/object if we dont have this
        main.bind("urlRewrite", new CustomUrlRewrite());

        // Add our routes to the main application
        MovieRouteBuilder movieRouteBuilder = new MovieRouteBuilder();
        main.addRouteBuilder(movieRouteBuilder);

        TvShowRouteBuilder tvShowRouteBuilder = new TvShowRouteBuilder();
        main.addRouteBuilder(tvShowRouteBuilder);

        MusicRouteBuilder musicRouteBuilder = new MusicRouteBuilder();
        main.addRouteBuilder(musicRouteBuilder);

        UserRouteBuilder userRouteBuilder = new UserRouteBuilder();
        main.addRouteBuilder(userRouteBuilder);

        UserActivityRouteBuilder userActivityRouteBuilder = new UserActivityRouteBuilder();
        main.addRouteBuilder(userActivityRouteBuilder);


        main.run(args);
    }

}

