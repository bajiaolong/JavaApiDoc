package com.github.ka1ka.util.docs.codegenerator;

import com.github.ka1ka.util.docs.codegenerator.model.FieldModel;
import com.github.ka1ka.util.docs.parser.ClassNode;

import java.util.List;

public interface IFieldProvider {
	/**
	 * get response fields
	 * @param respNode
	 * @return
	 */
	List<FieldModel> provideFields(ClassNode respNode);
}
