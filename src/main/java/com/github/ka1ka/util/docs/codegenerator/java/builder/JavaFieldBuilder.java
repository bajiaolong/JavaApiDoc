package com.github.ka1ka.util.docs.codegenerator.java.builder;


import com.github.ka1ka.util.docs.codegenerator.model.FieldModel;
import com.github.ka1ka.util.docs.codegenerator.ICodeBuilder;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JavaFieldBuilder implements ICodeBuilder {

    private String fieldTemplate;
    private FieldModel entryFieldModel;

    public JavaFieldBuilder(String fieldTemplate, FieldModel entryFieldModel) {
        this.fieldTemplate = fieldTemplate;
        this.entryFieldModel = entryFieldModel;
    }

    @Override
    public String build() {
        fieldTemplate = fieldTemplate.replace("${FIELD_TYPE}",entryFieldModel.getFieldType());
        fieldTemplate = fieldTemplate.replace("${FIELD_NAME}",entryFieldModel.getFieldName());
        fieldTemplate = fieldTemplate.replace("${COMMENT}",entryFieldModel.getComment());
        return fieldTemplate + "\n";
    }
}
