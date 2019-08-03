package org.ainy.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({PushEngineDataSourceProperties.class})
public class DataSourceConfig {

    @Bean("pushEngineDatasource")
    public DataSource db1Source(PushEngineDataSourceProperties pushEngineDataSourceProperties) {

        return getDataSource(pushEngineDataSourceProperties.getUrl(),
                pushEngineDataSourceProperties.getUsername(),
                pushEngineDataSourceProperties.getPassword(),
                pushEngineDataSourceProperties.getDriverClassName()
        );
    }

    private DruidDataSource getDataSource(String url, String userName, String password, String driverClassName) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    //配置事务管理
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }

    //
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
        return fb.getObject();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("pushEngineDatasource") DataSource messageDatasource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.pushEngine, messageDatasource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);

        return dataSource;
    }
}
