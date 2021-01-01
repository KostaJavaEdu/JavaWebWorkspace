package kosta.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {

	private static ElectronicsDAO elecDAO  = new ElectronicsDAOImpl();
	/**
	 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		
		List<Electronics> list = elecDAO.selectAll();
		if(list==null || list.isEmpty()) throw new SQLException("��ȸ�����߽��ϴ�.");
		
		return list;
	}
	  
	  /**
	   * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	   * */
	public static int insert(Electronics elec) throws SQLException{
		int result = elecDAO.insert(elec);
		if(result==0) throw new SQLException("���Խ���");
		return result;
	}
	 
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	public static Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException{
		Electronics elec = elecDAO.selectByModelNum(modelNum);
		if(elec == null) throw new SQLException("��ȣ�� �ش��ϴ� �Խù��� �����ϴ�.");
		int result;
		if(flag) {
			//��ȸ�� ����
			result = elecDAO.increamentByReadnum(modelNum);
			if(result==0) throw new SQLException("��ȸ���� �������� ���߽��ϴ�.");
		}
		return elec;
	}
		 
		
		 
		 //�۹�ȣ�� �ش��ϴ� �Խù� �˻�
		
	 /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	public static int delete(String modelNum, String password) throws SQLException {
		Electronics electronics = elecDAO.selectByModelNum(modelNum);
		if (electronics == null)
			throw new SQLException("��ȣ�� �ش��ϴ� �Խù��� �����ϴ�.");

		if (!electronics.getPassword().equals(password)) {
			throw new SQLException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
			int result = elecDAO.delete(modelNum, password);
			if (result == 0)throw new SQLException("���Խ���");

			return result;
		}
	  

	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	public static int update(Electronics elec) throws SQLException {
		Electronics electronics = elecDAO.selectByModelNum(elec.getModelNum());
		if (electronics == null)
			throw new SQLException("��ȣ�� �ش��ϴ� �Խù��� �����ϴ�.");

		if (!electronics.getPassword().equals(elec.getPassword())) {
			throw new SQLException("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
			int result = elecDAO.update(elec);
			if (result == 0)throw new SQLException("���Խ���");

			return result;
		}
	}




