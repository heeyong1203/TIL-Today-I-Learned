package com.sinse.practiceapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinse.practiceapp.exception.PracticeNoticeException;
import com.sinse.practiceapp.model.PracticeNotice;
import com.sinse.practiceapp.pool.PoolManager;

// CRUD
public class PracticeNoticeDAO {
	
	PoolManager poolManager = PoolManager.getInstance();
	
	// 모든 레코드 가져오기
	public List<PracticeNotice> selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PracticeNotice> list = new ArrayList<>();
		
		try {
			con = poolManager.getConnection();
			String sql = "select * from notice order by notice_id DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PracticeNotice notice = new PracticeNotice();
				notice.setPracticeNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setDate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			poolManager.release(con, pstmt, rs);
		}
		
		return list;
	}
	
	// 하나만 조회하기
	public PracticeNotice select() {
		return null;
	}
	
	// 데이터 추가하기
	public void insert(PracticeNotice notice) throws PracticeNoticeException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = poolManager.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into notice(title, writer, content)");
			sql.append(" values(?, ?, ?)");
			pstmt = con.prepareStatement(sql.toString());
			//pstmt.setString(1, );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 수정하기
	public void update() {
		
	}
	
	// 데이터 삭제하기
	public void delete() {
		
	}
	
}
