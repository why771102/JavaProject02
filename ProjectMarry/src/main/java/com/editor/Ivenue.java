package com.editor;

import java.util.List;

public interface Ivenue {
public JavaBean queryVenue(String productid);
public List<JavaBean> queryallVenue();
public JavaBean addVenue(String vendorid,String productid,String location,String hall,String tablecount,String inoutdoor,String lunchprice,String dinnerprice,
		String venuestatus,String venuedesc);
public JavaBean updateVenue(String vendorid,String productid,String location,String hall,String tablecount,String inoutdoor,String lunchprice,String dinnerprice,
		String venuestatus,String venuedesc);
public JavaBean deleteVenue(String productid);
public void init();
}
