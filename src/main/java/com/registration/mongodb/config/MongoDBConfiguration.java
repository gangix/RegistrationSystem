package com.registration.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.registration.mongodb.repository")
public class MongoDBConfiguration {
	
	@Value("${mongodb.host}")
	private String hostMongoDB;
	
	@Value("${mongodb.port}")
	private String portMongoDB;
	
	@Bean
	public MongoClient getClient() {
		return new MongoClient(hostMongoDB,Integer.parseInt(portMongoDB));
	}
	
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(getClient(), "registerDB");
    }
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
	    return new LocalValidatorFactoryBean();
	}

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener(LocalValidatorFactoryBean lfb) {
	    return new ValidatingMongoEventListener(lfb);
	}
}
