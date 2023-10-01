package com.cleancode.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class DispatchInformation {

	// Purchase Service
	PurchaseService pSrvc;

	// sales service
	SalesService slSrvc;

	// AutomatedService atmSrvc;

	// Checking the value from the input
	// private void checkVal(String input){
	// System.out.println(input);
	// //Logic for the check val
	// }

	public void send(HttpServletRequest req) throws Exception {
		System.out.println("Method calling send");
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Department dpt = null;

		// if (dept==null || dept.getEmployees() == null ||
		// dept.getEmployees().isEmpty()){
		// return empMap();
		// }

		// This is getting the department list from the session
		if (req.getSession() != null && req.getSession().getAttribute("deptList") != null) {
			@SuppressWarnings("unchecked")
			List<Department> lst = (List<Department>) req.getSession().getAttribute("deptList");
			System.out.println("List = " + lst);

			System.out.println(lst.size());

			// If Condition
			if (lst != null && lst.size() > 0) {

				for (int i = 0; i < lst.size(); i++) {

					System.out.println(i);
					dpt = lst.get(i);
					Long id = dpt.getId();

					if (id == 1) {
						if (dpt.getEmployees().size() > 0) {
							for (int j = 0; j < dpt.getEmployees().size(); j++) {
								// j++

								// Creating object of employee and putting the mobile number and info message
								Employee e = dpt.getEmployees().get(j);
								System.out.println("Employee" + e);
								map1.put(e.getMobileNo(), e.getInfo());
							} // End for
						} // End If
					} // End else
				} // End for

				// Now sending the information
				slSrvc.sendInfo(map1);
				pSrvc.sendInfo(map2);
			} else {
				// else
				// throwing exception if list is null

				throw new EmptyDepartmentException("Empty Department Found");
			} // End main if

		}
	}

}
