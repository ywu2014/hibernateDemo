package com.jiangnan.hibernate.test;

import com.jiangnan.hibernate.domain.Student;
import com.jiangnan.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2014/7/17.
 */
public class StudentCRUDTest {
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
        student.setAge(20);
        student.setEntranceDate(new Date());
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
    public void testQueryStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,1L);
            System.out.println("id:" + student.getId() + " name:" + student.getName() + " age:" + student.getAge());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
    }

    @Test
    public void testUpdateStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,1L);
            student.setName("lisi");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            if(null != session){
                session.close();
            }
        }
    }

    @Test
    public void testDeleteStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,1L);
            session.delete(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
    }
}
