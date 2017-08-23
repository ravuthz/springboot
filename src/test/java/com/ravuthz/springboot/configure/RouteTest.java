package com.ravuthz.springboot.configure;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/2017, 11:53 AM
 * Email : ravuthz@gmail.com
 */

public class RouteTest {
    @Test
    public void routeEnum() {
        Route api = Route.API;
        System.out.println(api.getText());

        Route[] routes = Route.values();
        System.out.println("Route values: ");
        for (Route route : routes) {
            System.out.println(route + " => " + route.getText() + " >> " + route.valueOf(route.toString()) + " << " + route.name() + " [ " + route.ordinal() + " ] ");

        }
    }

    @Test
    public void getText() throws Exception {
        System.out.println(Route.CATEGORIES.getText());
    }

}