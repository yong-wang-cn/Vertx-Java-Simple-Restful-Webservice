package com.uga;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.*;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Yong on 11/26/19.
 */
public class MainVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        HttpServerOptions httpOpts = new HttpServerOptions();
        Router router = Router.router(vertx);
        HttpServer server = vertx.createHttpServer(httpOpts);
        server.requestHandler(router).listen(8080);

        router.route(HttpMethod.GET, "/*").handler(StaticHandler.create("webroot").setCachingEnabled(true));

        router.route(HttpMethod.POST, "/uga").handler(routingContext -> {

            HttpServerRequest request = routingContext.request();
            String emails = request.getParam("emails");

            int total = 0;

            if (emails != null && !emails.isEmpty()) {
                total = Arrays.stream(emails.split(","))
                        .map(s -> s.toLowerCase())
                        .filter(s -> s.endsWith("@gmail.com"))
                        .map(s -> s.substring(0,s.length()-10))
                        .map((s -> {
                            int index = s.indexOf("+");
                            if (index != -1) s = s.substring(0,index);
                            return s;
                        }))
                        .map(s -> s.replaceAll("[.]",""))
                        .collect(Collectors.toSet())
                        .size();
            }

            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("" + total);});
    }

}
