package com.optilog.log.jdbc;

import com.optilog.log.LogEvent;
import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.OnlyInLog;

import java.sql.*;

public class MySQL {
    public volatile Connection conn;

    public volatile boolean sendToJdbc = false;

    public volatile String dataBaseName;

    @OnlyInInit
    public static void initAppender(String url, String username, String password, String dataBaseName, Optilog instance) {
        instance.connection.dataBaseName = dataBaseName;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            instance.connection.conn = conn;
            try (Statement statement = instance.connection.conn.createStatement()) {
                statement.execute("USE " + dataBaseName);
                statement.execute("CREATE TABLE IF NOT EXISTS logs (id BIGINT AUTO_INCREMENT NOT NULL, lvl VARCHAR(5) NOT NULL, class VARCHAR(20) NOT NULL, message VARCHAR(900) NOT NULL, AllMessage VARCHAR(2000) NOT NULL, PRIMARY KEY(id)) Engine=INNODB DEFAULT CHARSET=UTF8;");
                instance.connection.conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                instance.connection = null;
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @OnlyInLog
    public static void logAppender(LogEvent logEvent, String clazz, String allMessage, Optilog instance) {
        try (Statement statement = instance.connection.conn.createStatement()) {
            statement.execute("USE " + instance.connection.dataBaseName);
            try (PreparedStatement ps = instance.connection.conn.prepareStatement("INSERT INTO logs (lvl, class, message, AllMessage) VALUES (?,?,?,?);")) {
                instance.connection.conn.setAutoCommit(false);
                //instance.connection.conn.setAutoCommit(false);
                ps.setObject(1, logEvent.level.getName());
                ps.setObject(2, clazz);
                ps.setObject(3, logEvent.message);
                ps.setObject(4, allMessage);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    instance.connection.conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } finally {
                try {
                    instance.connection.conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
