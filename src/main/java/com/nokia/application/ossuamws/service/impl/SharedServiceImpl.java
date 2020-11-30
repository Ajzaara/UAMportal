package com.nokia.application.ossuamws.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.entity.Circles;
import com.nokia.application.ossuamws.model.entity.Operator;
import com.nokia.application.ossuamws.model.entity.Vendor;
import com.nokia.application.ossuamws.repository.CirclesRepository;
import com.nokia.application.ossuamws.repository.OperatorRepository;
import com.nokia.application.ossuamws.repository.VendorRepository;
import com.nokia.application.ossuamws.service.SharedService;

@Service
public class SharedServiceImpl implements SharedService {

	@Autowired	private OperatorRepository operatorRepository;
	
	@Autowired	private VendorRepository vendorRepository;
	
	@Autowired	private CirclesRepository circlesRepository;
	
	@Override
	public List<Operator> getAllOps() {
		return operatorRepository.findAll();
	}

	@Override
	public List<Vendor> getAllVen() {
		return vendorRepository.findAll();
	}

	@Override
	public List<Circles> getAllCir() {
		return circlesRepository.findAll();
	}

	@Override
	public List<Vendor> findVendorByOperatorId(Integer opsId) {
		return vendorRepository.findVendorByoperatorId(opsId);
		
	}

	@Override
	public List<Circles> findCircleByVendorId(Integer id) {
		return circlesRepository.findByvendorId(id);
	}

	@Override
	public HashSet<Circles> getDataBycircleId(Set<Circles> circleId) {
		
		HashSet<Circles> circleDatas=new HashSet<Circles>();
		
		Iterator<Circles> value = circleId.iterator(); 
		 while (value.hasNext()) { 
	         System.out.println(value.next().toString()); 
	         
//	         for (Circles value : circleId) {
//	             System.out.println(value.toString());
	         
	       
System.out.println(".............................SharedServiceImpl.getDataBycircleId()"+value.next());

//				boolean b=circleId.iterator().hasNext();
//					circleId.contains(circleId)
//					
				Circles a = value.next();
				
			if(a!=null) {
	         Circles circleData=circlesRepository.findBycircleId(a.getCircleId());
	         System.out.println(".................."+circleData);
	         circleDatas.add(circleData);
				
	     } 
				else {
					value.next();
				}
		 }
		return circleDatas;
	}
}

//try implementing the same using hashmap instead hashset
