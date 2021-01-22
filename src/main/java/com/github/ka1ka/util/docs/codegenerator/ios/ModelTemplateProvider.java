package com.github.ka1ka.util.docs.codegenerator.ios;

import com.github.ka1ka.util.docs.codegenerator.TemplateProvider;

import java.io.IOException;


public class ModelTemplateProvider {
	
	public String provideTemplateForName(String templateName) throws IOException {
		return TemplateProvider.provideTemplateForName(templateName);
    }

}
