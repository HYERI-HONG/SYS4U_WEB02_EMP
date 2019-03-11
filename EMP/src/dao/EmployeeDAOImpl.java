package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.Employee;
import static dao.DTOFactory.*;
import static dao.DataResourceCloser.*;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	@Override
	public List<Employee> list() {
		List<Employee> list = new ArrayList<Employee>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(QueryFactory.getQuery("all"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(fromResultSet(rs, Employee.class));
			}

		} catch (Exception e) {
			
		} finally {
			close(rs,pstmt,conn);
		}

		return list;
	}

	@Override
	public List<Employee> Search(Map<String, String> searchInfo) {
	
		List<Employee> list = new ArrayList<Employee>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(QueryFactory.getQuery(searchInfo.get("searchOption")));
			pstmt.setString(1, searchInfo.get("searchWord"));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(fromResultSet(rs, Employee.class));
			}

		} catch (Exception e) {
			
		} finally {
			close(rs,pstmt,conn);
		}
		return list;
	}


}
