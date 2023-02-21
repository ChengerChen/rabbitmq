package com.example.rabbitmq.jpa.template;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chenger
 * @description
 * @date 2021/7/22 下午1:43
 */
public class FreeMarkerLoader {
    private Configuration configuration = null;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String mergeTemplate(String templateLocation) {
        return this.mergeTemplate(templateLocation, new HashMap());
    }

    public String mergeTemplate(String templateLocation, Map model) {
        return this.mergeTemplate(templateLocation, "utf-8", model);
    }

    public String mergeTemplate(String templateLocation, String encoding, Map<String, Object> model) {
        return this.doMergeTemplate(templateLocation, encoding, model);
    }

    protected String doMergeTemplate(String templateLocation, String encoding, Map<String, Object> model) {
        String result = "";
        Template tpl;
        try {
            tpl = this.configuration.getTemplate(templateLocation);
            Writer writer = new StringWriter();
            tpl.process(model, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
