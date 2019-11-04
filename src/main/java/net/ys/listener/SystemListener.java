package net.ys.listener;

import net.ys.util.Tools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: NMY
 * Date: 16-8-29
 */
public class SystemListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--- contextDestroyed ---");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--- contextInitialized ---");
        Tools.godBless();
    }
}