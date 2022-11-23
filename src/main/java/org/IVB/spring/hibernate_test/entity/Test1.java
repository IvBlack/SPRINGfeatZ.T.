package org.IVB.spring.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory ssFactory = new Configuration()
                .configure().addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session ss = ssFactory.getCurrentSession();
            Employee emp = new Employee("Alexander", "Smirnov", "HR", 850);
            ss.beginTransaction();
            ss.save(emp);
            ss.getTransaction().commit();
            System.out.println("Done!");
            System.out.println(emp);
        } finally {
            ssFactory.close();
        }
    }
}
