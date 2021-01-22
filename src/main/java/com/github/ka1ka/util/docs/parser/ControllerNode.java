package com.github.ka1ka.util.docs.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * a controller node corresponds to a controller file
 *
 * @author yeguozhong util.github.com
 */
public class ControllerNode {
    /**
     * 作者信息
     */
    private String author;
    /**
     * 描述
     */
    private String description;
    /**
     * 基础url
     */
    private String baseUrl;
    /**
     * 类名称
     */
    private String className;
    /**
     * 包名称
     */
    private String packageName;
    /**
     * 生成文档
     */
    private Boolean generateDocs = Boolean.FALSE;
    /**
     * 请求信息
     */
    private List<RequestNode> requestNodes = new ArrayList<>();
    /**
     * 源文件
     */
    private String srcFileName;
    /**
     * 文档文件
     */
    private String docFileName;

    public String getPackageName() {
        return packageName;
    }

    public String getSrcFileName() {
        return srcFileName;
    }

    public void setSrcFileName(String srcFileName) {
        this.srcFileName = srcFileName;
    }

    public Boolean getGenerateDocs() {
        return generateDocs;
    }

    public void setGenerateDocs(Boolean generateDocs) {
        this.generateDocs = generateDocs;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseUrl() {
        return baseUrl == null ? "" : baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<RequestNode> getRequestNodes() {
        return requestNodes;
    }

    public void setRequestNodes(List<RequestNode> requestNodes) {
        this.requestNodes = requestNodes;
    }

    public void addRequestNode(RequestNode requestNode){
        requestNodes.add(requestNode);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
