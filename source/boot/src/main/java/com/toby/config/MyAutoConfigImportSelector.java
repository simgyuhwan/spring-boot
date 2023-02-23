package com.toby.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.toby.config.autoconfig.DispatcherServletConfig",
                "com.toby.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
