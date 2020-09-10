package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.webmark.dto.AccountVO;
import com.webmark.dto.CategoryVO;
import com.webmark.dto.NoticePagingVO;
import com.webmark.dto.NoticeVO;
import com.webmark.dto.SearchUrlVO;
import com.webmark.dto.UrlVO;

import util.DBManager;

public class MainDAO {
	
	private MainDAO() {
		
	}
	
	private static MainDAO instance = new MainDAO();
	
	public static MainDAO getInstance() {
		return instance;
	}
	
	public AccountVO sampleAccount (String userid) {
		
		String sql = "select user_id, user_pw, user_name, user_nick, e_mail, user_type, to_char(create_date, 'yyyy/mm/dd') \"create_date\" from accountwm where user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		AccountVO vo = new AccountVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setUserid(rs.getString("user_id"));
				vo.setUserpw(rs.getString("user_pw"));
				vo.setUsername(rs.getString("user_name"));
				vo.setUsernick(rs.getString("user_nick"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setUsertype(rs.getString("user_type"));
				vo.setCreatedate(rs.getString("create_date"));

			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return vo;
	}
	
	public String checkID (long cat_no) {
		
		String sql = "select user_id from category where cat_num = ?";
		
		String check_id = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cat_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check_id = rs.getString("user_id");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return check_id;
		
	}
	
	public List<CategoryVO> getCategoryList (String userid) {
		
		String sql = "select * from category where user_id = ?";
		
		List<CategoryVO> list = new Vector<CategoryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryVO vo = new CategoryVO();
				
				vo.setCat_name(rs.getString("cat_name"));
				vo.setCat_no(rs.getLong("cat_num"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public List<UrlVO> getUrlList (long cat_no) {
		
		String sql = "select url_num, url_address, url_name, url_access, tag from urlwm where cat_num = ?";
		
		List<UrlVO> list = new Vector<UrlVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cat_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UrlVO vo = new UrlVO();
				
				vo.setUrl_num(rs.getLong("url_num"));
				vo.setUrl_address(rs.getString("url_address"));
				vo.setUrl_name(rs.getString("url_name"));
				vo.setUrl_access(rs.getString("url_access"));
				vo.setTag(rs.getString("tag"));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int addUrl (long cat_no, UrlVO vo) {
		
		String sql1 = "select url_num from urlwm where cat_num = ? and url_name = ?";
		String sql2 = "insert into urlwm values (urlwm_seq.nextval,?,?,?,?,?)";
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setLong(1, cat_no);
			pstmt.setString(2, vo.getUrl_name());
			rs = pstmt.executeQuery();
			rs.last();
			
			if(rs.getRow() == 0) {
				
				pstmt.close();
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setLong(1,cat_no);
				pstmt.setString(2, vo.getUrl_address());
				pstmt.setString(3, vo.getUrl_name());
				pstmt.setString(4, vo.getUrl_access());
				pstmt.setString(5, vo.getTag());
				
				pstmt.execute();
				
				result = 1;
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			result = 0;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public void deletUrl (long url_num) {
		
		String sql = "delete from urlwm where url_num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, url_num);
			
			pstmt.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public int editUrl (long cat_no, UrlVO vo) {
		
		String sql1 = "select url_num from urlwm where cat_num = ? and url_name = ?";
		String sql2 = "update urlwm set cat_num = ?, url_address = ?, url_name = ?, url_access = ?, tag = ? where url_num = ?";
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setLong(1, cat_no);
			pstmt.setString(2, vo.getUrl_name());
			rs = pstmt.executeQuery();
			rs.last();
			
			if(rs.getRow() == 0) {
				rs.close();
				pstmt.close();
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setLong(1, cat_no);
				pstmt.setString(2, vo.getUrl_address());
				pstmt.setString(3, vo.getUrl_name());
				pstmt.setString(4, vo.getUrl_access());
				pstmt.setString(5, vo.getTag());
				pstmt.setLong(6, vo.getUrl_num());
				
				pstmt.execute();
				
				result = 1;
				
			} else {
				result = -1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public List<SearchUrlVO> searchUrl(String userid, String urlname) {
		
		String searchName = "%" + urlname + "%";
		String sql = "select u.cat_num, cat_name, url_num, url_address, url_name, url_access, tag from urlwm u, category c where u.cat_num = c.cat_num and c.user_id = ? and u.url_name like ?";
		
		List<SearchUrlVO> list = new Vector<SearchUrlVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, searchName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SearchUrlVO vo = new SearchUrlVO();
				
				String temp_catname = "(" + rs.getString("cat_name") + ")";
				
				vo.setUrl_num(rs.getLong("url_num"));
				vo.setCat_no(rs.getLong("cat_num"));
				vo.setCat_name(temp_catname);
				vo.setUrl_address(rs.getString("url_address"));
				vo.setUrl_name(rs.getString("url_name"));
				vo.setUrl_access(rs.getString("url_access"));
				vo.setTag(rs.getString("tag"));
				
				list.add(vo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public long addCategory (String userid, String cat_name) {
		
		String sql1 = "select cat_num from category where user_id = ? and cat_name = ?";
		String sql2 = "insert into category values (category_seq.nextval,?,?)";
		
		long result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, userid);
			pstmt.setString(2, cat_name);
			rs = pstmt.executeQuery();
			rs.last();
			
			if(rs.getRow() == 0) {
				rs.close();
				pstmt.close();
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, userid);
				pstmt.setString(2, cat_name);
				pstmt.execute();
				
				pstmt.close();
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, userid);
				pstmt.setString(2, cat_name);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getLong("cat_num");
				}
				
			} else {
				result = -1;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
	
	public void deleteCategory (long cat_no) {
		
		String sql = "delete from category where cat_num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cat_no);
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public List<NoticeVO> getNoticePagingList(NoticePagingVO pagingVO) {
		
		List<NoticeVO> pagingList = new Vector<NoticeVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select a.* from (select a.*, ROWNUM rnum, FLOOR((ROWNUM - 1)/10) + 1 pageNumber from ("
				+ "select notice_num, user_id, notice_title, to_char(write_date, 'yyyy/mm/dd') \"write_date\" from notice order by notice_num desc)a)a where a.pageNumber = ? order by a.rnum";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int)pagingVO.getPage());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNotice_num(rs.getLong("notice_num"));
				vo.setUserid(rs.getString("user_id"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setWrite_date(rs.getString("write_date"));
				
				pagingList.add(vo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return pagingList;
	}
	
	public HashMap<String, Object> getNoticePagingListCnt (NoticePagingVO pagingVO) {
		HashMap<String, Object> noticePagingListCnt = new HashMap<String, Object>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*), ceil(count(*)/10) totalPage from notice order by notice_num desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int totalPage = rs.getInt("totalPage");
				pagingVO.setTotalPage(totalPage);
				noticePagingListCnt.put("totalPage", totalPage);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return noticePagingListCnt;
	}
	
	public NoticeVO getNoticeContents (long notice_num) {
		
		NoticeVO vo = new NoticeVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select notice_num, user_id, notice_contents, notice_title, notice_attach, to_char(write_date, 'yyyy/mm/dd') \"write_date\""
				+ " from notice where notice_num = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, notice_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNotice_num(rs.getLong("notice_num"));
				vo.setNotice_title(rs.getString("notice_title"));
				vo.setNotice_contents(rs.getString("notice_contents"));
				vo.setUserid(rs.getString("user_id"));
				vo.setWrite_date(rs.getString("write_date"));
				vo.setNotice_attach(rs.getString("notice_attach"));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
		
	}
	

}
