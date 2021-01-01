package kosta.model.service;

import java.io.File;
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
		//dao�� ȣ���ϰ� �װ���� ���� 
		List<Electronics> list = elecDAO.selectAll();
		
		return list;
	}
	  
	  /**
	   * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	   * */
	public static int insert(Electronics electronics) throws SQLException{
		int result = elecDAO.insert(electronics);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		
		return result;
	}
	 
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	public static Electronics selectByModelnum(String modelNum, boolean flag)throws SQLException{
		if(flag) {
			int result = elecDAO.increamentByReadnum(modelNum);
			if(result==0)throw new SQLException("��ȸ�� ������ ������ �߻��߽��ϴ�.^^");
		}
		
		Electronics electronics = elecDAO.selectByModelNum(modelNum);
		if(electronics==null)throw new SQLException(modelNum+"�� �ش��ϴ� ������ �����ϴ�.");
		return electronics;
	}
	 /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  public static int delete(String modelNum, String password, String path) throws SQLException{
		Electronics dbElec= elecDAO.selectByModelNum(modelNum);
		if(!dbElec.getPassword().equals(password)) {
			throw new SQLException("��й�ȣ �����Դϴ�.^^");
		}
		
		int result = elecDAO.delete(modelNum, password);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		
		//�����Ϸ�翡 ���Ͽ� ���� 
		if(dbElec.getFname() != null) {
			new File(path, dbElec.getFname()).delete();
		}
		  return result;
	  }
	  
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	  public static int update(Electronics electronics) throws SQLException{
		Electronics dbElec=
			elecDAO.selectByModelNum(electronics.getModelNum());
		 
		//�����ϱ� ���� ��й�ȣ ���� üũ�Ѵ�.
		if(!dbElec.getPassword().equals(electronics.getPassword())) {
		  throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		}
		 
		 int result = elecDAO.update(electronics);
		 if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		  return result;
	  }
	  
	  
}


