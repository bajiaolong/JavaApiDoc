<h2 id="${requestNode.methodName}" xmlns="http://www.w3.org/1999/html"><a
            href="#">${autoId} ${(requestNode.description)!''} <#if requestNode
        .deprecated><span
                class="badge">${i18n.getMessage('deprecated')}</span></#if></a></h2>
<#if requestNode.supplement??>
    <p class="text-muted">${requestNode.supplement}</p>
</#if>
<#if requestNode.author??>
    <p class="text-muted"><em>${i18n.getMessage('author')}: ${requestNode.author}</em></p>
</#if>

<#assign order = 1/>

<#--接口信息 start-->
<h4><p><strong>${autoId}.${order} ${i18n.getMessage('apiInfo')}</strong></p></h4>
<table class="table table-hover table-bordered">
    <tbody>
    <tr>
        <#--<th>${i18n.getMessage('apiInfoServiceName')}</th>-->
        <th>${i18n.getMessage('apiInfoUrl')}</th>
        <th>${i18n.getMessage('apiInfoRequestMode')}</th>
        <th>${i18n.getMessage('apiInfoRequestType')}</th>
    </tr>

    <tr>
        <#--<td></td>-->
        <td><code>${requestNode.url}</code></td>
        <td>
            <#list requestNode.method as method>
                <span class="label label-default">${method}</span>
            </#list>
            <#if requestNode.changeFlag == 1>
                <span class="label label-success">${i18n.getMessage('new')}</span>
            <#elseif requestNode.changeFlag == 2>
                <span class="label label-warning">${i18n.getMessage('modify')}</span>
            </#if>
        </td>
        <#-- <td>${requestNode.paramNodes.get(0).description}</td>-->
        <td>
            <#if requestNode.paramNodes?size != 0>
                <#assign requestJsonBody = ''/>
                <#list requestNode.paramNodes as paramNode>
                    <#if paramNode.jsonBody>
                        <#assign requestJsonBody = paramNode.description/>
                    </#if>
                </#list>
                <#if requestJsonBody != ''>
                    <p><span class="badge">application/json</span></p>
                </#if>

                <#if requestJsonBody == '' || (requestJsonBody != '' && requestNode.paramNodes?size gt 1)>
                    <p><span class="badge">application/x-www-form-urlencoded</span>
                    </p></#if>
            </#if>

        </td>
    </tr>

    </tbody>
</table>
<#--接口信息 end-->

<#--
<p><strong>${i18n.getMessage('requestUrl')}</strong></p>

<p>
    <code>${requestNode.url}</code>
    <#list requestNode.method as method>
        <span class="label label-default">${method}</span>
    </#list>
    <#if requestNode.changeFlag == 1>
        <span class="label label-success">${i18n.getMessage('new')}</span>
    <#elseif requestNode.changeFlag == 2>
        <span class="label label-warning">${i18n.getMessage('modify')}</span>
    </#if>
</p>-->
<#assign order = order+1/>
<#--请求参数start-->
<h4><p><strong>${autoId}.${order} ${i18n.getMessage('requestParameters')}</strong></p></h4>
<#if requestNode.paramNodes?size != 0>

    <table class="table table-hover table-bordered">
        <tbody>
        <tr>
            <th>${i18n.getMessage('parameterName')}</th>
            <th>${i18n.getMessage('parameterType')}</th>
            <th>${i18n.getMessage('parameterNeed')}</th>
            <th>${i18n.getMessage('description')}</th>
        </tr>
        <#list requestNode.paramNodes as paramNode>

        <#--判断是否为对象-->
            <#if paramNode.type=='_object'>
                <#list paramNode.paramNodeList as paramNodeList>
                    <tr>
                        <td>${paramNodeList.name}</td>
                        <td>${paramNodeList.type}</td>
                        <td>${paramNodeList.required?string(i18n.getMessage('yes'),i18n.getMessage('no'))}</td>
                        <td>${(paramNodeList.description)!''}</td>
                    </tr>
                </#list>
            <#else >
                <tr>
                    <td>${paramNode.name}</td>
                    <td>${paramNode.type}</td>
                    <td>${paramNode.required?string(i18n.getMessage('yes'),i18n.getMessage('no'))}</td>
                    <td>${(paramNode.description)!''}</td>
                </tr>
            </#if>
        <#--<#if paramNode.jsonBody>
            <#assign requestJsonBody = paramNode.description/>
        </#if>
        <#if requestJsonBody == '' || (requestJsonBody != '' && requestNode.paramNodes?size gt 1)>
            <#list requestNode.paramNodes as paramNode>
                <#if !(paramNode.jsonBody)>
                    <tr>
                        <td>${paramNode.name}</td>
                        <td>${paramNode.type}</td>
                        <td>${paramNode.required?string(i18n.getMessage('yes'),i18n.getMessage('no'))}</td>
                        <td>${(paramNode.description)!''}</td>
                    </tr>
                </#if>
            </#list>

        </#if>-->
        </#list>
        <#--<#if requestJsonBody != ''>
            <p><strong>${i18n.getMessage('requestBody')}</strong> <span class="badge">application/json</span></p>
            <pre class="prettyprint lang-json">${requestJsonBody}</pre>
        </#if>-->
        </tbody>
    </table>
