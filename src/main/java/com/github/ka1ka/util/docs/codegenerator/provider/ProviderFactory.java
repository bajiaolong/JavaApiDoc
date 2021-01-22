package com.github.ka1ka.util.docs.codegenerator.provider;

import com.github.ka1ka.util.docs.codegenerator.IFieldProvider;

/**
 * Created by user on 2016/12/25.
 */
public class ProviderFactory {

    public static IFieldProvider createProvider(){
        return new DocFieldProvider();
    }
}
