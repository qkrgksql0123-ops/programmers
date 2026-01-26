package com.peisia.mysqlconsoleboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	Scanner sc=new Scanner(System.in);
	
	void run() {
		Display.showTitle();
		Display.showMainMenu();
		dbInit();
		
		loop:
		while(true) {
			System.out.println("명령입력: ");
			String cmd=sc.next();
			switch(cmd) {
			case "1":	//글리스트
				Count();
				dbexecutequery();
				break;
			case "2":	//글읽기
				dbread();
				break;
			case "3":	//글쓰기	
				dbwrtie();
				break;
			case "4":	//글삭제
				Dbdel();
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				System.out.println("프로그램종료");
				break loop;
			}
		}
	}
	
	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbexecutequery() {
		int Perpage= 3;
		int start = 0;
		System.out.println("몇번 페이지");
		int current = sc.nextInt();
		start = (current-1)*Perpage;
		try {
			result = st.executeQuery("select * from board limit "+start+",3");
			while(result.next()) {
				String b_no = result.getString("b_no");
				String b_id = result.getString("b_id");
				String b_text = result.getString("b_text");
				String date_time = result.getString("b_datetime");
				String sql;
				sql = String.format("번호 : %s,아이디 :%s, 시간 :%s, 내용 : %s", b_no,b_id,date_time,b_text);
				System.out.println(sql);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
	
	private void dbread() {
		System.out.println("읽고싶은 글 번호");
		int user  = sc.nextInt();
		try {
			result = st.executeQuery("select * from board where b_no="+user);
			while(result.next()) {
				String title = result.getString("b_title");
				String text = result.getString("b_text");
				System.out.println("글 제목 :"+title+"내용 : "+text);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void dbwrtie() {
		System.out.println("글 제목");
		String title = sc.next();
		System.out.println("글 아이디");
		String id = sc.next();
		System.out.println("글 내용");
		String text = sc.next();
		String sql;
		try {
		sql = String.format("insert into board values(b_no,'%s','%s',now(),0,'%s')",title,id,text);
		int result = st.executeUpdate(sql);
		System.out.println("처리된 행 : "+result );
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void Dbdel() {
		System.out.println("지우고 싶은 글 번호");
		int delnum = sc.nextInt();
		try {
			int result = st.executeUpdate("delete from board where b_no="+delnum);
			System.out.println("처리된 행 : "+result);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void Count() {
		try {
			result = st.executeQuery("select count(*) from board");
			while(result.next()) {
				String num = result.getString("count(*)");
				System.out.println("=========================");
				System.out.println("총 글:"+num);
				System.out.println("=========================");
			}}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}