package com.nokia.application.ossuamws.service;

import java.util.List;

import com.nokia.application.ossuamws.model.Request.NodesRequest;
import com.nokia.application.ossuamws.model.entity.Nodes;
import com.nokia.application.ossuamws.shared.Dto.NodesDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;

public interface NodesService {

	List<Nodes> getAllNodes();

//	ResponseCode checkNodePresent(String nodeName);
//
//	Nodes checkNodeIsPresent(String nodeName);
	
	NodesDto createNode(NodesDto nodeDto);

	NodesDto updateNode(Nodes node, NodesRequest nodeReq);

	ResponseCode deleteNode(Integer id);

	
	}