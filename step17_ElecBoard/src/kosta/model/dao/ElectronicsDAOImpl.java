package kosta.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.model.dto.Electronics;
import kosta.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {

	@Override
	public List<Electronics> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select model_num, model_name, price, description, password, writeday, readnum, fname, fsize from Electronics order by writeday desc";
		ResultSet rs = null;
		List<Electronics> list = new ArrayList<Electronics>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Electronics elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
													rs.getString(4), rs.getString(5), rs.getString(6),
													rs.getInt(7), rs.getString(8), rs.getInt(9));
				list.add(elec);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select model_num, model_name, price, description, password, writeday, readnum, fname, fsize from Electronics where model_num = ?";
		Electronics elec = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
										rs.getString(4), rs.getString(5), rs.getString(6),
										rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return elec;
	}

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = " update Electronics set readnum = readnum+1 where model_num = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = " insert into Electronics(model_num, model_name, price, description, password, readnum, fname, fsize , writeday) values(?,?,?,?,?,0,?,?, sysdate )";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelNum());ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getFname());ps.setInt(7, electronics.getFsize());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from Electronics  where model_num=? and password=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			ps.setString(2, password);
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update Electronics set model_name=?, price=?, description=?  where model_num=? and password=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
