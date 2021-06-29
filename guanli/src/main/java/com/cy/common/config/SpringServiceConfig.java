package com.cy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SpringServiceConfig {

	  @Bean
	  public DataSourceTransactionManager newTxManager(DataSource dataSource) {
		  DataSourceTransactionManager tx=new DataSourceTransactionManager();
		  tx.setDataSource(dataSource);
		  return tx;
	  }

}
