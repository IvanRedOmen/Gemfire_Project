package com.gemfire.tarea.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemfire.tarea.model.Session;
import com.gemstone.gemfire.cache.GemFireCache;

@Configuration
public class GemfireConfig {
	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<String, Session> customerRegion(final GemFireCache cache) {
		LocalRegionFactoryBean<String, Session> customerRegion = new LocalRegionFactoryBean<>();
		customerRegion.setCache(cache);
		customerRegion.setName("session");
		customerRegion.setPersistent(false);
		return customerRegion;
	}
}
