package mypackage;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public final class Hello extends HttpServlet{
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException, ServletException {
		//response.setContentType("application/json");
		//response.getWriter().write(checkDateBase().toString());
		//final PrintWriter writer = response.getWriter();
		//writer.println(checkDateBase().toString());
		//return checkDateBase().toString();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(checkDateBase().toString());
		out.flush();
	}
	protected ArrayList<String> checkDateBase(){
		Connection c = null;
		Statement stmt = null;
		ArrayList respuesta = new ArrayList();
		ArrayList temp = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/mydb",
						"postgres", "password-sql");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" );
			while ( rs.next() ) {
				temp = new ArrayList();
				temp.add('"'+rs.getString(1).trim()+'"');
				temp.add('"'+rs.getString(2).trim()+'"');
				temp.add('"'+rs.getString(3).trim()+'"');
				temp.add('"'+rs.getString(4).trim()+'"');
				temp.add('"'+rs.getString(5).trim()+'"');
				respuesta.add(temp.clone());
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return respuesta;
	} }
