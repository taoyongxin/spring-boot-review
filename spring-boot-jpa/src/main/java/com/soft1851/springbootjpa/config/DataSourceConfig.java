//package com.soft1851.springbootjpa.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
// * @author Tao
// * @version 1.0
// * @ClassName DataSourceConfig
// * @Description 创建 DataSourceConfig 添加 @Configuration 注解，在项目启动时运行初始化数据库资源。
// * @date 2020-05-13 17:01
// **/
//@Configuration
//public class DataSourceConfig {
//
//    /**
//     * 在 DataSourceConfig 类中加载配置文件，利用 ConfigurationProperties 自动装配的特性加载两个数据源。
//     * 加载第一个数据源，数据源配置以 spring.datasource.primary 开头，
//     * 注意当有多个数据源时，需要将其中一个标注为 @Primary，作为默认的数据源使用。
//     * @return
//     */
//    @Bean(name = "primaryDataSource")
//    @Primary
//    @ConfigurationProperties("spring.datasource.primary")
//    public DataSource firstDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 加载第二个数据源，数据源配置以 spring.datasource.secondary 为开头。
//     * @return
//     */
//    @Bean(name = "secondaryDataSource")
//    @ConfigurationProperties("spring.datasource.secondary")
//    public DataSource secondDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 加载 JPA 的相关配置信息，JpaProperties 是 JPA 的一些属性配置信息，
//     * 构建 LocalEntityManagerFactoryBean 需要参数信息注入到方法中。
//     */
//    @Autowired
//    private JpaProperties jpaProperties;
//    @Autowired
//    private HibernateProperties hibernateProperties;
//
//    @Bean(name = "vendorProperties")
//    public Map<String, Object> getVendorProperties() {
//        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
//    }
//
//}
