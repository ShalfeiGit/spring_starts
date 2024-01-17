package com.example.spring.relations;

import com.example.spring.relations.entity.Department;
import com.example.spring.relations.entity.Detail;
import com.example.spring.relations.entity.Employee;
import com.example.spring.relations.entity.Specialization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRelations {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Specialization.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail1 = new Detail("Tomsk", 890100001, "abak@gmail.com");
            Detail detail2 = new Detail("Novosibirsk", 890100002, "ffdfk@gmail.com");
            Detail detail3 = new Detail("Moscow", 890100003, "gtgr@gmail.com");
            Detail detail4 = new Detail("StPeter", 890100004, "vsgh@gmail.com");
            Detail detail5 = new Detail("Vladivostok", 890100005, "iiuuy@gmail.com");

            Department department1 = new Department("IT" , 20000, 50000);
            Department department2 = new Department("HR" , 15000, 30000);
            Department department3 = new Department("Sales" , 22000, 45000);

            Specialization specialization1 = new Specialization("Frontend");
            Specialization specialization2 = new Specialization("Backend");
            Specialization specialization3 = new Specialization("QA");
            Specialization specialization4 = new Specialization("Manager" );
            Specialization specialization5 = new Specialization("Superior");
            Specialization specialization6 = new Specialization("Analyst");

            Employee employee1 = new Employee("Victor", "Sidrorov");
            Employee employee2 = new Employee("Anton", "Abmarolov");
            Employee employee3 = new Employee("Kirill", "Voikin");
            Employee employee4 = new Employee("Vasya", "Jidkov");
            Employee employee5 = new Employee("Jenya", "Smirnov");

            employee1.setDepartment(department1);
            employee2.setDepartment(department2);
            employee3.setDepartment(department3);
            employee4.setDepartment(department1);
            employee5.setDepartment(department1);

            employee1.setDetail(detail1);
            employee2.setDetail(detail2);
            employee3.setDetail(detail3);
            employee4.setDetail(detail4);
            employee5.setDetail(detail5);

            employee1.setSpecialization(specialization1);
            employee1.setSpecialization(specialization3);
            employee2.setSpecialization(specialization5);
            employee3.setSpecialization(specialization4);
            employee3.setSpecialization(specialization2);
            employee3.setSpecialization(specialization1);
            employee4.setSpecialization(specialization6);
            employee5.setSpecialization(specialization3);
            employee5.setSpecialization(specialization4);

            session.save(detail1);
            session.save(detail2);
            session.save(detail3);
            session.save(detail4);
            session.save(detail5);

            session.save(department1);
            session.save(department2);
            session.save(department3);

            session.save(specialization1);
            session.save(specialization2);
            session.save(specialization3);
            session.save(specialization4);
            session.save(specialization5);
            session.save(specialization6);

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            session.save(employee4);
            session.save(employee5);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

}
