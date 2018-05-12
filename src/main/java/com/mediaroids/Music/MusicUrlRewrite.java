package com.mediaroids.Music;

import org.apache.camel.Producer;
import org.apache.camel.http.common.UrlRewrite;

public class MusicUrlRewrite implements UrlRewrite {

    @Override
    public String rewrite(String url, String relativeUrl, Producer producer) throws Exception {
        int partToDelete = url.lastIndexOf(relativeUrl);
        return url.substring(0, partToDelete);

    }
}
