package kosta.controller;

public class ModelAndView {
	private String viewName; //결과 뷰의 정보
	private boolean isRedirect; //이동방식정보(true이면 Redirect, false이면 forward로 가자는 의도)
	
	public ModelAndView() {}
	
	public ModelAndView(String viewName, boolean isRedirect) {
		super();
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
