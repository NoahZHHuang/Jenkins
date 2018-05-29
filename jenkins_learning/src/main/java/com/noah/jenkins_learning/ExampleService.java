package com.noah.jenkins_learning;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;


@Path("/")
public class ExampleService {

	@SuppressWarnings("unchecked")
	@Path("/health")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHealthStatus(){
        JSONObject healthInfo = new JSONObject();
		healthInfo.put("App", "CI_Learning");
		healthInfo.put("Description", "This app is for CI learning i.e. how to integrate the Jenkins,Maven,Nexus,Git");
		healthInfo.put("Dependencies", "None");
		healthInfo.put("Version", ExampleService.class.getPackage().getImplementationVersion());
		return Response.ok(healthInfo.toJSONString()).build();
	}
	
	
}
