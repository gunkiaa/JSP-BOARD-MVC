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
	private String updateSQL = "UPDATE BOARD SET BTITLE = ?, BCONTENT = ? WHERE BID = ?";
	private String selectSQL = "SELECT BTITLE, BCONTENT FROM BOARD WHERE BID = ?";
	private String upHitSQL = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID = ?";

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

			connCheck(deleteCnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		return deleteCnt;
	}

	public BoardDTO contentView(String idx) {
		upHit(idx);
		BoardDTO dto = new BoardDTO();
		try {
			ps = conn.prepareStatement(contentViewSQL);
			ps.setString(1, idx);

			rs = ps.executeQuery();

			while (rs.next()) {
				dto.setbId(rs.getInt("bId"));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbName(rs.getString("bName"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setbHit(rs.getInt("bHit"));

				// System.out.println(dto.getbId());
				// System.out.println(dto.getbTitle());
				// System.out.println(dto.getbContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}
		return dto;
	}

	public void upHit(String idx) {
		try {
			ps = conn.prepareStatement(upHitSQL);
			ps.setString(1, idx);

			int upHitCnt = ps.executeUpdate();

			connCheck(upHitCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(String title, String content, String name) {
		int insertCnt = 0;
		try {
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, name);

			insertCnt = ps.executeUpdate();

			connCheck(insertCnt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		return insertCnt;
	}

	public int modifyOk(String idx, String title, String content) {
		int updateCnt = 0;
		try {
			ps = conn.prepareStatement(updateSQL);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, idx);

			updateCnt = ps.executeUpdate();

			connCheck(updateCnt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		return updateCnt;
	}

	public BoardDTO modify(String idx) {
		BoardDTO dto = null;
		try {
			ps = conn.prepareStatement(selectSQL);
			ps.setString(1, idx);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new BoardDTO();
				dto.setbId(Integer.parseInt(idx));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}
		return dto;
	}

	public void connCheck(int cnt) {
		try {
			if (cnt > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}