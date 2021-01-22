package com.github.ka1ka.util.docs.doc;

import com.github.ka1ka.util.docs.parser.AbsControllerParser;
import com.github.ka1ka.util.docs.DocContext;
import com.github.ka1ka.util.docs.LogUtils;
import com.github.ka1ka.util.docs.Utils;
import com.github.ka1ka.util.docs.parser.ControllerNode;
import com.github.ka1ka.util.docs.parser.RequestNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsDocGenerator {

    private AbsControllerParser controllerParser;
    private IControllerDocBuilder controllerDocBuilder;
    private List<Link> docFileLinkList = new ArrayList<>();
    private List<ControllerNode> controllerNodeList = new ArrayList<>();

     AbsDocGenerator(AbsControllerParser controllerParser, IControllerDocBuilder controllerDocBuilder) {
        this.controllerParser = controllerParser;
        this.controllerDocBuilder = controllerDocBuilder;
        this.initControllerNodes();
    }

    /**
     * 生成api文档
     */
    public void generateDocs() {
        LogUtils.info("generate api docs start...");
        generateControllersDocs();
        generateIndex(controllerNodeList);
        LogUtils.info("generate api docs done !!!");
    }

    /**
     * 初始化控制器内容信息
     */
    private void initControllerNodes(){
        File[] controllerFiles = DocContext.getControllerFiles();
        for (File controllerFile : controllerFiles) {
            LogUtils.info("start to parse controller file : %s", controllerFile.getName());
            ControllerNode controllerNode = controllerParser.parse(controllerFile);
            if (controllerNode.getRequestNodes().isEmpty()) {
                continue;
            }
            //获取源文件信息
            controllerNode.setSrcFileName(controllerFile.getAbsolutePath());
            //目前文档文件信息
            final String docFileName = String.format("%s_%s.html", controllerNode.getPackageName().replace(".", "_"), controllerNode.getClassName());
            controllerNode.setDocFileName(docFileName);
            for (RequestNode requestNode : controllerNode.getRequestNodes()) {
                requestNode.setCodeFileUrl(String.format("%s#%s", docFileName, requestNode.getMethodName()));
            }

            controllerNodeList.add(controllerNode);
            LogUtils.info("success to parse controller file : %s", controllerFile.getName());
        }
    }

    /**
     * 生成控制器信息文档
     *
     * @return void
     **/
    private void generateControllersDocs() {
        File docPath = new File(DocContext.getDocPath());
        for (ControllerNode controllerNode : controllerNodeList) {
            try {
                LogUtils.info("start to generate docs for controller file : %s", controllerNode.getSrcFileName());
                final String controllerDocs = controllerDocBuilder.buildDoc(controllerNode);
                docFileLinkList.add(new Link(controllerNode.getDescription(), String.format("%s", controllerNode.getDocFileName())));
                Utils.writeToDisk(new File(docPath, controllerNode.getDocFileName()), controllerDocs);
                LogUtils.info("success to generate docs for controller file : %s", controllerNode.getSrcFileName());
            } catch (IOException e) {
                LogUtils.error("generate docs for controller file : " + controllerNode.getSrcFileName() + " fail", e);
            }
        }
    }

    public List<ControllerNode> getControllerNodeList() {
        return controllerNodeList;
    }

    abstract void generateIndex(List<ControllerNode> controllerNodeList);
}
