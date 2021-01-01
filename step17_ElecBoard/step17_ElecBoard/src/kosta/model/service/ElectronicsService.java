package kosta.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {

	private static ElectronicsDAO elecDAO  = new ElectronicsDAOImpl();
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		
		List<Electronics> list = elecDAO.selectAll();
		if(list==null || list.isEmpty()) throw new SQLException("조회실패했습니다.");
		
		return list;
	}
	  
	  /**
	   * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	public static int insert(Electronics elec) throws SQLException{
		int result = elecDAO.insert(elec);
		if(result==0) throw new SQLException("삽입실패");
		return result;
	}
	 
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	public static Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException{
		Electronics elec = elecDAO.selectByModelNum(modelNum);
		if(elec == null) throw new SQLException("번호에 해당하는 게시물이 없습니다.");
		int result;
		if(flag) {
			//조회수 증가
			result = elecDAO.increamentByReadnum(modelNum);
			if(result==0) throw new SQLException("조회수가 증가하지 못했습니다.");
		}
		return elec;
	}
		 
		
		 
		 //글번호에 해당하는 게시물 검색
		
	 /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	public static int delete(String modelNum, String password) throws SQLException {
		Electronics electronics = elecDAO.selectByModelNum(modelNum);
		if (electronics == null)
			throw new SQLException("번호에 해당하는 게시물이 없습니다.");

		if (!electronics.getPassword().equals(password)) {
			throw new SQLException("비밀번호가 일치하지 않습니다.");
		}
			int result = elecDAO.delete(modelNum, password);
			if (result == 0)throw new SQLException("삽입실패");

			return result;
		}
	  

	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	public static int update(Electronics elec) throws SQLException {
		Electronics electronics = elecDAO.selectByModelNum(elec.getModelNum());
		if (electronics == null)
			throw new SQLException("번호에 해당하는 게시물이 없습니다.");

		if (!electronics.getPassword().equals(elec.getPassword())) {
			throw new SQLException("아이디 비밀번호가 일치하지 않습니다.");
		}
			int result = elecDAO.update(elec);
			if (result == 0)throw new SQLException("삽입실패");

			return result;
		}
	}




