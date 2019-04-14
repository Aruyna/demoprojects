

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CallCenterServlet")
public class CallCenterServlet extends HttpServlet implements DBInterface{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("findNumber");
		
		String sql;
		if(number == null || number == "") {
			sql = "SELECT order_number, datetime FROM public.ChangeDelivery";
		}
		else sql = "SELECT order_number, datetime FROM public.ChangeDelivery where order_number = '" + number + "'";
		
		//ArrayList<Order> orderList = selectDatafromDB(sql);
		Map<String, String> orderList = selectDatafromDB(sql);
		request.setAttribute("order", orderList);
		RequestDispatcher rd = request.getRequestDispatcher("callCenter.jsp");
		rd.forward(request, response);
	}
	
	public Map<String, String> selectDatafromDB(String iSql) {
		Map<String, String> ordersList = new  HashMap<String, String>();
        try {
            Class.forName(DBSource.driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
            		DBSource.url,
            		DBSource.user, DBSource.password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(iSql);

            while(rs.next()){
                ordersList.put(rs.getString("order_number"),rs.getString("datetime"));
            }
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ordersList;
	}

	@Override
	public boolean checkDataInDB(String iSQL) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertDataInDB(String iSQL) {
		// TODO Auto-generated method stub
		
	}

}
