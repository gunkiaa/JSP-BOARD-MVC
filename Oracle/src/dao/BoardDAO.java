package dao;

import java.sql.*;
import java.util.*;

import dto.*;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private DBconnect db = db = new DBconnect();

	private String listSQL = "SELECT BID, BTITLE, BCONTENT, BNAME, BDATE, BHIT FROM BOARD ORDER BY BID ASC";
	private String deleteSQL = "DELETE BOARD WHERE BID = ?";
	private String contentViewSQL = "SELECT BID, BTITLE, BCONTENT, BNAME, BDATE, BHIT FROM BOARD WHERE BID = ?";
	private String insertSQL = "INSERT INTO BOARD(BID, BTITLE, BCONTENT, BNAME) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";

	public BoardDAO() {
		conn = db.getConnection();
		// 커넥션을 얻어옴
	}

	// 게시판 리스트 출력
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		try {

			ps = conn.prepareStatement(listSQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setbId(rs.getInt("bId"));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbName(rs.getString("bName"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setbHit(rs.getInt("bHit"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}

		return list;
	}

	public int delete(String idx) {
		int deleteCnt = 0;
		try {
			ps = conn.prepareStatement(deleteSQL);
			ps.setString(1, idx);

			deleteCnt = ps.executeUpdate();

			if (deleteCnt > 0) {

				conn.commit();

			} else {

				conn.rollback();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		return deleteCnt;
	}

	public BoardDTO contentView(String idx) {
		BoardDTO dto = new BoardDTO();
		try {
			ps = conn.prepareStatement(contentViewSQL);
			ps.setInt(1, Integer.parseInt(idx));
			rs = ps.executeQuery();
			while (rs.next()) {
				while (rs.next()) {
					dto.setbId(rs.getInt("bId"));
					dto.setbTitle(rs.getString("bTitle"));
					dto.setbContent(rs.getString("bContent"));
					dto.setbName(rs.getString("bName"));
					dto.setbDate(rs.getTimestamp("bDate"));
					dto.setbHit(rs.getInt("bHit"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}
		return dto;
	}

	public int insert(String title, String content, String name) {
		int insertCnt = 0;
		try {
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, name);

			insertCnt = ps.executeUpdate();

			if (insertCnt > 0) {

				conn.commit();

			} else {

				conn.rollback();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		return insertCnt;
	}
}
