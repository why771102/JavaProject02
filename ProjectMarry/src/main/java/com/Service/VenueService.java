package com.Service;

import java.util.List;

import com.Bean.VenueBean;

public interface VenueService {
	
	public List<VenueBean> showVenueList();

	public VenueBean VenueDetail(VenueBean vb);
	
	public String VenueName(VenueBean vb);
}
