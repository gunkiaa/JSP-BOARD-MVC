package dao;

import java.sql.*;
import java.util.*;

import dto.*;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private DBconnect db = db = new DBconnect();

	private String listSQL = "SELECT BID, BTITLE, BCONTENT, BNAME, BDATE, BHIT FROM BOARD";
	private String deleteSQL = "DELETE BOARD WHERE BID = ?";
	private String contentViewSQL = "SELECT BID, BTITLE, BCONTENT, BNAME, BDATE, BHIT FROM BOARD WHERE BID = ?";

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
			ps.setString(1, idx);
			rs = ps.executeQuery();
			while (rs.next()) {
				while (rs.next()) {
					dto.setbId(rs.getInt("bId"));
					dto.setbTitle(rs.getString("bTitle"));
					dto.setbContent(rs.getString("bContent"));
					dto.setbName(rs.getString("bName"));
					dto.setbDate(rs.getTimestamp("bDate"));
					dto.setbHit(rs.getInt("bHit"));

					System.out.println("bId =" + rs.getInt("bId"));
					System.out.println("bTitle =" +rs.getString("bTitle"));
					System.out.println("bContent =" +rs.getString("bContent"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
