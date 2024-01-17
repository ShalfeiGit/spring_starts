package com.example.spring.hibernate;


import com.example.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = new Employee("Valentin1", "Zadorohzniy", "PIS", 12000);

            session.save(emp);

            int newEnpId = emp.getId(); //сгенерирован автоматически hibernate при сохранении в БД
            Employee employee = session.get(Employee.class, newEnpId); // получение тлоько что созданой сущности

            employee.setName("Victor"); // автоматически установит значение в бд
            System.out.println(employee);

            Query q1 = session.createQuery("from Employee where id=:newEnpId", Employee.class);
            q1.setParameter("newEnpId", newEnpId); // установка переменных в запрос
            List<Employee> emps1 = q1.getResultList();
            for(Employee e:emps1){
                System.out.println(e);
            }

            Query q2 = session.createQuery("update Employee set salary = 8000 where id=:newEnpId");
            q2.setParameter("newEnpId", newEnpId);
            q2.executeUpdate();

            Query q3 = session.createQuery("from Employee where id=:newEnpId", Employee.class);
            q3.setParameter("newEnpId", newEnpId);
            List<Employee> emps2 = q3.getResultList();
            for(Employee e:emps2){
                System.out.println(e);
            }

            session.delete(emp); //удаление созданной сущности
            Query q4 = session.createQuery("delete Employee where name='Victor'"); //удаление с помщью запроса hql
            q4.executeUpdate();

            session.getTransaction().commit();
        }catch (Exception e){
            session.close();
            factory.close();
        }


    }
}
