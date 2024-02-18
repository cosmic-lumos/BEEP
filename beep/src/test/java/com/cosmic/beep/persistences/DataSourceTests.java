package com.cosmic.beep.persistences;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
@ActiveProfiles("test")
@SpringBootTest
public class DataSourceTests {
    @Autowired
    private DataSource dataSource;
    @Test
    public void testConnection(){
        try(Connection con = dataSource.getConnection()){
            log.error(con);
        } catch (Exception e){
            fail(e.getMessage());
        }
    }
}
