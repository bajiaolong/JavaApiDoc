package com.github.ka1ka.util.docs.parser;

import com.alibaba.fastjson.JSONObject;
import com.github.ka1ka.util.docs.Utils;

/**
 * response node
 *
 * @author yeguozhong util.github.com
 */
public class ResponseNode extends ClassNode {

    private RequestNode requestNode;

    private String stringResult;

    public RequestNode getRequestNode() {
        return requestNode;
    }

    public void setRequestNode(RequestNode requestNode) {
        this.requestNode = requestNode;
    }

    public String getStringResult() {
        return stringResult;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

    @Override
    public String toJsonApi() {
        if(stringResult != null){
            try{
                return Utils.toPrettyJson((JSONObject.parse(stringResult)));
            }catch (Exception ex){
                // do nothing
                return stringResult;
            }
        }
        return super.toJsonApi();
    }
}
