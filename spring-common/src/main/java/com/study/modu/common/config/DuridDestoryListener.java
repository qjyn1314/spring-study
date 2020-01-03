package com.study.modu.common.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * <p>
 * Explain: 销毁mysql驱动链接资源
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-02 15:00
 */
public class DuridDestoryListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 解决Tomcat mysql 驱动内存泄漏，手动注销JDBC
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
