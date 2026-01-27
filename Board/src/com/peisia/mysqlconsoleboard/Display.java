package com.peisia.mysqlconsoleboard;

public class Display {
	static private String      title = "🔴🟤⚪🔴🟤⚪🔴🟤⚪🔴🟤⚪🔴🟤⚪";
	static private String title_name = "🔴🟤⚪    게시판 입니다   🔴🟤⚪";
	static private String Line =       "==============================";
	static private String Menu =       "1.글보기, 2.글읽기, 3.글수정, 4.글삭제";
	
	public static void Title() {
		System.out.println(title);
		System.out.println(title_name);
		System.out.println(title);
	}
	
	public static void Menu() {
		System.out.println(Line);
		System.out.println(Menu);
		System.out.println(Line);
		
	}
}
