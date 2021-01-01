package ex1125.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ex1125.domain.MemberDTO;

public class ForEachBean {

	private String names[] = {"����","ȿ��","����","����","ä��"};
	private List<String> menus = new ArrayList<String>();
	private List<MemberDTO> memberList = new ArrayList<MemberDTO>();
	
	private Map<String, String> map = new HashMap<String, String>();
	
	public ForEachBean() {
		//������ �ʱ�ȭ
		menus.add("¥���");menus.add("«��");
		menus.add("������");menus.add("������");
		menus.add("�Ⱥ�ä");menus.add("�쵿");
		menus.add("«¥��");menus.add("���");
		
		memberList.add(new MemberDTO("choi", "����", 24, "����"));
		memberList.add(new MemberDTO("lee", "ȿ��", 23, "����"));
		memberList.add(new MemberDTO("joo", "����", 25, "�뱸"));
		memberList.add(new MemberDTO("tak", "����", 21, "�λ�"));
		memberList.add(new MemberDTO("jeong", "ä��", 26, "����"));
		
		map.put("kr", "���ѹα�");
		map.put("us", "�̱�");
		map.put("ca", "ĳ����");
		map.put("fr", "������");
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
