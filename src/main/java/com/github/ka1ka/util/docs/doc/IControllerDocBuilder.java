package com.github.ka1ka.util.docs.doc;

import com.github.ka1ka.util.docs.parser.ControllerNode;

import java.io.IOException;

/**
 * an interface of build a controller api docs
 *
 * @author yeguozhong util.github.com
 */
public interface IControllerDocBuilder {

    /**
     * build api docs and return as string
     *
     * @param controllerNode
     * @return
     */
    String buildDoc(ControllerNode controllerNode) throws IOException;

}
