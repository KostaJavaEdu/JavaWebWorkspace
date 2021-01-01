package kosta.dao;
import java.util.List;
import kosta.dto.Member;

public interface MemberDAO {
	/**
	 * 전체검색
	 * */
	List<Member> selectAll();
	
	/**
	 * 조건검색
	 * */
	List<Member> searchByKeyWord(String keyField, String keyWord);
	
	/**
	 * 등록하기
	 * */
	int insert(Member member);
	
	/**
	 * 삭제하기
	 * */
	int delete(String id);
	
	/**
	 * id중복체크
	 * @return : true이면 중복이다, false이면 중복아니다.
	 * */
	boolean duplicateById(String id);
	
	
	/**
	 * id에 해당하는 회원 정보 가져오기
	 * */
	Member searchById(String id);
}
