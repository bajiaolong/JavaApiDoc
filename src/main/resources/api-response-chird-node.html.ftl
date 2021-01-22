<#if newObjectChildNodesResponseNode.childNode??>
    <#assign parentName =newObjectChildNodesResponseNode.name/>
    <#list newObjectChildNodesResponseNode.childNode.childNodes as newObjectChildNodesResponseNode2>
        <#assign newObjectChildNodesResponseNode =newObjectChildNodesResponseNode2/>
        <#include "api-response-chird-node.html.ftl"/>
    </#list>
<#else >
    <tr>
        <td>${parentName}.${newObjectChildNodesResponseNode.name}</td>
        <td>${newObjectChildNodesResponseNode.type}</td>
        <td>${(newObjectChildNodesResponseNode.description)}</td>
    </tr>
</#if>
