package com.nokia.application.ossuamws.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nokia.application.ossuamws.model.entity.Circles;
import com.nokia.application.ossuamws.model.entity.Operator;
import com.nokia.application.ossuamws.model.entity.Vendor;

public interface SharedService {

	List<Operator> getAllOps();

	List<Vendor> getAllVen();

	List<Circles> getAllCir();

	List<Circles> findCircleByVendorId(Integer id);
	
	List<Vendor> findVendorByOperatorId(Integer id);

	HashSet<Circles> getDataBycircleId(Set<Circles> circleId);

}