</#if>
<#--请求参数 end-->

<#--请求体start-->
<#if requestNode.paramNodes?size != 0>
    <#list requestNode.paramNodes as paramNode>
        <#if paramNode.type=='_object'>
            <#assign order = order+1/>
            <h4><p><strong>${autoId}.${order} ${i18n.getMessage('requestBody')}</strong></p></h4>
            <p><strong>${i18n.getMessage('requestBody')}</strong> <span class="badge">application/json</span></p>
            <pre class="prettyprint lang-json">${paramNode.description}</pre>
        </#if>

    </#list>

</#if>
<#--请求体end-->

<#assign order = order+1/>
<#--响应参数 start-->
<h4><p><strong>${autoId}.${order} ${i18n.getMessage('responseParameters')}</strong></p></h4>
<#if requestNode.responseNode??>
    <table class="table table-hover table-bordered">
        <tbody>
        <tr>
            <th>${i18n.getMessage('parameterName')}</th>
            <th>${i18n.getMessage('parameterType')}</th>
            <th>${i18n.getMessage('description')}</th>
        </tr>

        <#--<#list requestNode.responseNode.childNodes as childNodesResponseNode>
            <#if childNodesResponseNode.childNode??>
                <#list childNodesResponseNode.childNode.childNodes as objectChildNodesResponseNode>
                    <tr>
                        <td>${childNodesResponseNode.name}.${objectChildNodesResponseNode.name}</td>
                        <td>${objectChildNodesResponseNode.type}</td>
                        <td>${(objectChildNodesResponseNode.description)}</td>
                    </tr>
                </#list>
            <#else >
                <tr>
                    <td>${childNodesResponseNode.name}</td>
                    <td>${childNodesResponseNode.type}</td>
                    <td>${(childNodesResponseNode.description)}</td>
                </tr>
            </#if>
        </#list>-->

        <#list requestNode.responseNode.childNodes as childNodesResponseNode>
            <#if childNodesResponseNode.childNode??>
                <#assign parentName =childNodesResponseNode.name/>
                <#list childNodesResponseNode.childNode.childNodes as objectChildNodesResponseNode>
                    <#assign newObjectChildNodesResponseNode = objectChildNodesResponseNode>
                    <#include "api-response-chird-node.html.ftl"/>
                </#list>
            <#else >
                <tr>
                    <td>${childNodesResponseNode.name}</td>
                    <td>${childNodesResponseNode.type}</td>
                    <td>${(childNodesResponseNode.description)}</td>
                </tr>
            </#if>
        </#list>

        </tbody>
    </table>
</#if>
<#--响应参数 end-->


<#assign order = order+1/>
<#--响应结果示例 start-->
<h4><p><strong>${autoId}.${order} ${i18n.getMessage('responseResult')}</strong></p></h4>
<#if requestNode.responseNode??>
    <pre class="prettyprint lang-json">${requestNode.responseNode.toJsonApi()}</pre>
    <#if requestNode.androidCodePath??>
        <div class="form-group">
            <a type="button" class="btn btn-sm btn-default" href="${requestNode.androidCodePath}"><i
                        class="fa fa-android" aria-hidden="true"></i> Android Model</a>
            <a type="button" class="btn btn-sm btn-default" href="${requestNode.iosCodePath}"><i class="fa fa-apple"
                                                                                                 aria-hidden="true"></i>
                iOS Model</a>
        </div>
    </#if>
</#if>
<#--响应结果示例 end-->
