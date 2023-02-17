//package cmc.global.TestPurpose.configuration;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//    @Bean
//    public SessionFactory sessionFactory() {
//        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
//        builder.scanPackages("com.example.TestPurpose");
//        builder.addProperties(hibernateProperties());
//        return builder.buildSessionFactory();
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        return properties;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/testing_db");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456aA@");
//        return dataSource;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory());
//        return transactionManager;
//    }
//}
