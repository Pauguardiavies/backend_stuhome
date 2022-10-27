package Stuhome_Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class StuhomeJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  jdbcURL = "jdbc:mysql://localhost:3306/stuhome?useSSL=false";
		String usuario = "root";
		String contra = "";
		
		//Conecxion BBDD JDBC.
		
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcURL);
			Connection miConecxion = DriverManager.getConnection(jdbcURL, usuario, contra);
			System.out.println("Conexion exitosa!!");
				}catch(Exception e){
					e.printStackTrace();
			}
		}
}
