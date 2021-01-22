package com.github.ka1ka.util.docs.codegenerator.ios.builder;

import com.github.ka1ka.util.docs.codegenerator.model.FieldModel;
import com.github.ka1ka.util.docs.codegenerator.ICodeBuilder;

public class ModelFieldBuilder implements ICodeBuilder{

	private String modelFieldTemplate;
	private FieldModel entryFieldModel;
	
	public ModelFieldBuilder(String modelFieldTemplate, FieldModel entryFieldModel) {
		super();
		this.modelFieldTemplate = modelFieldTemplate;
		this.entryFieldModel = entryFieldModel;
	}

	@Override
	public String build(){
		modelFieldTemplate = modelFieldTemplate.replace("${FIELD_TYPE}",entryFieldModel.getIFieldType());
		modelFieldTemplate = modelFieldTemplate.replace("${FIELD_NAME}",entryFieldModel.getFieldName());
		modelFieldTemplate = modelFieldTemplate.replace("${COMMENT}", entryFieldModel.getComment());
		modelFieldTemplate = modelFieldTemplate.replace("${ASSIGN}", entryFieldModel.getAssign());
	    return modelFieldTemplate + "\n";
	}
}
