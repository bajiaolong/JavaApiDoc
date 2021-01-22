package com.github.ka1ka.util.docs.codegenerator.ios.builder;

import com.github.ka1ka.util.docs.codegenerator.ICodeBuilder;

public class ModelBuilder implements ICodeBuilder{
	
	private String modelTemplate;
	private String objectName;
	private String properties;
	

	public ModelBuilder(String modelTemplate, String objectName, String properties) {
		super();
		this.modelTemplate = modelTemplate;
		this.objectName = objectName;
		this.properties = properties;
	}

	@Override
	public String build(){
		modelTemplate = modelTemplate.replace("${CLASS_NAME}",objectName);
		modelTemplate = modelTemplate.replace("${FIELDS}",properties);
		return modelTemplate;
	}
}
