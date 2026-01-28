package com.peisia.mysqlconsoleboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	ResultSet result = null;
	Statement st = null;
	Scanner sc = new Scanner(System.in);
	int perpage = 3;
	boolean login = false;
	String user_id = "";
	
	private void init() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","");
			st = con.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	 void run() {
		Display.Title();
		init();
		loop_b:
		while(true) {
			Display.First();
			System.out.println("명령 : ");
			String cmd = sc.next();
			loop_a:
			switch (cmd) {
			case "1":
				signin();
				if(login == true) {
					while(true) {
						Display.Menu();
						System.out.println("명령 : ");
						String user = sc.next();
						switch (user) {
						case "1":
							dbtotal();
							dblist();
							break;
						case "2":
							dbread();
							break;
						case "3":
							dbupdate();
							break;
						case "4":
							dbdel();
						case "5":
							dbwirte();
							break;
						case "6":
							comment();
							break;
						case "7":
							login = false;
							System.out.println("로그아웃 되었습니다.");
							break loop_a;
						default:
							break;
						}
					}
				}
				break;
			case "2":
				signup();
				break;
			case "3":
				System.out.println("프로그램을 종료합니다.");
				break loop_b;
			}
			
		}
		
	}
	private void dblist() {
		try {
			System.out.println("몇 페이지 볼거야?");
			int currentPage = sc.nextInt();
			int offset = (currentPage-1)*perpage;
			String sql = String.format("select * from board order by b_no limit %d,%d", offset,perpage);
			result = st.executeQuery(sql);
			while(result.next()) {
				String title = result.getString("b_title");
				String no = result.getString("b_no");
				String id = result.getString("b_id");
				String time = result.getString("b_datetime");
				System.out.println("번호 :"+no+" 제목 :"+title + "아이디 :"+id+" 시간 :"+time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void dbread() {
		System.out.println("읽고 싶은 글 번호:");
			String cmd = sc.next();
			String sql = String.format("select * from board where b_no='%s'", cmd);
			System.out.println(sql);
			try {
				result = st.executeQuery(sql);
				loop:while(result.next()) {
					String no = result.getString("b_no");
					String text = result.getString("b_text");
					String rely_text = result.getString("b_reply_text");
					System.out.println("번호 : "+no+" 내용 : "+text+" 댓글 :"+rely_text);
				}
				loop:while(true) {
				System.out.println("=======댓글 리스트=======");
				System.out.println("명령[x:나가기, r:댓글쓰기]");
				String user = sc.next();
				if(user.equals("x")) {
					break loop;
				}else {
					System.out.println("댓글 : ");
					String comment = sc.next();
					String sql1 = String.format("update board set b_reply_text='%s'where b_no= '%s'",comment,cmd);
					st.executeUpdate(sql1);
					System.out.println("작성완료");
				}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	private void dbupdate() {
		System.out.println("수정할 글 번호");
		String no = sc.next();
		System.out.println("수정 내용 : ");
		String text = sc.next();
		String sql = String.format("update member set b_text ='%s' where b_no= '%s'",text,no);

		try {
			int reuslt = st.executeUpdate(sql);
			System.out.println("처리된 행 : "+reuslt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void dbdel() {
		System.out.println("삭제할 글 번호");
		String no = sc.next();
		String sql = String.format("delete from board where b_no ='%s'",no);
		try {
			int result = st.executeUpdate(sql);
			System.out.println("처리된 행 : "+result);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void dbtotal() {
		try {
			result = st.executeQuery("select count(*) from board");
			while(result.next()) {
				String count = result.getString("count(*)");
				System.out.println("글 수 :"+count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void signup() {
		System.out.println("아이디 : ");
		String ID = sc.next();
		System.out.println("비밀번호 : ");
		String Pw = sc.next();
		String sql = String.format("insert into member values ('%s','%s')",ID,Pw);
		try {
			int result = st.executeUpdate(sql);
			System.out.println("처리된 행 : "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void signin() {
		while(true) {
		System.out.println("로그인 아이디 : ");
		String id = sc.next();
		System.out.println("로그인 비밀번호 : ");
		String pw = sc.next();
		String sql = String.format("select * from member where s_id ='%s'and s_pw='%s'", id,pw);
		try {
			result = st.executeQuery(sql);
			if(result.next()) {
				System.out.println("로그인 성공"+result.getString("s_id")+"님");
				user_id = result.getString("s_id");
				login = true; 
				break;
				}else {
					System.out.println("없는 계정 입니다.");
					login = false;
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	}
	
	private void dbwirte() {
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("내용 : ");
		String text = sc.next();
		String sql = String.format("insert into board (b_title,b_id,b_text,b_datetime) values('%s','%s','%s',now())", title,user_id,text);
		try {
			int result = st.executeUpdate(sql);
			System.out.println("실행된 행 : "+  result);
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	private void comment() {
		System.out.println("댓글 달 번호");
		int id = sc.nextInt();
		System.out.println("내용 : ");
		String user_comment = sc.next();
		String sql = String.format("update board set b_reply_text='%s' where b_no=%d",user_comment,id);
		int result;
		try {
			result = st.executeUpdate(sql);
			System.out.println("실행된 행 : "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}