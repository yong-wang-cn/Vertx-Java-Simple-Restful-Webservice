package com.uga;

/**
 * Created by Yong on 11/26/19.
 */

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class UniqueGmailAddress {
    public static void main(String[] args) {
        VertxOptions options = new VertxOptions();
        Vertx vertx = Vertx.factory.vertx(options);
        vertx.deployVerticle("com.uga.MainVerticle", new DeploymentOptions().setInstances(1));
    }
}
