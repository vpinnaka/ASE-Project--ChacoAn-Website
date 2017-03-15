package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.ProviderDb;
import application.MemberUtil;
public class Provider {

	 private Connection connection;

	    public Provider() {
	        connection = MemberUtil.getConnection();
	    }
	    public void addProviderDb(ProviderDb ProviderDb) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("INSERT INTO Provider_new(firstname,lastname,streetadd,city,state,date,type,status) values(?,?,?,?,?,?,?,?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, ProviderDb.getFirstName());
	            preparedStatement.setString(2, ProviderDb.getLastName());
	            preparedStatement.setString(3,ProviderDb.getStreetAdd());
	            preparedStatement.setString(4, ProviderDb.getCity());
	            preparedStatement.setString(5, ProviderDb.getState());
	            preparedStatement.setString(6, ProviderDb.getJoinDate());
	            preparedStatement.setString(7, ProviderDb.getType());
	            preparedStatement.setString(8, ProviderDb.getStatus());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteProviderDb(int proid) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from Provider_new where proid=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1,proid);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateProviderDb(ProviderDb ProviderDb) {
	    	String sql = "update Provider_new set streetadd=?,city=?,state=?,type=?,status=? where proid=?";
	    	System.out.println("**************************");
	    	System.out.println(ProviderDb.getStreetAdd());
	    	System.out.println(ProviderDb.getCity());
	    	System.out.println(ProviderDb.getState());
	    	System.out.println(ProviderDb.getproid());
	    	System.out.println(ProviderDb.getStatus());
	    	
	        System.out.println("i am here");
	    	try
	        {
	        	PreparedStatement  preparedStatement = connection.prepareStatement(sql);
	        	preparedStatement.setString(1,ProviderDb.getStreetAdd());
		        preparedStatement.setString(2, ProviderDb.getCity());
		        preparedStatement.setString(3, ProviderDb.getState());
		        preparedStatement.setString(4, ProviderDb.getType());
		        preparedStatement.setString(5, ProviderDb.getStatus());
		        preparedStatement.setInt(6, ProviderDb.getproid());
		        preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<ProviderDb> getAllProviderDbs() {
	        List<ProviderDb> ProviderDbs = new ArrayList<ProviderDb>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from Provider_new");
	            while (rs.next()) {
	                ProviderDb ProviderDb = new ProviderDb();
	                ProviderDb.setproid(rs.getInt("proid"));
	                ProviderDb.setFirstName(rs.getString("firstname"));
	                ProviderDb.setLastName(rs.getString("lastname"));
	                ProviderDb.setJoinDate(rs.getString("date"));
	                ProviderDb.setStreetAdd(rs.getString("streetadd"));
	                ProviderDb.setCity(rs.getString("city"));
	                ProviderDb.setState(rs.getString("state"));
	                ProviderDb.setType(rs.getString("type"));
	                ProviderDb.setStatus(rs.getString("status"));
	                ProviderDbs.add(ProviderDb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ProviderDbs;
	    }

	    public ProviderDb getProviderDbById(int ProviderDbId) {
	        ProviderDb ProviderDb = new ProviderDb();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from Provider_new where proid=?");
	            preparedStatement.setInt(1, ProviderDbId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                ProviderDb.setproid(rs.getInt("proid"));
	                ProviderDb.setFirstName(rs.getString("firstname"));
	                ProviderDb.setLastName(rs.getString("lastname"));
	                ProviderDb.setJoinDate(rs.getString("date"));
	                ProviderDb.setStreetAdd(rs.getString("streetadd"));
	                ProviderDb.setCity(rs.getString("city"));
	                ProviderDb.setState(rs.getString("state"));
	                ProviderDb.setType(rs.getString("type"));
	                ProviderDb.setStatus(rs.getString("status"));
	                
	                   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ProviderDb;
	    }
}
