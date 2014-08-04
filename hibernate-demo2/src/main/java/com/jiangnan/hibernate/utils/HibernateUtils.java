package com.jiangnan.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2014/7/17.
 */
public class HibernateUtils {
    private static SessionFactory sf = null;
    static {
//        sf = new Configuration().configure().buildSessionFactory();
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    /**
     *
     * @return 返回新的session
     */
    public static Session getSession(){
        return sf.openSession();
    }

    /**
     *
     * @return 返回上下文相关的session
     */
    public static Session getCurrentSession(){
        return sf.getCurrentSession();
    }

    public static SessionFactory getSessionFactory(){
        return sf;
    }

    public static void shutdown(){
        sf.close();
    }
}
