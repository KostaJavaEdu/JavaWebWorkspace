package ex1125.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ex1125.domain.MemberDTO;

public class ForEachBean {

	private String names[] = {"수녕","효정","유진","소희","채연"};
	private List<String> menus = new ArrayList<String>();
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	
	private Map<String, String> map = new HashMap<String, String>();
	
	public ForEachBean() {
		//데이터 초기화
		menus.add("짜장면");menus.add("짬뽕");
		menus.add("탕수육");menus.add("볶음밥");
		menus.add("팔보채");menus.add("우동");
		menus.add("짬짜면");menus.add("울면");
		
		memberList.add(new MemberDTO("choi", "수녕", 24, "용인"));
		memberList.add(new MemberDTO("lee", "효정", 23, "대전"));
		memberList.add(new MemberDTO("joo", "유진", 25, "대구"));
		memberList.add(new MemberDTO("tak", "소희", 21, "부산"));
		memberList.add(new MemberDTO("jeong", "채연", 26, "서울"));
		
		map.put("kr", "대한민국");
		map.put("us", "미국");
		map.put("ca", "캐나다");
		map.put("fr", "프랑스");
	}

	public String[] getNames() {
		return names;
	}

	public List<String> getMenus() {
		return menus;
	}

	public List<MemberDTO> getMemberList() {
		return memberList;
	}

	public Map<String, String> getMap() {
		return map;
	}
}
