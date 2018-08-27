package com.flightpub.base.hibernate.listener;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * HibernateServletContextListener
 *
 * Runs Hibernate service on application initialization
 */
public class HibernateListener implements ServletContextListener {

    private Configuration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
    private static Class clazz = HibernateListener.class;

    public static final String KEY_NAME = clazz.getName();

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);
        sessionFactory.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            URL url = HibernateListener.class.getResource(path);
            config = new Configuration().configure(url);
            factory = config.buildSessionFactory();

            //save the Hibernate session factory into serlvet context
            event.getServletContext().setAttribute(KEY_NAME, factory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
