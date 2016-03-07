package com.test;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.stereotype.Component;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component("cdcb_hw2")
public class ClearHTMLDirective1 implements TemplateDirectiveModel{
	@SuppressWarnings({  "deprecation" })
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
			String value = "hello world!2!2";
			if(body != null){ 
				env.setVariable("value", ObjectWrapper.DEFAULT_WRAPPER
						.wrap(value));
				 body.render(env.getOut()); 
			}else{
				Writer out = env.getOut();
				out.append(value);
			}
	}

}
