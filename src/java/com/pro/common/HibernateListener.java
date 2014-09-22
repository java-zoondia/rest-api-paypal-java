package com.pro.common;

import java.net.URL;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 * Classname - HibernateListener
 * Version info - myDrDirect 0.9
 * @author root
 */

public class HibernateListener implements ServletContextListener {

    private Configuration config;                           // Configuration Name
    private SessionFactory factory;                         // SessionFactory Name
    private String path = "/hibernate.cfg.xml";             // path of hibernate Config file
    private static Class clazz = HibernateListener.class;   // Instance of HibernateListener class
    public static final String KEY_NAME = clazz.getName();  // Get Class Name of HibernateListener class

    /**
     * Method to Destroy Context
     * @param event 
     */
    public void contextDestroyed(ServletContextEvent event) {
    }

    /**
     * Method to initialized Context 
     * @param event 
     */
    public void contextInitialized(ServletContextEvent event) {
        try {
            URL url = HibernateListener.class.getResource(path);
            config = new Configuration().configure(url);
            factory = config.buildSessionFactory();
            //save the Hibernate session factory into serlvet context
            event.getServletContext().setAttribute(KEY_NAME, factory);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}