package com.cg.pd.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.pd.dto.Mobile;
import com.cg.pd.dto.PurchaseDetails;

public interface PurchaseDAO {
	
	public int addPurchaseDetails(PurchaseDetails pr) throws SQLException;
	
	public ArrayList<Mobile> getMobileList() throws SQLException;
	
	public ArrayList<Mobile> getMobileListbtw(int min, int max) throws SQLException;
	
	public Mobile updateMobileDetails(Mobile mob) throws SQLException;

}
