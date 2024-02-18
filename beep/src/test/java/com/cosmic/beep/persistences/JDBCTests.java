package com.cosmic.beep.persistences;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class JDBCTests {
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "beepdb", "beepbeep")) {
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
