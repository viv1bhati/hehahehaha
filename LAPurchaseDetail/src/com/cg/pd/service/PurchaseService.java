package com.cg.pd.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.pd.dto.Mobile;
import com.cg.pd.dto.PurchaseDetails;
import com.cg.pd.exception.PurchaseException;

public interface PurchaseService {

public int addPurchaseDetails(PurchaseDetails pr);
	
	public ArrayList<Mobile> getMobileList() throws SQLException;
	
	public ArrayList<Mobile> getMobileListbtw(int min, int max) throws SQLException;
	
	public Mobile updateMobileDetails(Mobile mob) throws SQLException;
	
	
}
