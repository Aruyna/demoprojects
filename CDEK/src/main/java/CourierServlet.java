

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CourierServlet")
public class CourierServlet extends HttpServlet implements DBInterface{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNumber = request.getParameter("orderNumber");
		String courierId = request.getParameter("courierId");
		String msg = null;
		String sql = null;
		
		if((orderNumber != null) && (courierId != null)) 
		{
			if(orderNumber == "" || courierId == "") {
				msg = "Error. Field is not filled";
			}else {
				sql = "select * from public.courier where courier_number = '" + courierId + "'";
				if(checkDataInDB(sql)) 
				{
					sql = "select * from public.orders where order_number = '" + orderNumber + "'";
					if(checkDataInDB(sql)) 
					{
						sql = "select * from public.ordercourier where order_number = '" + orderNumber + "' " + "and courier_number = '" + courierId + "'";	
						if(checkDataInDB(sql)) 
						{
							sql = "select * from public.ChangeDelivery where order_number = '" + orderNumber + "' ";	
							if(!checkDataInDB(sql)) 
							{
								sql = "INSERT INTO public.ChangeDelivery(order_number, datetime)VALUES ('" + orderNumber +"', date_trunc('second', now()))";		
								insertDataInDB(sql);			
								msg = "Order " + orderNumber + " successfully added";
							}else msg = "Error. Order " + orderNumber + " has been added before";
						}else msg = "Error. Order " + orderNumber + " from another courier";
					}else msg = "Error. There is no order with " + orderNumber + " in the DB";
				}else msg = "Error. There is no such ID in the DB";	
			}
		}
		
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("courier.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public boolean checkDataInDB(String iSql) {
		boolean check = false;
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
            
            if(rs.next())
            	check = true;
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
	}

	@Override
	public void insertDataInDB(String iSql) {
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
            stmt.execute(iSql);
            
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
		
	}

	@Override
	public Map<String, String> selectDatafromDB(String iSql) {
		// TODO Auto-generated method stub
		return null;
	}
}
