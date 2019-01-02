package de.oglimmer.javaWebProjectExample;

/*
 * Class providing configurable properties from a property file. 
 */
public class JavaProperties extends de.oglimmer.utils.AbstractProperties {

	public static final JavaProperties SINGLETON = new JavaProperties();

	private JavaProperties() {
		super("config.properties");
	}

	public String getDbHost() {
    	return getJson().getString("db.host");
	}

}
