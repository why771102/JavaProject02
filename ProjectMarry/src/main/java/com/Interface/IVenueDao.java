package com.Interface;

import java.util.List;

import com.Bean.VenueBean;

public interface IVenueDao {
	public List<VenueBean> showVenueList();

	public VenueBean VenueDetail(VenueBean vb);
	
	public String VenueName(VenueBean vb);


}
