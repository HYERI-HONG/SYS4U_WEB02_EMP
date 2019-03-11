package dao;

import java.util.List;
import java.util.Map;

import domain.Employee;

public interface EmployeeDAO {
	
	public List<Employee> list();
	public List<Employee> Search(Map<String, String> searchInfo);

}
