package com.mediaroids.ContentProviders.Sony;

import SonyClient.proxy.SonyService;
import SonyClient.proxy.SonyServiceService;
import SonyClient.proxy.UserActivity;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import javax.xml.soap.*;

/**
 * A Camel Java DSL Router
 */
public class SonyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */

    private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost:9000/SonyService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("SonyService", serverURI);

        javax.xml.soap.SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("sendUserActivity", "SonyService");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "sendUserActivity");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    public void configure() {

        SonyService service = new SonyServiceService().getSonyServicePort();

        restConfiguration()
            .host("localhost")
            .port(8888);

        rest("/contentProviders")
            .produces("application/json")
            .get().to("direct:getFromSony")
            .get("/{id}").to("direct:getFromSony");


        from("direct:sonyActivity")
                .bean(SonyServiceService.class, "sendUserActivity(${body.userId}, ${body.contentId}, ${body.contentType}, ${body.actionType})");

    }
}