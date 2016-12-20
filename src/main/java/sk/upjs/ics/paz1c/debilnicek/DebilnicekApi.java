package sk.upjs.ics.paz1c.debilnicek;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DebilnicekApi {
    @Bean
    public UlohaDao ulohaDao() {
        return new MysqlUlohaDao(jdbcTemplate());
    }
    
    @Bean
    public UlohaDao pamatovyUlohaDao() {
        return new ZoznamUloh();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/debilnicek?serverTimezone=UTC");
        dataSource.setUser("debilnicek");
        dataSource.setPassword("debilnicek");     
        
        return dataSource;
    }
    
    
    public static void main(String[] args) {
        SpringApplication.run(DebilnicekApi.class, args);
    }
}
