package com.mediaroids.Shared;

import org.apache.camel.Producer;

public class CustomUrlRewrite implements org.apache.camel.http.common.UrlRewrite {

    @Override
    public String rewrite(String url, String relativeUrl, Producer producer) throws Exception {
        int partToDelete = url.lastIndexOf(relativeUrl);
        return url.substring(0, partToDelete);

    }
}
