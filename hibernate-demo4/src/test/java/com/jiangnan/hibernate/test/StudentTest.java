package com.jiangnan.hibernate.test;

import com.jiangnan.hibernate.domain.Image;
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
            student.addEmail("zhangsan@126.com");
            student.addEmail("zhangsan@gmail.com");
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
    public void testGetStudent(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = (Student)session.get(Student.class,1L);
            for (String email : student.getEmails()){
                System.out.println(email);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (null != session){
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
            student.addEmail("lisi@126.com");
            student.addEmail("lisi@gmail.com");
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
    public void testAddStudent2(){
        Transaction tx = session.beginTransaction();
        try {
            Student student = new Student();
            student.setName("wangwu");

            Image image1 = new Image();
            image1.setName("pic_1.jpg");
            image1.setPath("xxx/xx/pic_1.jpg");
            image1.setWidth(20);
            image1.setHeight(15);
            student.addImage(image1);

            Image image2 = new Image();
            image2.setName("pic_2.jpg");
            image2.setPath("xxx/xx/x/pic_2.jpg");
            image2.setWidth(30);
            image2.setHeight(40);
            student.addImage(image2);

            session.save(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (null != session){
                session.close();
            }
        }
    }

    @Test
    public void testAddStudent3(){
        Transaction tx = session.beginTransaction();
        try {
            com.jiangnan.hibernate.domain.annotation.Student student = new com.jiangnan.hibernate.domain.annotation.Student();
            student.setName("wangwu");

            com.jiangnan.hibernate.domain.annotation.Image image1 = new com.jiangnan.hibernate.domain.annotation.Image();
            image1.setName("img_1.jpg");
            image1.setPath("xxx/xx/img_1.jpg");
            image1.setWidth(15);
            image1.setHeight(10);
            student.addImage(image1);

            com.jiangnan.hibernate.domain.annotation.Image image2 = new com.jiangnan.hibernate.domain.annotation.Image();
            image2.setName("img_2.jpg");
            image2.setPath("xxx/xx/x/img_2.jpg");
            image2.setWidth(30);
            image2.setHeight(20);
            student.addImage(image2);

            session.save(student);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (null != session){
                session.close();
            }
        }
    }
}
