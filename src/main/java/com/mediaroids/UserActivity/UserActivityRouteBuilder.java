package com.mediaroids.UserActivity;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;

/**
 * A Camel Java DSL Router
 */
public class UserActivityRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */


    public void configure() {



        restConfiguration()
                .host("localhost")
                .port(8888);

        rest("/userActivities")
            .produces("application/json")
            .get().to("direct:getUserActivities")
            // ?played=true&userId={userId}&contentType={contentType}&contentId={contentId} - example params
            .post().to("direct:createUserActivityData")
            .get("/{id}").to("direct:getUserActivity");


        from("direct:getUserActivities")
                .to("http://localhost:13761/api/userActivities/?bridgeEndpoint=true");


        from("direct:createUserActivityData")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Endpoint endpoint = getContext().getEndpoint("direct:createUserActivity");
                        PollingConsumer consumer = endpoint.createPollingConsumer();


                        consumer.start();

                        Exchange result = consumer.receive();

                        exchange.getIn().setBody(result.getIn().getBody());

                        consumer.stop();
                    }
                })
                .bean(UserActivityDAO.class, "insertUserActivity(${userId}, ${contentId}, ${contentType}, ${actionType})")
                .log("${body}")
                .choice()
                    .when(body().contains(true))
                        .to("seda:sonyActivity")
                    .otherwise()
                        .to("stream:out");

    }
}