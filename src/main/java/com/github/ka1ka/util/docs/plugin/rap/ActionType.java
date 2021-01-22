package com.github.ka1ka.util.docs.plugin.rap;

/**
 * @author yeguozhong util.github.com
 */
enum  ActionType {

    GET("1"),
    POST("2"),
    PUT("3"),
    DELETE("4");

    public final String type;

    ActionType(String type) {
        this.type = type;
    }
}
