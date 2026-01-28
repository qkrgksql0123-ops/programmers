package com.peisia.mysqlconsoleboard;

public class Display {
	static private String      title = "🔴🟤⚪🔴🟤⚪🔴🟤⚪🔴🟤⚪🔴🟤⚪";
	static private String title_name = "🔴🟤⚪    게시판 입니다   🔴🟤⚪";
	static private String Line =       "==============================";
	static private String Menu =       "1.글보기, 2.글읽기, 3.글수정, 4.글삭제, 5.글쓰기, 6.댓글쓰기, 7.로그아웃";
	
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
	public static void First() {

		System.out.println("1.로그인, 2.회원가입, 3.프로그램 종료");
	}
}
