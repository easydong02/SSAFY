package com.ssafy.edu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements IMemberDao {

    DBUtil db;
    
    public MemberDaoImpl() {
        super();
        db=DBUtil.getInstance();
    }

    @Override
    public boolean registry(Member member) throws SQLException {
        String sql=" insert into members (user_id, user_name, "
                + " user_password,email_id,email_domain,join_date) \n"
                + " values(?,?,?,?,?,sysdate()) \n";
        Connection conn=null;
        PreparedStatement psmt=null;
        int count=0;
        try {
            conn=db.getConnection();
            psmt=conn.prepareStatement(sql);
            int j=1;
            psmt.setString(j++, member.getUserId());
            psmt.setString(j++, member.getUserName());
            psmt.setString(j++, member.getUserPassword());
            psmt.setString(j++, member.getEmailId());
            psmt.setString(j++, member.getEmailDomain());
            count=psmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            db.close(psmt, conn);
        }
        
        return count>0 ? true: false;
    }

    @Override
    public Member login(Member member) throws SQLException {
        String sql= " select user_id, user_name, email_id, email_domain "
                + " from members where user_id=? and user_password=? ";
        
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Member mem =null;
        
        try {
            conn=db.getConnection();
            psmt=conn.prepareStatement(sql);
            psmt.setString(1, member.getUserId());
            psmt.setString(2, member.getUserPassword());
            rs=psmt.executeQuery();
            
            while(rs.next()) {
                int i = 1;
                mem = new Member(rs.getString(i++), rs.getString(i++), "", rs.getString(i++), rs.getString(i++));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            db.close(rs, psmt, conn);
        }
        return mem;
    }

    @Override
    public Member getMember(String userId) throws SQLException {
        String sql= " select user_id, user_name, user_password, email_id, email_domain, join_date \n "
                + " from members where user_id=?";
        
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Member mem =null;
        
        try {
            conn=db.getConnection();
            psmt=conn.prepareStatement(sql);
            psmt.setString(1, userId);
            rs=psmt.executeQuery();
            
            while(rs.next()) {
                int i = 1;
                mem = new Member(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            db.close(rs, psmt, conn);
        }
        return mem;
    }

}