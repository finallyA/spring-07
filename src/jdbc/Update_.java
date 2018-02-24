package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_ {
public static void main(String[] args) {
	String url=("jdbc:mysql://192.168.49.131:3306/lh1?useUnicode=true&characterEncoding=utf8");
	String user=("root");
	String password=("lh52131");
	Connection cc =null;
	 PreparedStatement pp =null;
	try {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接 主机号 ip 账户 密码
		 cc = DriverManager.getConnection(url, user, password);
		 //创建命令窗口
		  pp = cc.prepareStatement("insert into s(name,c) values(?,?)");
		  //注入参数
		  pp.setString(1, "珞珞");
		  pp.setInt(2, 1);
		  int i=pp.executeUpdate();
		  System.out.println(i);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
			try {
				if(pp!=null)
			    	pp.close();
				if(cc!=null)
					cc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
}
