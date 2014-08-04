package com.jiangnan.hibernate.test;

import com.jiangnan.hibernate.domain.Student;
import com.jiangnan.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-20 21:41
 * Description:
 */
public class StudentTest {
    private Session session;

    @Before
    public void before() throws Exception {
        session = HibernateUtils.getSession();
    }

    @After
    public void after() throws Exception {
        HibernateUtils.shutdown();
    }

    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("zhangsan");
        //手动分配主键值
        student.setId(1L);
        Transaction tx = session.beginTransaction();
        try {
            session.save(student);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if(null != session){
                session.close();
            }
        }
    }

    @Test
    public void teseDeleteStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,2L);
            session.delete(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {

        }
        tx = session.beginTransaction();
        try {
            Student student = new Student();
            student.setName("wangwu");
            session.save(student);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if(null != session){
                session.close();
            }
        }
    }

    @Test
    public void testAddStudent2(){
        //重新构造一个SessionFactory，使用原来的配置文件
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session1 = sf.openSession();

        Student student = null;

        //应用1使用原来的sessionFactory创建的session开启事务
        Transaction tx = session.beginTransaction();
        try {
            student = new Student();
            student.setName("test001");
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if(null != session){
                session.close();
            }
        }

        //应用2使用新创建的sessionFactory
        tx = session1.beginTransaction();
        try {
            student = new Student();
            student.setName("test002");
            session1.save(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.commit();
        } finally {
            if (null != session1){
                session1.close();
            }
            sf.close();
        }
    }

    @Test
    public void testAddStudent3(){
        //重新构造一个SessionFactory，使用原来的配置文件
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session1 = sf.openSession();

        Student student = null;

        //应用1使用原来的sessionFactory创建的session开启事务
        Transaction tx1 = session.beginTransaction();
        student = new Student();
        student.setName("test001");
        session.save(student);

        //应用2使用新创建的sessionFactory
        Transaction tx2 = session1.beginTransaction();
        student = new Student();
        student.setName("test002");
        session1.save(student);

        //事务延迟提交
        tx1.commit();
        if(null != session){
            session.close();
        }

        tx2.commit();
        if (null != session1){
            session1.close();
        }
        sf.close();
    }

    @Test
    public void testAddStudent4(){
        com.jiangnan.hibernate.domain.annotation.Student student = new com.jiangnan.hibernate.domain.annotation.Student();
        student.setName("zhaoqiansun");
        Transaction tx = session.beginTransaction();
        try {
            session.save(student);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if(null != session){
                session.close();
            }
        }
    }

    @Test
    public void testAddStudent5(){
        Transaction tx = session.beginTransaction();
        try {
            for(int i=0;i<6;i++){
                Student student = new Student();
                student.setName("admin" + i);
                session.save(student);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if(null != session){
                session.close();
            }
        }
    }

    @Test
    public void testAddStudent6(){
        Transaction tx = session.beginTransaction();
        try {
            for(int i=0;i<6;i++){
                com.jiangnan.hibernate.domain.annotation.Student student = new com.jiangnan.hibernate.domain.annotation.Student();
                student.setName("wcsadmin" + i);
                session.save(student);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if(null != session){
                session.close();
            }
        }
    }
}
