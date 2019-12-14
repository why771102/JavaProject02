package com.editor;

import java.util.List;

public interface Ivenue {
public JavaBean queryVenue(String productid);
public List<JavaBean> queryallVenue();
public JavaBean  addVenue(String vendorid,String venueaddress,String hall,String tables,String inoutdoor,String lunchprice,String dinnerprice);
public JavaBean updateVenue(String vendorid,String productid,String venueaddress,String hall,String tables,String inoutdoor,String lunchprice,String dinnerprice);
public JavaBean deleteVenue(String productid);
public void init();
}
