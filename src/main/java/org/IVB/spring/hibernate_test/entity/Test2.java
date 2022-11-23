package org.IVB.spring.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory ssFactory = new Configuration()
                .configure().addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session ss = ssFactory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petriv", "Sales", 905);
            ss.beginTransaction();
            ss.save(emp);
            ss.getTransaction().commit();

            //получаем id нашего объекта
            int myId = emp.getId();

            //берем из БД этого работника по id
            //открываем сессию заново
            ss = ssFactory.getCurrentSession();
            ss.beginTransaction();
            Employee employee = ss.get(Employee.class, myId);
            ss.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            ssFactory.close();
        }
    }
}

