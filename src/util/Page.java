package util;


import java.util.*;

public class Page {
   private String totalcount;
   private List<Map<String,String>> list=null;
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	public List<Map<String, String>> getList() {
		return list;
	}
	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
   
   
   
}
