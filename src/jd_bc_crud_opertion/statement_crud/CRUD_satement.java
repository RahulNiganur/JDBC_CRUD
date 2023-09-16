package jd_bc_crud_opertion.statement_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_satement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");
        System.out.println("connection estableshed");
		Statement statement=connection.createStatement();
//        statement.execute("create database reg");
//        System.out.println("database created in the workbech");
//		
//		statement.execute("create table form_registration (pwd int(10) primary key , name varchar(20) not null , username varchar(20))");
//		System.out.println("table is creted");
		
//		statement.execute("alter table form_registration add mail varchar(20)");
//		System.out.println("column updated");
		
//		statement.execute("insert into form_registration values(12,'avanu','avanu@gmail.com')");
//		System.out.println("data inserted");
		
//		statement.execute("update form_registration set name='ava' where pwd=12");
//		System.out.println("data updated");
		
//		Object o=statement.execute("select * from form_registration");
//		System.out.println(o);
		
//		statement.execute("delete from form_registration where pwd=12");
//		System.out.println("data deleted");
	}

}
