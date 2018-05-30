package com.noah.jenkins_learning;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;		


public class JettyServer 
{
	
	private static Server server;
	
	public static void start() throws Exception{
		
		ResourceConfig config = new ResourceConfig();
		config.packages("com.noah.jenkins_learning");
		
		ServletHolder servletHolder = new ServletHolder(new ServletContainer(config));
		
		server = new Server(9999);
		ServletContextHandler contextHandler = new ServletContextHandler(server,"/");
		contextHandler.addServlet(servletHolder, "/*");
		
		server.start();
		
		System.out.println("Jetty Server Stat Up Successfully !!!");
		System.out.println("Please access http://localhost:9999/health ");
	}
	
	public static void stop() throws Exception{
		if(server!=null){
			server.stop();
		}
	}
	
	public static void main(String [] args) throws Exception{
		JettyServer.start();
	}
	
}
