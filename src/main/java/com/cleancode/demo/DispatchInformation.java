package com.cleancode.demo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DispatchInformation {

	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private SalesService salesService;

	private static final int ID_PURCHASE_DEPARTMENT = 1;
	private static final int ID_SALES_DEPARTMENT = 5;
	private static final String SESSION_ATTRIBUTE_DEPT_LIST = "deptList";

	public void sendInformation(HttpServletRequest req) throws Exception {
		
		this.purchaseService = Objects.requireNonNull(purchaseService, "purchaseService must not be null");
        this.salesService = Objects.requireNonNull(salesService, "salesService must not be null");

		Map<String, String> salesEmp = null;
		Map<String, String> purchaseEmp = null;

		List<Department> deptList = getDepartmentListFromSession(req);

		log.debug("List = " + deptList);
		log.debug(deptList.size());

		if (deptList == null || deptList.isEmpty()) {
			throw new EmptyDepartmentException("Empty Department found");
		}

		Map<String, String> map;
		for (Department dept : deptList) {

			map = new EmployeeBuilder().setDepartment(dept).build();

			switch (dept.getId()) {
			case ID_PURCHASE_DEPARTMENT:
				purchaseEmp = map;
				break;
			case ID_SALES_DEPARTMENT:
				salesEmp = map;
				break;
			}

			this.sendInfoToSalesService(purchaseEmp);
			this.sendInfoToPurchaseService(salesEmp);
		}
	}

	private List<Department> getDepartmentListFromSession(HttpServletRequest request) {
		if (request.getSession() != null && request.getSession().getAttribute(SESSION_ATTRIBUTE_DEPT_LIST) != null) {
			@SuppressWarnings("unchecked")
			List<Department> departmentList = (List<Department>) request.getSession()
					.getAttribute(SESSION_ATTRIBUTE_DEPT_LIST);
			System.out.println("List = " + departmentList);
			return departmentList;
		}
		return List.of();
	}

	private void sendInfoToSalesService(Map<String, String> infoMap) {
		salesService.sendInfo(infoMap);
	}

	private void sendInfoToPurchaseService(Map<String, String> infoMap) {
		purchaseService.sendInfo(infoMap);
	}
}
