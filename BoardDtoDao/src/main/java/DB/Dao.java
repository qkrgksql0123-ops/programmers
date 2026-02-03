package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class Dao {
	Connection con = null;
	Statement st = null;
	public ArrayList<Dto> list(){
		ArrayList<Dto> posts= new ArrayList<>();
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID,Db.DB_PW);
			st =con.createStatement();
			
			String sql = String.format("select * from %s", Db.TABLE_PS_BOARD_FREE);
			ResultSet  rs = st.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
				
			}
			st.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return posts;
	}
	
	public Dto read(String no) { 
		Dto posts = null;
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID,Db.DB_PW);
			st =con.createStatement();
			
			String sql = String.format("select * from %s where b_no=%s",Db.TABLE_PS_BOARD_FREE,no);
			ResultSet  rs = st.executeQuery(sql);
			rs.next();
			posts = new Dto(
				rs.getString("B_NO"),
				rs.getString("B_TITLE"),
				rs.getString("B_ID"),
				rs.getString("B_DATETIME"),
				rs.getString("B_HIT"),
				rs.getString("B_TEXT"),
				rs.getString("B_REPLY_COUNT"),
				rs.getString("B_REPLY_ORI"));
			
			st.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}return posts;
	}
	
	public void del(String no) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
		////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			st=con.createStatement();
			String sql = String.format("delete from %s where b_no='%s'", Db.TABLE_PS_BOARD_FREE,no);
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void write(Dto d) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();
			String sql = String.format("insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')", Db.TABLE_PS_BOARD_FREE,d.title,d.id,d.text);
			st.executeUpdate(sql);
			st.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void edit(Dto d,String no) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();
			
			String sql = String.format("update %s set b_title='%s',b_text='%s' where b_no = %s", Db.TABLE_PS_BOARD_FREE,d.title,d.text,no);
			st.executeUpdate(sql);
			st.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
