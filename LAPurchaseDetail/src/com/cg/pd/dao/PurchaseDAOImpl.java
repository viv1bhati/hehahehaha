package com.cg.pd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.pd.dto.Mobile;
import com.cg.pd.dto.PurchaseDetails;
import com.cg.pd.exception.PurchaseException;

public class PurchaseDAOImpl implements PurchaseDAO {
	
	
	Connection conn;
	
	public PurchaseDAOImpl() throws PurchaseException{
		
		
			conn = DBConnection.getConnection();
	
	}
	
	public int generateId() throws SQLException{
		
		int id = 0;
		Statement stmt= conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id_gen.nextval from dual");
		
		if(rs.next()){
			 id = rs.getInt(1);
			
		}
		return id;
	}
	
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) throws SQLException {
		
		String sql= "insert into purchasedetails values "+"( ? , ? , ? , ? , sysdate , ? )";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int id = generateId();
		ps.setInt(1,id );
		ps.setString(2, pr.getCustName());
		ps.setString(3, pr.getMailId());
		ps.setString(4, pr.getPhoneNo());
		ps.setInt(5, pr.getMobileId());
		
		int rowcount = ps.executeUpdate();
		if(rowcount==1)


			return id;
		return 0;
	}

	@Override
	public ArrayList<Mobile> getMobileList() throws SQLException {
		
		ArrayList<Mobile> list = new ArrayList<Mobile>();
		
 
		String sql = "select mobileid, name, price, quantity from mobiles";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		try {
			while(rs.next()){
				Mobile mob = new Mobile();
				mob.setMobileId(rs.getInt("mobileid"));
				mob.setName(rs.getString("name"));
				mob.setPrice(rs.getDouble("price"));
				mob.setQuantity(rs.getInt("quantity"));
			
				list.add(mob);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		

	}

	@Override
	public ArrayList<Mobile> getMobileListbtw(int min, int max) throws SQLException {
		
		ArrayList<Mobile> listbtw = new ArrayList<Mobile>();
		String sql = "select mobileid, name, price, quantity from mobiles where price between "+ min + " and "+ max;
		
		Statement stmt= conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);
		
		while(rs.next()){
			Mobile mob = new Mobile();
			mob.setMobileId(rs.getInt("mobileid"));
			mob.setName(rs.getString("name"));
			mob.setPrice(rs.getDouble("price"));
			mob.setQuantity(rs.getInt("quantity"));
		
			listbtw.add(mob);
		}
		
		return listbtw;
	}

	@Override
	public Mobile updateMobileDetails(Mobile mob) throws SQLException {
		
String sql= "update mobiles SET price = ? , quantity = ? where mobileid = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1, mob.getPrice());
		ps.setInt(2, mob.getQuantity());
		ps.setInt(3, mob.getMobileId());
		
		int rowcount = ps.executeUpdate();
		if(rowcount==0){
			System.err.println("Mobile ID is invalid !");
			
		}
return mob;

			
	}

}
