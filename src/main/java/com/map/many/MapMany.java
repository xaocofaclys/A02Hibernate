package com.map.many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class MapMany {

		public static void main(String[] args) {
			System.out.println("hi");
			Configuration cfg = new Configuration();
			cfg.configure("com/hibernate/HibernateDemoProject/hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			System.out.println("hi2");
			Session s = factory.openSession();
			System.out.println("hi3");
			Transaction tx = s.beginTransaction();
			Emp e1 = new Emp();
			Emp e2 = new Emp();
			
			e1.setId(101);
			e1.setName("Bruce");
			
			e2.setId(102);
			e2.setName("Peter");
			
			Project p1 = new Project();
			Project p2 = new Project();
			
			p1.setPid(501);
			p1.setProjectName("HR Mgmt System");

			p2.setPid(502);
			p2.setProjectName("Automation Project");
			
			List<Emp> list1 = new ArrayList<Emp>();
			List<Project> list2 = new ArrayList<Project>();
			
			list1.add(e1);
			list1.add(e2);
			
			list2.add(p1);
			list2.add(p2);
			
			e1.setProjects(list2);
			p2.setEmployees(list1);
			
			
			
			s.save(e1);
			s.save(e2);
			
			s.save(p1);
			s.save(p2);
			
//			query1 -> input empid -> projects
//			query2 -> input projectid -> emps;
			
			tx.commit();
			s.close();
			
		}

	}