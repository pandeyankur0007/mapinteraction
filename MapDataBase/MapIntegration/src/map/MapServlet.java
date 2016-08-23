package map;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import dbConnection.DBConnectionHandler;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> latitude = new ArrayList<String>();
	    ArrayList<String> longtitude = new ArrayList<String>();
	    ArrayList<String> place = new ArrayList<String>();
		
		String sql = "SELECT latitude,longtitude,place FROM map";
		Connection con = DBConnectionHandler.getConnection();
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
	
				latitude.add(rs.getString(1));
				longtitude.add(rs.getString(2));
				place.add(rs.getString(3));
				
	        } 

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
         JSONObject ob = new JSONObject();
		 JSONArray jarray = new JSONArray();
		    try { 
		        //JSONObject ob = new JSONObject();
		        for (int i = 0; i < latitude.size(); i++) {
		            ob=new JSONObject();
		            ob.put("Lat", latitude.get(i));
		            ob.put("Lng", longtitude.get(i));
		            ob.put("Pal", place.get(i));
		            jarray.add(ob);
		        } 
		        //ob.put("map", jarray);
		    } catch (Exception e) {
		        e.printStackTrace(); 
		    }	

		System.out.println(ob);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jarray.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
