package com.ravuthz.springboot.configure;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/17, 1:09 AM
 * Email : ravuthz@gmail.com
 */

public enum Routes {

    APP(""),
    API("/api"),

    ROLES("/roles"),
    ROLE_ID("/roles/{id}"),

    PRODUCTS("/products"),
    PRODUCT_ID("/product/{id}"),

    CUSTOMERS("/customers"),
    CUSTOMER_ID("/customers/{id}"),

    CATEGORIES("/categories"),
    CATEGORY_ID("/categories/{id}");

    private String text;

    Routes(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // TODO: Declares all prefix routes here !!!

}
