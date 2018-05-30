package com.noah.jenkins_learning;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Type;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JettyServerTest {
	
	private static final String REST_HEALTH_URL = "http://localhost:9999/health";

	private static final Client client = ClientBuilder.newClient();
	
	@BeforeClass
	public static void startUp() throws Exception{
		JettyServer.start();
	}
	
	@AfterClass
	public static void resetData() throws Exception{
		JettyServer.stop();
	}
	
	@Test
	public void testHealth(){
		String healthInfoJson = client.target(REST_HEALTH_URL).request().get(String.class);
		Type type = new TypeToken<Map<String, String>>(){}.getType();
		Map<String, String> healthInfo = new Gson().fromJson(healthInfoJson, type);
		assertThat(healthInfo.get("App"), equalTo("CI_Learning"));
	}
}
