package jd_bc_crud_opertion.prepare_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_pepere_statement {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root");

//		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
//		PreparedStatement preparedStatement=connection.prepareStatement("create database facebook");
//		preparedStatement.execute();
//		System.out.println("database is created");

//		PreparedStatement preparedStatement=connection.prepareStatement("create table user_form (pwd int(10) primary key, user_name varchar(20) not null, mail varchar(20) not null) ");
//		preparedStatement.execute();
//		System.out.println("table is created");

		Scanner sc = new Scanner(System.in);
		System.out.println("1=insert   2=fetch-all  3=update   4=fetch by id  5=delete_row");
		int no = sc.nextInt();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user_form values(?,?,?)");
		PreparedStatement preparedStatement2 = connection.prepareStatement("select * from user_form");
		switch (no) {
		case 1:
			System.out.println("insert pwd");
			int pwd = sc.nextInt();
			System.out.println("insert user name");
			String user_name = sc.next();
			System.out.println("insert mail");
			String mail = sc.next();

			preparedStatement.setInt(1, pwd);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, mail);
			preparedStatement.execute();
			System.out.println("data inserted");
			break;
		case 2:
			ResultSet resultSet = preparedStatement2.executeQuery();
			while (resultSet.next()) {
				int pwd2 = resultSet.getInt(1);

				String user_name2 = resultSet.getString(2);

				String mail2 = resultSet.getString(3);

				System.out.println(pwd2 + " " + user_name2 + " " + mail2);

			}
			break;
		case 3:
			PreparedStatement preparedStatement3 = connection
					.prepareStatement("update user_form set user_name=?,mail=? where pwd=?");

			System.out.println("enter username");
			String user_name3 = sc.next();
			System.out.println("enter mail");
			String mail3 = sc.next();
			System.out.println("enter pwd");
			int pwd3 = sc.nextInt();

			preparedStatement3.setString(1, user_name3);
			preparedStatement3.setString(2, mail3);
			preparedStatement3.setInt(3, pwd3);

			preparedStatement3.execute();
			System.out.println("data updated");
			break;

		case 4:
			PreparedStatement preparedStatement4 = connection.prepareStatement("select * from user_form where pwd=?");

			System.out.println("enter pwd");
			int pdw4 = sc.nextInt();
			preparedStatement4.setInt(1, pdw4);
			ResultSet resultSet2 = preparedStatement4.executeQuery();

			resultSet2.next();
			System.out.println(resultSet2.getInt(1) + "  " + resultSet2.getString(2) + "  " + resultSet2.getString(3));
			break;
		case 5:
			PreparedStatement preparedStatement5 = connection.prepareStatement("delete from user_form where pwd=?");
			System.out.println("enter pwd");
			int pwd5 = sc.nextInt();
			preparedStatement5.setInt(1, pwd5);
			preparedStatement5.execute();
			System.out.println("data deleted");
		}

	}

}
