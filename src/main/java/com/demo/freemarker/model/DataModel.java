package com.demo.freemarker.model;

import java.util.HashMap;
import java.util.Map;

import com.demo.freemarker.directives.RepeatDirective;
import com.demo.freemarker.directives.UpperDirective;
import com.demo.freemarker.methods.IndexOfMethod;

public class DataModel {
	private Map<Object, Object> root;
	private String templateName;

	public DataModel(String templateName) {
		setRoot();
		this.root = getRoot();
		this.templateName = templateName;
	}

	public String getTemplateName() {
		return templateName + ".ftlh";
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/* Gets the created data-model */
	public Map<Object, Object> getRoot() {
		return root;
	}

	/* Create a data-model */
	public void setRoot() {
		this.root = new HashMap<Object, Object>();

		//for template: home.ftlh
		root.put("user", "Big Joe");
		Product latest = new Product();
		latest.setUrl("products/greenmouse.html");
		latest.setName("green mouse");
		root.put("latestProduct", latest);

		//for template: directive.ftlh
		root.put("upper", new UpperDirective());
		root.put("repeat", new RepeatDirective());

		//for template: index.ftlh
		root.put("indexOf", new IndexOfMethod());

	}

}
