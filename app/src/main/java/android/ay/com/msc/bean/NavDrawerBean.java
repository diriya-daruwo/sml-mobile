package android.ay.com.msc.bean;

public class NavDrawerBean {
	
	private String title;
	private boolean isCounterVisible = false;
	private int count;
	
	public NavDrawerBean(){}

	public NavDrawerBean(String title){
		this.title = title;
	}
	
	public NavDrawerBean(String title, boolean isCounterVisible, int count){
		this.title = title;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean getCounterVisibility(){
		return this.isCounterVisible;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	
	
	
	public void setCounterVisibility(boolean isCounterVisible){
		this.isCounterVisible = isCounterVisible;
	}
}
