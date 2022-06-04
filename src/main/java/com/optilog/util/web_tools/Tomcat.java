package com.optilog.util.web_tools;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.http.HttpServlet;
import java.io.File;

public class Tomcat extends HttpServlet {
	public static void startTomcat() throws RuntimeException {
		new Thread(() -> {
			org.apache.catalina.startup.Tomcat tomcat = new org.apache.catalina.startup.Tomcat();
			tomcat.setPort(Integer.getInteger("port", 8080));
			tomcat.getConnector();
			
			Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
			WebResourceRoot resources = new StandardRoot(ctx);
			resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", new File("build/classes").getAbsolutePath(), "/"));
			ctx.setResources(resources);
			
			try {
				tomcat.start();
			} catch (LifecycleException e) {
				throw new RuntimeException(e);
			}
			tomcat.getServer().await();
		}).start();
	}
}
