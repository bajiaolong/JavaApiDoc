package com.github.ka1ka.util.docs.codegenerator;

import com.github.ka1ka.util.docs.Resources;
import com.github.ka1ka.util.docs.Utils;

import java.io.IOException;


public class TemplateProvider {
	public static String provideTemplateForName(String templateName) throws IOException {
		return Utils.streamToString(Resources.getCodeTemplateFile(templateName));
    }
}
