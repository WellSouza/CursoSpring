package br.com.estudo.bd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesteBDServelet
 */
@WebServlet("/TesteBDServelet")
public class TesteBDServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user	= "springstudent";
		String pwd	= "springstudent";
		String stringConn = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		PrintWriter out = response.getWriter();
		try {
			
			out.println("Conectando com o banco...\n");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(stringConn,user,pwd); 
			
			out.println("Conectou com sucesso!");
			conn.close();
			
			
		}catch(Exception ex){
			out.println("Erro ao executar operação");
			
		}		
				
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

}
