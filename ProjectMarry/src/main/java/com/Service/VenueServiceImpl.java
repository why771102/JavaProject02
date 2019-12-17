package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Bean.VenueBean;
import com.Dao.VenueDaoImpl;
import com.Interface.IVenueDao;

public class VenueServiceImpl implements VenueService {
	
	private IVenueDao vo;
	Connection conn;
	
	public VenueServiceImpl(Connection conn) {
		vo = new VenueDaoImpl(conn);
		this.conn = conn;
	}

	@Override
	public List<VenueBean> showVenueList() {
		
		return vo.showVenueList();
	}

	@Override
	public VenueBean VenueDetail(VenueBean vb) {
		
		return vo.VenueDetail(vb);
	}
	
}
