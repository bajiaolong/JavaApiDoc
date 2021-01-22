package com.github.ka1ka.util.docs.codegenerator.java.builder;


import com.github.ka1ka.util.docs.codegenerator.model.FieldModel;
import com.github.ka1ka.util.docs.codegenerator.ICodeBuilder;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JavaGetterBuilder implements ICodeBuilder {

    private String getterTemplate;
    private FieldModel entryFieldModel;

    public JavaGetterBuilder(String getterTemplate, FieldModel entryFieldModel) {
        this.getterTemplate = getterTemplate;
        this.entryFieldModel = entryFieldModel;
    }

    @Override
    public String build() {
        getterTemplate = getterTemplate.replace("${CASE_FIELD_NAME}",entryFieldModel.getCaseFieldName());
        getterTemplate = getterTemplate.replace("${FIELD_NAME}",entryFieldModel.getFieldName());
        getterTemplate = getterTemplate.replace("${FIELD_TYPE}",entryFieldModel.getFieldType());
        getterTemplate = getterTemplate.replace("${REMOTE_FIELD_NAME}",entryFieldModel.getRemoteFieldName());
        return getterTemplate + "\n";
    }

}
