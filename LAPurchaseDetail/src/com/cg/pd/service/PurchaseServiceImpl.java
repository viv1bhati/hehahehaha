package com.cg.pd.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.pd.dao.PurchaseDAO;
import com.cg.pd.dao.PurchaseDAOImpl;
import com.cg.pd.dto.Mobile;
import com.cg.pd.dto.PurchaseDetails;
import com.cg.pd.exception.PurchaseException;

public class PurchaseServiceImpl implements PurchaseService {

	
	PurchaseDAO dao;
	public PurchaseServiceImpl(){
		try {
			dao = new PurchaseDAOImpl();
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public int addPurchaseDetails(PurchaseDetails pr){
		
		try {
			return dao.addPurchaseDetails(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Mobile> getMobileList() throws SQLException {
		
		return dao.getMobileList();
		
	}

	@Override
	public ArrayList<Mobile> getMobileListbtw(int min, int max) throws SQLException {
		
		return dao.getMobileListbtw(min, max);
	}

	@Override
	public Mobile updateMobileDetails(Mobile mob) throws SQLException {
		return dao.updateMobileDetails(mob);
	}


	
}
