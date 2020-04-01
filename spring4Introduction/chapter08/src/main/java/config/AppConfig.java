package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.ChangePasswordService;
import spring.MemberDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author Seunghyun Kim
 * @since 2020-04-01
 */

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("org.mariadb.jdbc.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException();
        }
        ds.setJdbcUrl("jdbc:mariadb://192.168.0.10:3307/spring4fs?characterEncoding=utf8");
        ds.setUser("spring4");
        ds.setPassword("tmvmfld4@FOUR");
        return ds;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        return new ChangePasswordService(memberDao());
    }
}
