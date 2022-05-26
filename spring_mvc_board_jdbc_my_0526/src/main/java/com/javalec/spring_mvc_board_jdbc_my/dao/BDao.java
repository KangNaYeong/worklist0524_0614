package com.javalec.spring_mvc_board_jdbc_my.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_mvc_board_jdbc_my.dto.BDto;
import com.javalec.spring_mvc_board_jdbc_my.util.Constant;

public class BDao {
	DataSource dataSource;
	
	JdbcTemplate template;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = null;
		String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board order by bId desc";
		dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
		return dtos;

	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		String sql = "insert into mvc_board(bId, bName, bTitle, bContent, bHit) values(MVC_BOARD_SEQ.nextval,?,?,?,0)";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
			}
		});
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		BDto dto = null;
		String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board where bId="+strID;
		dto = template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dto;

	}
	
	private void upHit(final String bId) {
		String sql = "update mvc_board set bHit = bHit+1 where bId=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bId);
			}
		});

	}
	
	public void modify(final String bId, final String bTitle, final String bContent) {
		String sql = "update mvc_board set bTitle=?, bContent=? where bId=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bTitle);
				ps.setString(2, bContent);
				ps.setInt(3, Integer.parseInt(bId));
			}
		});
		
		upDate(bId);

	}
	public BDto modifyView(String strID ) {
		BDto dto = null;
		String sql = "select bId, bName, bTitle, bContent, bDate, bHit from mvc_board where bId="+strID;
		dto = template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dto;
		
	}
	
	private void upDate(final String bId) {
		String sql = "update mvc_board set bDate = sysdate where bId=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bId);
			}
		});
	}
	
	public void delete(final String bId) {
		String sql = "delete from mvc_board where bId=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});

	}
}

