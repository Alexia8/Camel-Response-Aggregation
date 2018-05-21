package com.mediaroids.Shared;

import org.apache.camel.Producer;

public class CustomUrlRewrite implements org.apache.camel.http.common.UrlRewrite {

    @Override
    public String rewrite(String url, String relativeUrl, Producer producer) {
        if(relativeUrl == null) {
            return url;
        }
        try {
            int partToDelete = url.lastIndexOf(relativeUrl);
            int partNotToBeDeleted = url.lastIndexOf("?");
            if(partNotToBeDeleted == -1) return url.substring(0, partToDelete);
            String query = url.substring(partNotToBeDeleted, url.length());
            String result = url.substring(0, partToDelete) + query;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return url;
        }

    }
}
