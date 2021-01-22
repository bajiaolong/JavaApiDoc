package com.github.ka1ka.util.docs;

import com.github.ka1ka.util.docs.parser.ControllerNode;

import java.util.List;

/**
 * an plugin interface, please feel free to  to do what ever you want.
 *
 * @author yeguozhong util.github.com
 */
public interface IPluginSupport {

     /**
      * a hook method
      *
      * @param controllerNodeList all the api data
      */
     void execute(List<ControllerNode> controllerNodeList);
}
