package com.github.ka1ka.util.docs.codegenerator.java;

import com.github.ka1ka.util.docs.codegenerator.TemplateProvider;

import java.io.IOException;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JavaTemplateProvider {

    public String provideTemplateForName(String templateName) throws IOException {
    	return TemplateProvider.provideTemplateForName(templateName);
    }
    
}
