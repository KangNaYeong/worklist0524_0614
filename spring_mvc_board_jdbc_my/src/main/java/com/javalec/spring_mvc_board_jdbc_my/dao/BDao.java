package com.javalec.spring_mvc_board_jdbc_my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.spring_mvc_board_jdbc_my.dto.BDto;

public class BDao {
	DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board order by bId desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public void write(String bName, String bTitle, String bContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into mvc_board(bId, bName, bTitle, bContent, bHit) values(MVC_BOARD_SEQ.nextval,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			pstmt.executeUpdate();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		BDto dto = new BDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board where bId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	private void upHit(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update mvc_board set bHit = bHit+1 where bId=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bId);
			pstmt.executeUpdate();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
	
	public void modify(String bId, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update mvc_board set bTitle=?, bContent=? where bId=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setInt(3, Integer.parseInt(bId));
			pstmt.executeUpdate();
			
			upDate(bId);
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
	public BDto modifyView(String strID ) {
		BDto dto = new BDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board where bId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	private void upDate(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update mvc_board set bDate = sysdate where bId=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bId);
			pstmt.executeUpdate();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
	
	public void delete(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from mvc_board where bId=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(bId));
			pstmt.executeUpdate();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
}

