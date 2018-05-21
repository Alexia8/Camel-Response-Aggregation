package com.mediaroids.Movies;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MovieAggregationStrategy implements AggregationStrategy {


    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(oldExchange == null) {
            return newExchange;
        }

        if(newExchange.getIn().getBody(String.class).isEmpty())
            return oldExchange;


        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);

       String resultBody = "{" + oldBody + "," + newBody + "}";
       newExchange.getIn().setBody(resultBody);

       return newExchange;
    }

}
