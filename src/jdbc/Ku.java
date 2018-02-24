package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ku {
     public static void main(String[] args) {
    	// 格式  jdbc:mysql://主机Ip:端口号/数据库名
    	 String url="jdbc:mysql://192.168.49.131:3306/lh1";
    	 String user="root";
    	 String password="lh52131";
    	 Connection con =null;
    	 PreparedStatement pre =null;
    	  ResultSet re =null;
    	
		try {
			 //加载驱动（反射）
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 主机号 ip 账户 密码
			 con = DriverManager.getConnection(url, user, password);
			 //创建命令窗口
			  pre = con.prepareStatement("select * from s");
			// 运行sql语句并查看结果  如果是增删改 则返回受影响的行数 如果是查询返回的是查询结果
				// 运行的时候注意 如果是增删改则调用executeUpdate 返回int  如果查询 则调用executeQuery 返回ResultSet
			   re = pre.executeQuery();
			   while(re.next()){
				   System.out.println(re.getString("name")+"  "+re.getInt("id")+"   "+re.getInt("c"));
			   }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(re!=null)
			    	re.close();
				if(pre!=null)
					pre.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
