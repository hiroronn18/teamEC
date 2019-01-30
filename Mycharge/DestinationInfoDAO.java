package com.internousdev.anemone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.anemone.dto.DestinationInfoDTO;
import com.internousdev.anemone.util.DBConnector;

public class DestinationInfoDAO {

	/*DBに宛先情報の追加：戻り値はint型*/
	public int insertDestinationInfo(String userId, String familyName,String firstName,String familyNameKana,
			String firstNameKana, String address, String phoneNumber, String email){
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql="INSERT INTO destination_info(user_id, family_name, first_name, family_name_kana,"
				+ " first_name_kana, email, tel_number, user_address, regist_date, update_date)"
				+ " VALUES (?,?,?,?,?,?,?,?,now(),now())";

		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, phoneNumber);
			ps.setString(8, address);
			count=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		return count;
	}


	/*ログインIDから宛先情報を取得*/
	public List<DestinationInfoDTO> getDestinationInfo(String loginId){
		DBConnector db= new DBConnector();
		Connection con = db.getConnection();
		List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();

		String sql ="SELECT id, family_name, first_name, family_name_kana, first_name_kana,"
				+ " user_address, tel_number, email FROM destination_info WHERE user_id = ?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDTOList.add(destinationInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		return destinationInfoDTOList;
	}
	}
