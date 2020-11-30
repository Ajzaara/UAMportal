package com.nokia.application.ossuamws.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.application.ossuamws.model.Request.NodesRequest;
import com.nokia.application.ossuamws.model.entity.Nodes;
import com.nokia.application.ossuamws.repository.NodesRepository;
import com.nokia.application.ossuamws.service.NodesService;
import com.nokia.application.ossuamws.shared.Dto.NodesDto;
import com.nokia.application.ossuamws.shared.utility.ResponseCode;
import com.nokia.application.ossuamws.shared.utility.Utils;

@Service
public class NodesServiceImpl implements NodesService {

	@Autowired	private NodesRepository nodesRepository;

	@Autowired	Utils utils;

	@Override
	public List<Nodes> getAllNodes() {
		return nodesRepository.findAll();
	}
//
//	@Override
//	public ResponseCode checkNodePresent(String nodeName) {
//		ResponseCode respCode = new ResponseCode();
//		Nodes getNodeFromDB = nodesRepository.findByNodeName(nodeName);
//		if (getNodeFromDB != null) 
//		{
//			respCode.setResponseCode(1);
//			respCode.setMessage("Node already exists");
//			respCode.setTimestamp(utils.getCurrentLocalDateTime());
//		} 
//		else 
//		{
//			respCode.setResponseCode(0);
//			respCode.setMessage("Node created");
//			respCode.setTimestamp(utils.getCurrentLocalDateTime());
//		}
//		return respCode;
//	}
//
//	@Override
//	public Nodes checkNodeIsPresent(String nodeName) {
//		Nodes getNodeFromDB = nodesRepository.findByNodeName(nodeName);
//		return getNodeFromDB;
//	}

	@Override
	public NodesDto createNode(NodesDto nodeDto) {
		Nodes nodesEntity = new Nodes();
		NodesDto nodesResponse = new NodesDto();

		BeanUtils.copyProperties(nodeDto, nodesEntity);
		nodesEntity.setIsActive(1);

		Nodes saveNodesDetails = nodesRepository.save(nodesEntity);

		BeanUtils.copyProperties(saveNodesDetails, nodesResponse);

		return nodesResponse;
	}

	@Override
	public NodesDto updateNode(Nodes node, NodesRequest nodeReq) {
		NodesDto nodesDto = new NodesDto();

		node.setNodeName(nodeReq.getNodeName());

		Nodes updateNodesDetails = nodesRepository.save(node);

		BeanUtils.copyProperties(updateNodesDetails, nodesDto);

		return nodesDto;
	}

	@Override
	public ResponseCode deleteNode(Integer id) {
		return null;
	}

}
