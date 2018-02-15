package org.qbit.datasource.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db1EntityManager",
        transactionManagerRef = "ta1",
        basePackages = "org.qbit.datasource.demo.db1"
)
public class PrimaryDBConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "db1EntityManager")
    @ConfigurationProperties(prefix = "primary.datasource")
    public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource())
                .packages("org.qbit.datasource.demo.db1")
                .persistenceUnit("db1persistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "ta1")
    public PlatformTransactionManager ta1TransactionManager(
            @Qualifier("db1EntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
