//package com.nokia.application.ossuamws.service.impl;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.nokia.application.ossuamws.model.Request.EmployeeRequest;
//import com.nokia.application.ossuamws.model.entity.Employee;
//import com.nokia.application.ossuamws.repository.EmployeeRepository;
//import com.nokia.application.ossuamws.service.EmployeeService;
//import com.nokia.application.ossuamws.shared.Dto.EmployeeDto;
//import com.nokia.application.ossuamws.shared.businessException.RecordNotFoundException;
//import com.nokia.application.ossuamws.shared.utility.ResponseCode;
//import com.nokia.application.ossuamws.shared.utility.Utils;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//	@Autowired	private EmployeeRepository employeeRepository;
//	
//	@Autowired	Utils utils;
//	
//	@Override
//	public Employee searchById(Integer id) throws RecordNotFoundException {
//		Optional<Employee> result = employeeRepository.findById(id);
//		 if(result.isPresent()) {
//	            return result.get();
//	        } 
//		 else 
//		 	{
//	            throw new RecordNotFoundException("No employee record exist for given id");
//	        }
//	}
//
//
//	@Override
//	public ResponseCode findByempId(String empId) {
//		ResponseCode respCode=new ResponseCode();
//		
//		Optional<Employee> getEmpFromDB = employeeRepository.findByempId(empId);
//		if (getEmpFromDB.isPresent()) {
//			respCode.setResponseCode(1);
//			respCode.setMessage("Employee already exists");
//			respCode.setTimestamp(utils.getCurrentLocalDateTime());
//			respCode.setObj(getEmpFromDB);
//		} 
//		else 
//		{
//			respCode.setResponseCode(0);
//			respCode.setMessage("Employee doesn't exists");
//			respCode.setTimestamp(utils.getCurrentLocalDateTime());
//			respCode.setObj(getEmpFromDB);
//		}
//		return respCode;
//	}
//	
//	@Override
//	public Employee getByEmpId(String empId) throws RecordNotFoundException {
//		Optional<Employee> getEmpFromDB = employeeRepository.findByempId(empId);
//		 if(getEmpFromDB.isPresent()) {
//	            return getEmpFromDB.get();
//	        } 
//		 else 
//	        {
//	            throw new RecordNotFoundException("No employee record exist for given id");
//	        }
//	}
//
//	@Override
//	public ResponseCode deleteEmp(Integer id) {
//		ResponseCode respCode = new ResponseCode();
//		
//		Optional<Employee> getEmpIdFromDB = employeeRepository.findById(id);
//		if (!getEmpIdFromDB.isPresent()) 
//		{
//			respCode.setResponseCode(0);
//			respCode.setMessage("employee not found");
//			respCode.setTimestamp(utils.getCurrentLocalDateTime());
//			respCode.setAction("employee deletion failed");
//		} else 
//		{
//			Integer status=getEmpIdFromDB.get().getIsActive();
//			if(status==1) 
//			{	
//				int s=0;
//				LocalDateTime deletedTs=utils.getCurrentLocalDateTime();
//				Integer delEmp= employeeRepository.softDelete(s,deletedTs,id);
//				
//				if(delEmp!=0)
//				{
//					respCode.setMessage("employee deleted successfully");
//					respCode.setAction("employee deactivated ");
//					respCode.setResponseCode(1);
//					respCode.setTimestamp(utils.getCurrentLocalDateTime());
//				}
//			}
//			else
//				{
//					respCode.setResponseCode(0);
//					respCode.setMessage("employee already inactive");
//					respCode.setTimestamp(utils.getCurrentLocalDateTime());
//					respCode.setAction("employee deletion failed ");
//			
//				}
//			}
//	
//		return respCode;
//	}
//
//	@Override
//	public EmployeeDto saveEmpDetails(EmployeeDto empDto,MultipartFile file) throws IOException {
//		
//		
//		String loginId = utils.generateLoginId();
//		
//			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//			System.out.println("fileName" + fileName);
//			Employee empEntity = new Employee();
//			BeanUtils.copyProperties(empDto, empEntity);
//			//utils.getExtensionByStringHandling(file);
//			empEntity.setUploadForm(file.getBytes());
//			empEntity.setUploadFormName(fileName);
//			empEntity.setUploadFormType(file.getContentType());
//			empEntity.setLoginId(loginId);
//			//empEntity.setCreatedBy("Anjali");
//			empEntity.setUploadFormName(file.getName());
//			empEntity.setIsActive(1);
//			//empEntity.setModifiedBy("Anjali");
//			empEntity.setExpiryDate(utils.getExpiryDate());
//			
//			Employee saveEmpDetails = employeeRepository.save(empEntity);
//
//			EmployeeDto employeeDto = new EmployeeDto();
//			BeanUtils.copyProperties(saveEmpDetails, employeeDto);
//			
//			return employeeDto;
//	 }
////	
////	public static <T> Set<T> convertListToSet(List<T> list) 
////    { 
////        // create a set from the List 
////        return list.stream().collect(Collectors.toSet()); 
////    }
//
////
////	@Override
////	public Employee findById(Integer id) throws RecordNotFoundException {
////		Optional<Employee> empById = employeeRepository.findById(id);
////		 if(empById.isPresent()) {
////	            return empById.get();
////	        } else {
////	            throw new RecordNotFoundException("No employee record exist for given id");
////	        }
////	}
//
//
//	@Override
//	public Object save(EmployeeRequest empReq) {
//		empReq.setModifyTimestamp(utils.getCurrentLocalDateTime());
//		return employeeRepository.save(empReq);
//		
//	}
//	
//	public Employee getFile(Integer id) throws RecordNotFoundException {
//		Optional<Employee> empFileById = employeeRepository.findById(id);
//		 if(empFileById.isPresent()) {
//	            return empFileById.get();
//	        } 
//		 else 
//	        {
//	            throw new RecordNotFoundException("No file exist for given id");
//	        }
//	  }
//
//
//}
