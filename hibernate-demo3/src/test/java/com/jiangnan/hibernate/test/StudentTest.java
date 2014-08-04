package com.jiangnan.hibernate.test;

import com.jiangnan.hibernate.domain.Student;
import com.jiangnan.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: yejunwu123@gmail.com
 * Date: 2014-07-26 22:20
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
        Transaction tx = session.beginTransaction();
        try {
            Student student = new Student();
            student.setName("zhangsan");
            student.setAge((short)20);
            student.setBirthTime(new Date());
            student.setEntranceDay(new Date());
            student.setHeight(170);
            student.setInsertTime(new Date());
            student.setLastUpdate(new Date());
            student.setNationality(Locale.CHINA);
            student.setSelfIntroduction("hello,my name is zhangsan,glad to see you!");
            //student.setSex('男');
            student.setStatus(true);
            student.setTuition(new BigDecimal(1300.345));
            student.setWeight(63.798f);
            session.save(student);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if (null != session){
                session.close();
            }
        }
    }

    @Test
    public void testUpdateStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,1L);
            System.out.println("身高体重比：" + student.getBmi());
            student.setHeight(180);
            student.setInsertTime(new Date());
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
    public void testAddStudent1(){
        Transaction tx = session.beginTransaction();
        try {
            com.jiangnan.hibernate.domain.annotation.Student student = new com.jiangnan.hibernate.domain.annotation.Student();
            student.setName("lisi");
            student.setAge((short)20);
            student.setBirthTime(new Date());
            student.setEntranceDay(new Date());
            student.setHeight(170);
            student.setInsertTime(new Date());
            student.setLastUpdate(new Date());
            student.setNationality(Locale.CHINA);
            student.setSelfIntroduction("hello,my name is zhangsan,glad to see you!");
            //student.setSex('男');
            student.setStatus(true);
            student.setTuition(new BigDecimal(1300.345));
            student.setWeight(63.798f);
            session.save(student);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if (null != session){
                session.close();
            }
        }
    }

    @Test
    public void testUpdateStudent1(){
        Transaction tx = session.beginTransaction();
        try {
            com.jiangnan.hibernate.domain.annotation.Student student = (com.jiangnan.hibernate.domain.annotation.Student)session.get(com.jiangnan.hibernate.domain.annotation.Student.class,1L);
            System.out.println("身高体重比：" + student.getBmi());
            student.setHeight(180);
            student.setInsertTime(new Date());
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
