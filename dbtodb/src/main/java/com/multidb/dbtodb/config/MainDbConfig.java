package com.multidb.dbtodb.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(basePackages = "com.multidb.dbtodb.model", entityManagerFactoryRef = "firstEntityManager", transactionManagerRef = "firstTransactionManager")
@Configuration
public class MainDbConfig {
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean firstEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(firstDataSource());
        em.setPackagesToScan(new String[] { "com.multidb.dbtodb.model.entity" });
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return em;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager firstTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(firstEntityManager().getObject());
        return transactionManager;
    }
}
