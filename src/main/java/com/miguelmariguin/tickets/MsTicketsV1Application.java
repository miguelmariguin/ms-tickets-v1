package com.miguelmariguin.tickets;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EntityScan
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableAsync
@EnableCaching
public class MsTicketsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsTicketsV1Application.class, args);
	}
	
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:tickets");
        config.setUsername("sa");
        config.setPassword("");
        config.setMaximumPoolSize(100); 
        return new HikariDataSource(config);
    }

}
