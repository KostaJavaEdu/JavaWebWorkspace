package ex1125.el;

public class Product { //���ʸ� ������ �� : COC

	private String code = "A01";
	private String name = "�����";
	private int price = 3000;
	private int qcy = 15;
	
	public Product() {
		System.out.println("Product ������ ȣ���");
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQcy() {
		return qcy;
	}
}
