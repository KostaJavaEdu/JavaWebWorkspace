package ex1125.el;

public class Product { //관례를 따르는 것 : COC

	private String code = "A01";
	private String name = "새우깡";
	private int price = 3000;
	private int qcy = 15;
	
	public Product() {
		System.out.println("Product 생성자 호출됨");
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
