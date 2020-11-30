//package com.nokia.application.ossuamws.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.Produces;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.nokia.application.ossuamws.model.Request.CompanyRequest;
//import com.nokia.application.ossuamws.model.Request.DepartmentRequest;
//import com.nokia.application.ossuamws.model.Request.DomainManagerRequest;
//import com.nokia.application.ossuamws.model.Request.DomainRequest;
//import com.nokia.application.ossuamws.model.Request.EmployeeRequest;
//import com.nokia.application.ossuamws.model.Request.ManagerRequest;
//import com.nokia.application.ossuamws.model.Request.NodesRequest;
//import com.nokia.application.ossuamws.model.Request.UserRequest;
//import com.nokia.application.ossuamws.model.Response.CompanyResponse;
//import com.nokia.application.ossuamws.model.Response.DepartmentResponse;
//import com.nokia.application.ossuamws.model.Response.DomainManagerResponse;
//import com.nokia.application.ossuamws.model.Response.DomainResponse;
//import com.nokia.application.ossuamws.model.Response.EmployeeResponse;
//import com.nokia.application.ossuamws.model.Response.ManagerResponse;
//import com.nokia.application.ossuamws.model.Response.NodesResponse;
//import com.nokia.application.ossuamws.model.Response.UserResponse;
//import com.nokia.application.ossuamws.model.entity.Circles;
//import com.nokia.application.ossuamws.model.entity.Company;
//import com.nokia.application.ossuamws.model.entity.Department;
//import com.nokia.application.ossuamws.model.entity.Domain;
//import com.nokia.application.ossuamws.model.entity.DomainManager;
//import com.nokia.application.ossuamws.model.entity.Employee;
//import com.nokia.application.ossuamws.model.entity.Manager;
//import com.nokia.application.ossuamws.model.entity.Nodes;
//import com.nokia.application.ossuamws.model.entity.Operator;
//import com.nokia.application.ossuamws.model.entity.User;
//import com.nokia.application.ossuamws.model.entity.Vendor;
//import com.nokia.application.ossuamws.service.CompanyService;
//import com.nokia.application.ossuamws.service.DepartmentService;
//import com.nokia.application.ossuamws.service.DomainManagerService;
//import com.nokia.application.ossuamws.service.DomainService;
//import com.nokia.application.ossuamws.service.EmployeeService;
//import com.nokia.application.ossuamws.service.ManagerService;
//import com.nokia.application.ossuamws.service.NodesService;
//import com.nokia.application.ossuamws.service.SharedService;
//import com.nokia.application.ossuamws.service.UserService;
//import com.nokia.application.ossuamws.shared.Dto.CompanyDto;
//import com.nokia.application.ossuamws.shared.Dto.DepartmentDto;
//import com.nokia.application.ossuamws.shared.Dto.DomainDto;
//import com.nokia.application.ossuamws.shared.Dto.DomainManagerDto;
//import com.nokia.application.ossuamws.shared.Dto.EmployeeDto;
//import com.nokia.application.ossuamws.shared.Dto.ManagerDto;
//import com.nokia.application.ossuamws.shared.Dto.NodesDto;
//import com.nokia.application.ossuamws.shared.Dto.UserDto;
//import com.nokia.application.ossuamws.shared.businessException.RecordNotFoundException;
//import com.nokia.application.ossuamws.shared.utility.ResponseCode;
//import com.nokia.application.ossuamws.shared.utility.Utils;
//
//@CrossOrigin(origins ="*")
//@RestController
//@RequestMapping("/oss/uam")
//public class AppController {
//
//	@Autowired private UserService userservice;
//	@Autowired private EmployeeService employeeService;
//	@Autowired private SharedService sharedService;
//	@Autowired private DepartmentService departmentService;
//	@Autowired private DomainService domainService;
//	@Autowired private ManagerService managerService;
//	@Autowired private DomainManagerService domainManagerService;
//	@Autowired private NodesService nodesService;
//	@Autowired private CompanyService companyService;
//	@Autowired Utils utils;
//	
//	@RequestMapping("/")
//	public String hello() {
//		return "Welcome to UAM portal !";
//	}
//
//	@GetMapping("/checkUserName/{username}")
//	public ResponseCode checkForUserName(@PathVariable String username) {
//		ResponseCode res = new ResponseCode();
//		res = userservice.findByUserName(username);
//
//		return res;
//	}
//
//	@PostMapping("/createUser")
//	@Consumes(value = "application/json")
//	@Produces(value="application/json")
//	public ResponseCode createUser(@RequestBody UserRequest userReq) {
//
//		System.out.println("****1 AppController.createUser()"+ userReq.getUserName());
//		
//		UserDto userDto = new UserDto();
//		UserResponse response = new UserResponse();
//		ResponseCode resp = new ResponseCode();
//		
//		System.out.println("****2 AppController.createUser()"+ userReq.getUserName());
//		
//		resp = checkForUserName(userReq.getUserName());
//
//		if (resp.getResponseCode() == 1) {
//			resp.setAction("user not created");
//			return resp;
//		} else {
//			BeanUtils.copyProperties(userReq, userDto);
//
//			UserDto createUser = userservice.createUser(userDto);
//
//			BeanUtils.copyProperties(createUser, response);
//			System.out.println("****3 AppController.createUser()"+ userReq.getUserName());
//			resp.setAction("user created successfully");
//			resp.setObj(response);
//			return resp;
//		}
//
//	}
//
//	@PostMapping("/createEmployee")
//	@Produces("application/json")
//	public ResponseEntity<ResponseCode> createEmployee(@RequestPart EmployeeRequest empReq,
//			@RequestPart("file") MultipartFile file) throws IOException, RecordNotFoundException {
//		EmployeeDto empDto = new EmployeeDto();
//		EmployeeResponse response = new EmployeeResponse();
//
//		ResponseCode res = new ResponseCode();
//		res = employeeService.findByempId(empReq.getEmpId());
//
//		if (res.getResponseCode() == 1) {
//			res.setAction("Employee already exists");
//			return ResponseEntity.status(HttpStatus.OK).body(res);
//		} else {
//			BeanUtils.copyProperties(empReq, empDto);
//			EmployeeDto empResDto = employeeService.saveEmpDetails(empDto, file);
////			Optional<Employee> empList= employeeService.searchById(empResDto.getId());
////			Set<Circles> circles=empList.get().getCircleId();
////			
//			BeanUtils.copyProperties(empResDto, response);
//
//			res.setAction("Employee details saved successfully");
//			res.setObj(response);
//			return ResponseEntity.status(HttpStatus.OK).body(res);
//		}
//
//	}
//
//	@PostMapping("/createMgr")
//	public ResponseCode createManager(@RequestBody ManagerRequest mgrReq)  {
//
//		ResponseCode resp = new ResponseCode();
//		ManagerDto mgrDto=new ManagerDto();
//		ManagerResponse response = new ManagerResponse();
//
//		resp = managerService.checkMgrpresent(mgrReq.getName());
//
//		if (resp.getResponseCode() != 1) 
//		{
//			BeanUtils.copyProperties(mgrReq, mgrDto);
//			ManagerDto createMgr = managerService.createMgr(mgrDto);
//			BeanUtils.copyProperties(createMgr, response);
//			resp.setAction("manager added successfully");
//			resp.setObj(response);
//			return resp;
//		}
//		else
//		{
//			resp.setAction("manager not created");
//			return resp;
//		}
//		
//	}
//	
//	@PostMapping("/createDomMgr")
//	public ResponseCode createDomainManager(@RequestBody DomainManagerRequest domMgrReq)  {
//
//		ResponseCode resp = new ResponseCode();
//		DomainManagerDto domMgrDto=new DomainManagerDto();
//		DomainManagerResponse response = new DomainManagerResponse();
//
//		resp = domainManagerService.checkDomMgrpresent(domMgrReq.getMailId());
//
//		if (resp.getResponseCode() != 1) 
//		{
//			BeanUtils.copyProperties(domMgrReq, domMgrDto);
//			DomainManagerDto createDomMgr = domainManagerService.createDomMgr(domMgrDto);
//			BeanUtils.copyProperties(createDomMgr, response);
//			resp.setAction("DomainManager added successfully");
//			resp.setObj(response);
//			return resp;
//		}
//		else
//		{
//			resp.setAction("DomainManager not created");
//			return resp;
//		}
//		
//	}
//	
//	
//	@PostMapping("/createDept")
//	public ResponseCode createDepartment(@RequestBody DepartmentRequest deptReq)  {
//
//		ResponseCode resp = new ResponseCode();
//		DepartmentDto deptDto=new DepartmentDto();
//		DepartmentResponse response = new DepartmentResponse();
//
//		resp = departmentService.checkDeptpresent(deptReq.getDeptName());
//
//		if (resp.getResponseCode() != 1) 
//		{
//			BeanUtils.copyProperties(deptReq, deptDto);
//			DepartmentDto createDept = departmentService.createDept(deptDto);
//			BeanUtils.copyProperties(createDept, response);
//			resp.setAction("Department added successfully");
//			resp.setObj(response);
//			return resp;
//		}
//		else
//		{
//			resp.setAction("Department not created");
//			return resp;
//		}
//		
//	}
//	
//	@PostMapping("/createCompany")
//	public ResponseCode createCompany(@RequestBody CompanyRequest compReq)  {
//
//		ResponseCode resp = new ResponseCode();
//		CompanyDto companyDto=new CompanyDto();
//		CompanyResponse response = new CompanyResponse();
//
//		resp = companyService.checkCompanypresent(compReq.getCompanyName());
//
//		if (resp.getResponseCode() != 1) 
//		{
//			BeanUtils.copyProperties(compReq, companyDto);
//			CompanyDto createDept = companyService.createCompany(companyDto);
//			BeanUtils.copyProperties(createDept, response);
//			resp.setAction("Company added successfully");
//			resp.setObj(response);
//			return resp;
//		}
//		else
//		{
//			resp.setAction("Company not created");
//			return resp;
//		}
//		
//	}
//	
//	
//	
//	@PostMapping("/createDomain")
//	public ResponseCode createDomain(@RequestBody DomainRequest domReq)  {
//
//		ResponseCode resp = new ResponseCode();
//		DomainDto domDto=new DomainDto();
//		DomainResponse response = new DomainResponse();
//
//		resp = domainService.checkDompresent(domReq.getDomainName());
//
//		if (resp.getResponseCode() != 1) 
//		{
//			BeanUtils.copyProperties(domReq, domDto);
//			DomainDto createDom = domainService.createDom(domDto);
//			BeanUtils.copyProperties(createDom, response);
//			resp.setAction("Domain added successfully");
//			resp.setObj(response);
//			return resp;
//		}
//		else
//		{
//			resp.setAction("Domain not created");
//			return resp;
//		}
//		
//	}
//	
////	@PostMapping("/createNode")
////	public ResponseCode createNode(@RequestBody NodesRequest nodeReq)  {
////
////		ResponseCode resp = new ResponseCode();
////		NodesDto nodeDto=new NodesDto();
////		NodesResponse response = new NodesResponse();
////
////		resp = nodesService.checkNodePresent(nodeReq.getNodeName());
////
////		if (resp.getResponseCode() != 1) 
////		{
////			BeanUtils.copyProperties(nodeReq, nodeDto);
////			NodesDto createNode = nodesService.createNode(nodeDto);
////			BeanUtils.copyProperties(createNode, response);
////			resp.setAction("Node added successfully");
////			resp.setObj(response);
////			return resp;
////		}
////		else
////		{
////			resp.setAction("Node not created");
////			return resp;
////		}
////	}
//	
////	@PutMapping("/updateNodes")
////	  public ResponseCode updateNode(@RequestBody NodesRequest nodeReq){
////		  	ResponseCode resp = new ResponseCode();
////			
////		  	Nodes node = nodesService.checkNodeIsPresent(nodeReq.getNodeName());
////			if(node != null) 
////			{
////				NodesDto updateNode = nodesService.updateNode(node,nodeReq);
////				resp.setAction("Node updated successfully");
////				resp.setResponseCode(1);
////				resp.setMessage("Node exists");
////				resp.setTimestamp(utils.getCurrentLocalDateTime());
////				resp.setObj(updateNode);
////				return resp;
////			}
////			
////		else
////		{
////			resp.setResponseCode(0);
////			resp.setMessage("Node doesn't exists");
////			resp.setTimestamp(utils.getCurrentLocalDateTime());
////			resp.setAction("Node not updated");
////			resp.setObj(node);
////			return resp;
////		}
////	  }
//	
//	@PutMapping("/updateUser")
//	public ResponseCode updateUser(@RequestBody UserRequest userReq) throws RecordNotFoundException {
//		ResponseCode resp = new ResponseCode();
//
//		User user = userservice.checkUserIspresent(userReq.getUserName());
//		if (user != null) {
//			UserDto updateUser = userservice.updateUser(user, userReq);
//			resp.setAction("User updated successfully");
//			resp.setResponseCode(1);
//			resp.setMessage("User exists");
//			resp.setTimestamp(utils.getCurrentLocalDateTime());
//			resp.setObj(updateUser);
//			return resp;
//		}
//
//		else {
//			resp.setResponseCode(0);
//			resp.setMessage("User doesn't exists");
//			resp.setTimestamp(utils.getCurrentLocalDateTime());
//			resp.setAction("User not updated");
//			resp.setObj(user);
//			return resp;
//		}
//	}
//	
//	  @PutMapping("/updateMgr")
//		public ResponseCode updateManager(@RequestBody Manager mgrReq) throws RecordNotFoundException {
//
//			ResponseCode resp = new ResponseCode();
//
//			Manager man = managerService.checkMgrIspresent(mgrReq.getName());
//
//			if (man != null) {
//				ManagerDto updateMgr = managerService.updateMgr(man, mgrReq);
//				resp.setAction("manager updated successfully");
//				resp.setResponseCode(1);
//				resp.setMessage("Manager exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setObj(updateMgr);
//				return resp;
//			}
//
//			else {
//				resp.setResponseCode(0);
//				resp.setMessage("Manager doesn't exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setAction("manager not updated");
//				resp.setObj(man);
//				return resp;
//			}
//		}
//	  
//	  @PutMapping("/updateDomMgr")
//		public ResponseCode updateDomainManager(@RequestBody DomainManagerRequest domMgrReq) {
//
//			ResponseCode resp = new ResponseCode();
//
//			DomainManager man = domainManagerService.checkDomMgrIspresent(domMgrReq.getMailId());
//
//			if (man != null) {
//				DomainManagerDto updateMgr = domainManagerService.updateDomMgr(man, domMgrReq);
//				resp.setAction("DomainManager updated successfully");
//				resp.setResponseCode(1);
//				resp.setMessage("DomainManager exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setObj(updateMgr);
//				return resp;
//			}
//
//			else {
//				resp.setResponseCode(0);
//				resp.setMessage("DomainManager doesn't exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setAction("DomainManager not updated");
//				resp.setObj(man);
//				return resp;
//			}
//		}
//	  
//	  @PutMapping("/updateDept")
//		public ResponseCode updateDepartment(@RequestBody DepartmentRequest deptReq) {
//			ResponseCode resp = new ResponseCode();
//
//			Department dept = departmentService.checkDeptIsPresent(deptReq.getDeptId());
//			if (dept != null) {
//				DepartmentDto updatedept = departmentService.updatedept(dept, deptReq);
//				resp.setAction("Department updated successfully");
//				resp.setResponseCode(1);
//				resp.setMessage("Department exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setObj(updatedept);
//				return resp;
//			}
//
//			else {
//				resp.setResponseCode(0);
//				resp.setMessage("Department doesn't exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setAction("Department not updated");
//				resp.setObj(dept);
//				return resp;
//			}
//		}
//	  
//	  @PutMapping("/updateDomain")
//		public ResponseCode updateDomain(@RequestBody DomainRequest domReq) {
//			ResponseCode resp = new ResponseCode();
//
//			Domain domain = domainService.checkDomainIsPresent(domReq.getDomainId());
//			if (domain != null) {
//				DomainDto updateDomain = domainService.updateDomain(domain, domReq);
//				resp.setAction("Domain updated successfully");
//				resp.setResponseCode(1);
//				resp.setMessage("Domain exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setObj(updateDomain);
//				return resp;
//			}
//
//			else {
//				resp.setResponseCode(0);
//				resp.setMessage("Domain doesn't exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setAction("Domain not updated");
//				resp.setObj(domain);
//				return resp;
//			}
//		}
//	  
//	  @PutMapping("/updateCompany")
//		public ResponseCode updateCompany(@RequestBody CompanyRequest compReq) {
//			ResponseCode resp = new ResponseCode();
//
//			Company comp = companyService.checkCompIsPresent(compReq.getCompanyId());
//			if (comp != null) {
//				CompanyDto updateCompany = companyService.updateCompany(comp, compReq);
//				resp.setAction("Company updated successfully");
//				resp.setResponseCode(1);
//				resp.setMessage("Company exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setObj(updateCompany);
//				return resp;
//			}
//
//			else {
//				resp.setResponseCode(0);
//				resp.setMessage("Company doesn't exists");
//				resp.setTimestamp(utils.getCurrentLocalDateTime());
//				resp.setAction("Company not updated");
//				resp.setObj(comp);
//				return resp;
//			}
//		}
//	  
//	  @GetMapping("/listAllUser")
//		public ResponseEntity<List<User>> getAllUsers() {
//			List<User> userList = userservice.getAllUsers();
//			if (userList.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//		      return new ResponseEntity<>(userList, HttpStatus.OK);
//		}
//		
//		@GetMapping("/listAllActiveUser")
//		public ResponseEntity<List<User>> getAllActiveUsers() {
//			List<User> activeUserList = userservice.getAllActiveUsers();
//			if (activeUserList.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//		      return new ResponseEntity<>(activeUserList, HttpStatus.OK);
//		}
//	  
//
//	@GetMapping("/download/{id}")
//	public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) throws RecordNotFoundException {
//		Employee result = employeeService.searchById(id);
//
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + result.getUploadFormName() + "\"")
//				.body(result.getUploadForm());
//	}
//
//	@GetMapping("/listAllDomains")
//	public ResponseEntity<List<Domain>> getAllDomain() {
//		List<Domain> domList = domainService.getAllDom();
//
//		if (domList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(domList, HttpStatus.OK);
//	}
//	
//	@GetMapping("/listAllCompany")
//	public ResponseEntity<List<Company>> getAllCompany() {
//		List<Company> compList = companyService.getAllComp();
//
//		if (compList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(compList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllDepts")
//	public ResponseEntity<List<Department>> getAllDepartments() {
//		List<Department> deptList = departmentService.getAllDept();
//		if (deptList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(deptList, HttpStatus.OK);
//	}
//	
//
//	@GetMapping("/listAllNodes")
//	public ResponseEntity<List<Nodes>> getAllNodes() {
//		List<Nodes> nodeList = nodesService.getAllNodes();
//		if (nodeList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(nodeList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllMgr")
//	public ResponseEntity<List<Manager>> getAllManagers() {
//		List<Manager> mgrList = managerService.getAllMgr();
//		if (mgrList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(mgrList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllActiveMgr")
//	public ResponseEntity<List<Manager>> getAllActiveManagers() {
//		List<Manager> activeMgrList = managerService.getAllActiveMgr();
//		if (activeMgrList == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(activeMgrList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllDomMgr")
//	public ResponseEntity<List<DomainManager>> getAllDomainManagers() {
//		List<DomainManager> domMgrList = domainManagerService.getAllDomMgr();
//		if (domMgrList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(domMgrList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllActiveDomMgr")
//	public ResponseEntity<List<DomainManager>> getAllActiveDomainManagers() {
//		List<DomainManager> activeDomMgrList = domainManagerService.getAllActiveDomMgr();
//		if (activeDomMgrList == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(activeDomMgrList, HttpStatus.OK);
//	}
//	
//	@GetMapping("/listAllActiveComp")
//	public ResponseEntity<List<Company>> getAllActiveCompany() {
//		List<Company> activeCompanyList = companyService.getAllActiveCompany();
//		if (activeCompanyList == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(activeCompanyList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllOps")
//	public ResponseEntity<List<Operator>> getAllEmployees() {
//		List<Operator> opsList = sharedService.getAllOps();
//		if (opsList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(opsList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllVen")
//	public ResponseEntity<List<Vendor>> getAllVendors() {
//		List<Vendor> venList = sharedService.getAllVen();
//		if (venList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(venList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listAllCircles")
//	public ResponseEntity<List<Circles>> getAllCircles() {
//		List<Circles> cirList = sharedService.getAllCir();
//		if (cirList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(cirList, HttpStatus.OK);
//	}
//
//	@GetMapping("/getManager/{id}")
//	public ResponseEntity<Manager> retrieveManagerById(@PathVariable Integer id) {
//		Manager manager = managerService.getMgrById(id);
//		if (manager == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(manager, HttpStatus.OK);
//	}
//
//	@GetMapping("/getManagerByName/{name}")
//	public ResponseEntity<Manager> retrieveManagerByName(@PathVariable String name) {
//		Manager manager = managerService.getMgrByName(name);
//		if (manager == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(manager, HttpStatus.OK);
//	}
//
//	@GetMapping("/getEmployee/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws RecordNotFoundException {
//		Employee empList = employeeService.searchById(id);
//		if (empList == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(empList, HttpStatus.OK);
//	}
//
//	@GetMapping("/listVendor/{id}")
//	public ResponseEntity<List<Vendor>> retrieveVendorByOpsId(@PathVariable Integer id) {
//		List<Vendor> vendor = sharedService.findVendorByOperatorId(id);
//		if (vendor.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(vendor, HttpStatus.OK);
//	}
//
//	@GetMapping("/listCircle/{id}")
//	public ResponseEntity<List<Circles>> retrieveCircleByVendorId(@PathVariable Integer id) {
//		List<Circles> circle = sharedService.findCircleByVendorId(id);
//		if (circle.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(circle, HttpStatus.OK);
//	}
//	
//	@GetMapping("/listDomainManager/{id}")
//	public ResponseEntity<List<DomainManager>> retrieveDMbyManagerId(@PathVariable Integer id) {
//		List<DomainManager> dm = domainManagerService.findDMbyManagerId(id);
//		if (dm.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(dm, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/removeUser/{id}")
//	public ResponseCode deleteUser(@PathVariable Integer id) {
//		ResponseCode resps = new ResponseCode();
//		resps = userservice.deleteUser(id);
//		return resps;
//	}
//
//	@DeleteMapping("/removeEmp/{id}")
//	public ResponseCode deleteEmp(@PathVariable Integer id) {
//		ResponseCode resps = new ResponseCode();
//		resps = employeeService.deleteEmp(id);
//		return resps;
//
//	}
//
//	@DeleteMapping("/removeMgr/{id}")
//	public ResponseCode deleteManager(@PathVariable Integer id) {
//		ResponseCode response = managerService.deleteMgr(id);
//		return response;
//	}
//	
//	@DeleteMapping("/removeDomMgr/{id}")
//	public ResponseCode deleteDomianManager(@PathVariable Integer id) {
//		ResponseCode response = domainManagerService.deleteDomMgr(id);
//		return response;
//	}
//
//	@DeleteMapping("/removeDept/{id}")
//	public ResponseCode deleteDepartment(@PathVariable Integer id) {
//		ResponseCode response = departmentService.deleteDept(id);
//		return response;
//	}
//	
//
//	@DeleteMapping("/removeComp/{id}")
//	public ResponseCode deleteCompany(@PathVariable Integer id) {
//		ResponseCode response = companyService.deleteComp(id);
//		return response;
//	}
//	
//	@DeleteMapping("/removeDomain/{id}")
//	public ResponseCode deleteDomain(@PathVariable Integer id) {
//		ResponseCode response = domainService.deleteDomain(id);
//		return response;
//	}
////	
////	@DeleteMapping("/removeNode/{id}")
////	public ResponseCode deleteNode(@PathVariable Integer id) {
////		ResponseCode response=nodesService.deleteNode(id);
////		return response;
////	}
//
//}
