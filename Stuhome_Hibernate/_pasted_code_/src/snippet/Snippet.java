package snippet;

public class Snippet {
	<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	 <hibernate-configuration>
	    <session-factory>
	      <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
	      <property name="connection.url">jdbc:mysql://localhost/hibernate1</property>
	 7:     <property name="connection.username">hibernate1</property>
	 8:     <property name="connection.password">hibernate1</property>
	 9:     <property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>
	10:     <property name="hibernate.show_sql">true</property>
	11:
	12:     <mapping resource="ejemplo01/Profesor.hbm.xml"/>
	13:     <mapping class="ejemplo01.Profesor"/>
	14:
	15:   </session-factory>
	16: </hibernate-configuration>
}

