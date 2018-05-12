package com.mediaroids.ContentProviders.Sony;

import com.mediaroids.Movies.MovieAggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.util.Map;

/**
 * A Camel Java DSL Router
 */
public class SonyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */


    public void configure() {

        String WSDL = "http://localhost:9000/SonyService?wsdl";
        String address = "http://localhost:9000/SonyService";

        from("direct:start")
            .to("soap:sonyWebservice?wsdlUrl=" + WSDL +"&serviceAddress=" + address + "&operationName=sendMovies")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    Map body = (Map)exchange.getIn().getBody();
                    System.out.println("Body: " + body);
                }
            });
    }
}