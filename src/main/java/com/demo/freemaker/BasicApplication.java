package com.demo.freemaker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.demo.freemarker.model.DataModel;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class BasicApplication {

	private static String DirectoryForTemplateLoading = "C://Users//SankarD//Documents//Spring Java Workspace//FreeMarker//src//main//resources//templates";
	private static String DefaultEncoding = "UTF-8";
	static Configuration cfg;

	static {
		/* ------------------------------------------------------------------------ */
		/* You should do this ONLY ONCE in the whole application life-cycle:        */

		/* Create and adjust the configuration singleton */
		cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File(BasicApplication.DirectoryForTemplateLoading));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cfg.setDefaultEncoding(BasicApplication.DefaultEncoding);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public static void main(String[] args) throws Exception {

		/* ------------------------------------------------------------------------ */
		/* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

		//gets the data-model with template
		DataModel dataModel = new DataModel("directive");

		/* Get the template (uses cache internally) */
		Template temp = cfg.getTemplate(dataModel.getTemplateName());

		/* Merge data-model with template */
		Writer out = new OutputStreamWriter(System.out);
		temp.process(dataModel.getRoot(), out);
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.
	}
}
