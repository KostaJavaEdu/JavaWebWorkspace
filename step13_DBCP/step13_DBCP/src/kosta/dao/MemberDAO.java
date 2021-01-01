package kosta.dao;
import java.util.List;
import kosta.dto.Member;

public interface MemberDAO {
	/**
	 * ��ü�˻�
	 * */
	List<Member> selectAll();
	
	/**
	 * ���ǰ˻�
	 * */
	List<Member> searchByKeyWord(String keyField, String keyWord);
	
	/**
	 * ����ϱ�
	 * */
	int insert(Member member);
	
	/**
	 * �����ϱ�
	 * */
	int delete(String id);
	
	/**
	 * id�ߺ�üũ
	 * @return : true�̸� �ߺ��̴�, false�̸� �ߺ��ƴϴ�.
	 * */
	boolean duplicateById(String id);
	
	
	/**
	 * id�� �ش��ϴ� ȸ�� ���� ��������
	 * */
	Member searchById(String id);
}
