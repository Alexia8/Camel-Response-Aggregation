package com.mediaroids.ContentProviders.Sony;

import SonyClient.proxy.SonyService;
import SonyClient.proxy.SonyServiceService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class SonyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    public void configure() {

  //      SonyService service = new SonyServiceService().getSonyServicePort();

        restConfiguration()
            .host("localhost")
            .port(8888);

        rest("/contentProviders")
            .produces("application/json")
            .get().to("direct:getFromSony")
            .get("/{id}").to("direct:getFromSony");


        from("seda:sonyActivity")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    // TODO: Wait till we have defined data.
                }
            })
                .to("stream:out");
//            .to(service.sendUserActivity(body()));

    }
}