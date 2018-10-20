package com.cg.pd.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pd.dto.Mobile;
import com.cg.pd.dto.PurchaseDetails;
import com.cg.pd.service.PurchaseService;
import com.cg.pd.service.PurchaseServiceImpl;


public class Client {
	
	public static void main(String[] args) throws SQLException {
		
		PurchaseService service = new PurchaseServiceImpl();

		Scanner s = new Scanner(System.in);
		int ch= 0;
		
		do{
		
		System.out.println(" 1. Add Purchase Details ");
		System.out.println(" 2. Display list of mobiles ");
		System.out.println(" 3. Display Mobile List based on price range ");
		System.out.println(" 4. Update Table MOBILES using MobileId  ");
		System.out.println("Enter your choice : ");
		ch = s.nextInt();
		switch (ch) {
		
		
		case 1:
			System.out.println("Enter Customer Name : ");
			String name = s.next();
			System.out.println("Enter Phone No : ");
			String phoneNo = s.next();
			System.out.println("Enter Mail ID : ");
			String mailId = s.next();
			System.out.println("Enter Mobile ID : ");
			int mobileId = s.nextInt();
			
			PurchaseDetails pd = new PurchaseDetails();
			pd.setCustName(name);
			pd.setPhoneNo(phoneNo);
			pd.setMailId(mailId);
			pd.setMobileId(mobileId);
			int pid = service.addPurchaseDetails(pd);
			System.out.println("Purchase id is "+pid);
		break;
		
		case 2: 
			ArrayList<Mobile> list = service.getMobileList();
			if(list.size()==0){
				
				System.out.println("No record found !!");
				
			}
			else 
				for(Mobile mob : list){
					System.out.println(mob.getMobileId()+" ");
					System.out.println(mob.getName()+" ");
					System.out.println(mob.getPrice()+" ");
					System.out.println(mob.getQuantity()+" ");
				}
			break;
		case 3: 
			System.out.println("Enter the minimum range");
			int min = s.nextInt();
			System.out.println("Enter the maximum range");
			int max= s.nextInt();
			
			ArrayList<Mobile> listbtw = service.getMobileListbtw(min, max);
			
			if(listbtw.size()==0){
				System.out.println("No record found within this range !!");
				
			}
			else{
				for(Mobile mob : listbtw){
					System.out.println(mob.getMobileId()+" ");
					System.out.println(mob.getName()+" ");
					System.out.println(mob.getPrice()+" ");
					System.out.println(mob.getQuantity()+" ");
				
			}
			
			
			
	}
			break;
		case 4:
			System.out.println("Enter MobileId to be updated : ");
			int mobId = s.nextInt();
			System.out.println("Enter new Price : ");
			int price = s.nextInt();
			System.out.println("Enter new Quantity : ");
			int quantity = s.nextInt();
			
			Mobile mobl = new Mobile();
			mobl.setMobileId(mobId);
			mobl.setPrice(price);
			mobl.setQuantity(quantity);
			
			mobl = service.updateMobileDetails(mobl);
			if(mobl!=null)
				System.out.println("Mobile Details Updated Successfully !!");
			
			break;

}
		}while(ch!=5);
	}
}