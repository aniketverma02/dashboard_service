package com.include.dashboardService.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Component
public class Client {

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private Integer port;

	@Value("${spring.data.mongodb.username}")
	private String username;

	@Value("${spring.data.mongodb.password}")
	private String password;

	private MongoClient mongoClient;

	@Autowired
	public Client(
			@Value("${spring.data.mongodb.database}") String databaseName,
			@Value("${spring.data.mongodb.host}") String host,
			@Value("${spring.data.mongodb.port}") Integer port,
			@Value("${spring.data.mongodb.username}") String username,
			@Value("${spring.data.mongodb.password}") String password) {
		
		this.username = username;
		this.password = password;
		this.host = host;
		this.databaseName = databaseName;
		this.port = port;
		
		ServerAddress serverAddress = new ServerAddress(host, port);
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createCredential(username, databaseName, password.toCharArray()));
		this.mongoClient = new MongoClient(serverAddress, credentials);
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the mongoClient
	 */
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	@PreDestroy
	public void close() {
		mongoClient.close();
	}

}
