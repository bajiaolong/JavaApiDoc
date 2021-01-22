package com.github.ka1ka.util.docs.doc;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.github.ka1ka.util.docs.DocContext;
import com.github.ka1ka.util.docs.Resources;
import com.github.ka1ka.util.docs.Utils;
import com.github.ka1ka.util.docs.codegenerator.ios.ModelCodeGenerator;
import com.github.ka1ka.util.docs.codegenerator.java.JavaCodeGenerator;
import com.github.ka1ka.util.docs.parser.ControllerNode;
import com.github.ka1ka.util.docs.parser.RequestNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过一个控制器生成一个文档文件信息
 *
 * @author yeguozhong util.github.com
 */
public class HtmlControllerDocBuilder implements IControllerDocBuilder {

    /**
     *
     * @param controllerNode
     * @return java.lang.String
     **/
    @Override
    public String buildDoc(ControllerNode controllerNode) throws IOException {

        for (RequestNode requestNode : controllerNode.getRequestNodes()) {
            if (requestNode.getResponseNode() != null && !requestNode.getResponseNode().getChildNodes().isEmpty()) {
                JavaCodeGenerator javaCodeGenerator = new JavaCodeGenerator(requestNode.getResponseNode());
                final String javaSrcUrl = javaCodeGenerator.generateCode();
                requestNode.setAndroidCodePath(javaSrcUrl);
                ModelCodeGenerator iosCodeGenerator = new ModelCodeGenerator(requestNode.getResponseNode());
                final String iosSrcUrl = iosCodeGenerator.generateCode();
                requestNode.setIosCodePath(iosSrcUrl);
            }
        }

        final Template ctrlTemplate = getControllerTpl();
        final File docFile = new File(DocContext.getDocPath(), controllerNode.getDocFileName());
        FileWriter docFileWriter = new FileWriter(docFile);
        Map<String, Object> data = new HashMap<>();
        data.put("controllerNodeList", DocContext.getControllerNodeList());
        data.put("controller", controllerNode);
        data.put("currentApiVersion", DocContext.getCurrentApiVersion());
        data.put("apiVersionList", DocContext.getApiVersionList());
        data.put("projectName", DocContext.getDocsConfig().getProjectName());
        data.put("i18n", DocContext.getI18n());

        try {
            ctrlTemplate.process(data, docFileWriter);
        } catch (TemplateException ex) {
            ex.printStackTrace();
        } finally {
            Utils.closeSilently(docFileWriter);
        }
        return Utils.streamToString(new FileInputStream(docFile));
    }

    private Template getControllerTpl() throws IOException {
        return Resources.getFreemarkerTemplate("api-controller.html.ftl");
    }

}
