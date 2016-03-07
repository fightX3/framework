package com.utils.freemarker;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.utils.SpringContextHolder;

import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;
public class MyFreeMarkerConfig extends  FreeMarkerConfigurer{
	private static final Logger LOG = LoggerFactory.getLogger(MyFreeMarkerConfig.class);
	@Override
	public Configuration getConfiguration() {
		Configuration configuration = super.getConfiguration();
		ApplicationContext ac  = SpringContextHolder.getApplicationContext();
		// 获取实现TemplateDirectiveModel的bean
		Map<String, TemplateDirectiveModel> beans = ac.getBeansOfType(TemplateDirectiveModel.class);
		try {
			for (String key : beans.keySet()) {
				Object obj = beans.get(key);
				if (obj != null && obj instanceof TemplateDirectiveModel) {
					configuration.setSharedVariable(key, obj);
				}
			}
		} catch (TemplateModelException e) {
			LOG.error("freemarker配置设置自定义标签类异常",e);
		}
		return configuration;
	}
}
