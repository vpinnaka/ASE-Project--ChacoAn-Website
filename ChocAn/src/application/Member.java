package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.MemberDb;
import application.MemberUtil;
public class Member {

	 private Connection connection;

	    public Member() {
	        connection = MemberUtil.getConnection();
	    }
	    public void addMemberDb(MemberDb memberDb) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("INSERT INTO member_new(firstname,lastname,streetadd,city,state,joindate,status) values(?,?,?,?,?,?,?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, memberDb.getFirstName());
	            preparedStatement.setString(2, memberDb.getLastName());
	            preparedStatement.setString(3,memberDb.getStreetAdd());
	            preparedStatement.setString(4, memberDb.getCity());
	            preparedStatement.setString(5, memberDb.getState());
	            preparedStatement.setString(6, memberDb.getJoinDate());
	            preparedStatement.setString(7, memberDb.getStatus());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteMemberDb(int memid) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from member_new where memid=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1,memid);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateMemberDb(MemberDb memberDb) {
	    	String sql = "update member_new set streetadd=?,city=?,state=?,status=? where memid=?";
	    	System.out.println("**************************");
	    	System.out.println(memberDb.getStreetAdd());
	    	System.out.println(memberDb.getCity());
	    	System.out.println(memberDb.getState());
	    	System.out.println(memberDb.getMemid());
	    	System.out.println(memberDb.getStatus());
	    	
	        System.out.println("i am here");
	    	try
	        {
	        	PreparedStatement  preparedStatement = connection.prepareStatement(sql);
	        	preparedStatement.setString(1,memberDb.getStreetAdd());
		        preparedStatement.setString(2, memberDb.getCity());
		        preparedStatement.setString(3, memberDb.getState());
		        preparedStatement.setString(4, memberDb.getStatus());
		        preparedStatement.setInt(5, memberDb.getMemid());
		        preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<MemberDb> getAllMemberDbs() {
	        List<MemberDb> MemberDbs = new ArrayList<MemberDb>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from member_new");
	            while (rs.next()) {
	                MemberDb MemberDb = new MemberDb();
	                MemberDb.setMemid(rs.getInt("memid"));
	                MemberDb.setFirstName(rs.getString("firstname"));
	                MemberDb.setLastName(rs.getString("lastname"));
	                MemberDb.setJoinDate(rs.getString("joindate"));
	                MemberDb.setStreetAdd(rs.getString("streetadd"));
	                MemberDb.setCity(rs.getString("city"));
	                MemberDb.setState(rs.getString("state"));
	                MemberDb.setStatus(rs.getString("status"));
	                MemberDbs.add(MemberDb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return MemberDbs;
	    }

	    public MemberDb getMemberDbById(int MemberDbId) {
	        MemberDb MemberDb = new MemberDb();
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from member_new where memid=?");
	            preparedStatement.setInt(1, MemberDbId);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                MemberDb.setMemid(rs.getInt("memid"));
	                MemberDb.setFirstName(rs.getString("firstname"));
	                MemberDb.setLastName(rs.getString("lastname"));
	                MemberDb.setJoinDate(rs.getString("joindate"));
	                MemberDb.setStreetAdd(rs.getString("streetadd"));
	                MemberDb.setCity(rs.getString("city"));
	                MemberDb.setState(rs.getString("state"));
	                MemberDb.setStatus(rs.getString("status"));
	                
	                   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return MemberDb;
	    }
}
