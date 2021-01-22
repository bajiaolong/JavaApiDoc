package com.github.ka1ka.util.docs;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author yeguozhong util.github.com
 */
public class I18n {

    private ResourceBundle resourceBundle;

    public I18n() {
        this.resourceBundle =  ResourceBundle.getBundle("message", Locale.getDefault());
    }

    public I18n(Locale locale){
        this.resourceBundle =  ResourceBundle.getBundle("message", locale);
    }

    public String getMessage(String name){
        return resourceBundle.getString(name);
    }
}
