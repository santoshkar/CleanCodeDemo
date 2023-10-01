package com.cleancode.demo;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DispatchInformation {

	private PurchaseService purchaseService;
	private SalesService salesService;

	private static final int ID_PURCHASE_DEPARTMENT = 1;
	private static final int ID_SALES_DEPARTMENT = 5;
	private static final String SESSION_ATTRIBUTE_DEPT_LIST = "deptList";

	public void sendInformation(HttpServletRequest req) throws Exception {

		Map<String, String> salesEmp = null;
		Map<String, String> purchaseEmp = null;

		@SuppressWarnings("unchecked")
		List<Department> deptList = (List<Department>) req.getSession().getAttribute(SESSION_ATTRIBUTE_DEPT_LIST);
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

			purchaseService.sendInfo(purchaseEmp);
			salesService.sendInfo(salesEmp);
		}
	}
}
