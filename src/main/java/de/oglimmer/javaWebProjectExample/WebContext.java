package de.oglimmer.javaWebProjectExample;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/*
 * Adding a "DB access" bean to the servlet context
 */
@WebListener
public class WebContext implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.setAttribute("DBACCESS", new DbAccess());
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
