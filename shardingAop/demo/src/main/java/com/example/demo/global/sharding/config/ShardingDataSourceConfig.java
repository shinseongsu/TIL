package com.example.demo.global.sharding.config;

import com.example.demo.global.sharding.properties.ShardingDataSourceProperty;
import com.example.demo.global.sharding.properties.ShardingDataSourceProperty.Property;
import com.example.demo.global.sharding.properties.ShardingDataSourceProperty.Shard;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@EnableJpaRepositories(basePackages = "com.example.demo", entityManagerFactoryRef = "entityManagerFactoryBean", transactionManagerRef = "platformTransactionManager")
@Setter
public class ShardingDataSourceConfig {

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DELIMITER = "|";

    private ShardingDataSourceProperty property;

    @Autowired(required = false)
    private PersistenceUnitManager persistenceUnitManager;

    @Bean
    public DataSourceRouter shardingDataSource() {
        Map<Object, Object> dataSourceMap = new LinkedHashMap<>();
        DataSourceRouter router = new DataSourceRouter();

        for (int i = 0; i < property.getShards().size(); i++) {
            Shard shard = property.getShards().get(i);
            Property master = shard.getMaster();
            Property slave = shard.getSlave();
            DataSource masterDataSource = DataSourceBuilder.create()
                    .driverClassName(DRIVER_CLASS_NAME)
                    .username(master.getUsername())
                    .password(master.getPassword())
                    .url(master.getUrl())
                    .type(HikariDataSource.class)
                    .build();

            DataSource slaveDataSource = DataSourceBuilder.create()
                    .driverClassName(DRIVER_CLASS_NAME)
                    .username(slave.getUsername())
                    .password(slave.getPassword())
                    .url(slave.getUrl())
                    .type(HikariDataSource.class)
                    .build();

            dataSourceMap.put(i + DELIMITER + shard.getMaster().getName(), masterDataSource);
            dataSourceMap.put(i + DELIMITER + shard.getSlave().getName(), slaveDataSource);
        }
        router.setTargetDataSources(dataSourceMap);
        router.afterPropertiesSet();

        return router;
    }

    @Bean
    public LazyConnectionDataSourceProxy lazyDataSource(DataSourceRouter dataSourceRouter) {
        return new LazyConnectionDataSourceProxy(dataSourceRouter);
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.jpa")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(JpaProperties jpaProperties,
                                                                           LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(lazyConnectionDataSourceProxy);
        em.setPackagesToScan("com.example.demo.domain");
        em.setJpaVendorAdapter(createJpaVendorAdapter(jpaProperties));
        return em;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }

    private JpaVendorAdapter createJpaVendorAdapter(
            JpaProperties jpaProperties) {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(jpaProperties.isShowSql());
        adapter.setDatabase(jpaProperties.getDatabase());
        adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
        adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        return adapter;
    }

}
