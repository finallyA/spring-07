package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ku {
     public static void main(String[] args) {
    	// ��ʽ  jdbc:mysql://����Ip:�˿ں�/���ݿ���
    	 String url="jdbc:mysql://192.168.49.131:3306/lh1";
    	 String user="root";
    	 String password="lh52131";
    	 Connection con =null;
    	 PreparedStatement pre =null;
    	  ResultSet re =null;
    	
		try {
			 //�������������䣩
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ������ ip �˻� ����
			 con = DriverManager.getConnection(url, user, password);
			 //���������
			  pre = con.prepareStatement("select * from s");
			// ����sql��䲢�鿴���  �������ɾ�� �򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
				// ���е�ʱ��ע�� �������ɾ�������executeUpdate ����int  �����ѯ �����executeQuery ����ResultSet
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
