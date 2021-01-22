package com.github.ka1ka.util.docs.parser;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.ka1ka.util.docs.Utils;

import java.util.Arrays;

/**
 *
 * use for JFinal
 *
 * @author yeguozhong util.github.com
 */
public class JFinalControllerParser extends AbsControllerParser{

    @Override
    protected void afterHandleMethod(RequestNode requestNode, MethodDeclaration md) {
        String methodName = md.getNameAsString();
        requestNode.setUrl(getUrl(methodName));
        md.getAnnotationByName("ActionKey").ifPresent(an -> {
            if(an instanceof SingleMemberAnnotationExpr){
                String url = ((SingleMemberAnnotationExpr)an).getMemberValue().toString();
                requestNode.setMethod(Arrays.asList(RequestMethod.GET.name(), RequestMethod.POST.name()));
                requestNode.setUrl(Utils.removeQuotations(url));
                return;
            }
        });
    }

    private String getUrl(String methodName){
        JFinalRoutesParser.RouteNode routeNode = JFinalRoutesParser.INSTANCE.getRouteNode(getControllerFile().getAbsolutePath());
        return routeNode == null ? "" :routeNode.basicUrl +"/"+ methodName;
    }
}
