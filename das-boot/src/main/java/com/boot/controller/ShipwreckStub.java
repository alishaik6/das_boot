package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.boot.mapper.ShipMapper;
import com.boot.model.Shipwreck;
import com.boot.util.MyBatisUtil;

public class ShipwreckStub {
	private static Map<Integer, Shipwreck> wrecks = new HashMap<Integer, Shipwreck>();
	private static Integer idIndex = 3;
	private static  boolean data_type_local = false; 

	//populate initial wrecks
	static {
		if(data_type_local)
		{
			Shipwreck a = new Shipwreck(1, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
			wrecks.put(1, a);
			Shipwreck b = new Shipwreck(2, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994);
			wrecks.put(2, b);
			Shipwreck c = new Shipwreck(3, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50, 44.12, 138.44, 1994);
			wrecks.put(3, c);
		}

	}

	public static List<Shipwreck> list() {
		if(data_type_local)
		{
			return new ArrayList<Shipwreck>(wrecks.values());
		}
		else
		{
			List<Shipwreck> oShipwreck = new ArrayList<Shipwreck>() ;
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			ShipMapper oShipMapper= sqlSession.getMapper(ShipMapper.class);
			oShipwreck = oShipMapper.getAllShip();
			return  oShipwreck;
		}
		
	}

	public static Shipwreck create(Shipwreck wreck) {
		
		if(data_type_local)
		{
			idIndex += idIndex;
			wreck.setId(idIndex);
			wrecks.put(idIndex, wreck);
			return wreck;
		}
		else
		{
			Shipwreck oShipwreck = new Shipwreck();
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			ShipMapper oShipMapper= sqlSession.getMapper(ShipMapper.class);
			oShipMapper.insertShip(wreck);
			sqlSession.commit();
			return wreck;
		}
		
	}

	public static Shipwreck get(Integer id) {
		
		if(data_type_local)
		{
			return wrecks.get(id);
		}
		else
		{
			Shipwreck oShipwreck = new Shipwreck();
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			ShipMapper oShipMapper= sqlSession.getMapper(ShipMapper.class);
			oShipwreck = oShipMapper.getShipById(id);
			
			return oShipwreck;
		}
	}

	public static Shipwreck update(Integer id, Shipwreck wreck) {
		
		if(data_type_local)
		{
			wrecks.put(id, wreck);
			return wreck;
		}
		else
		{
			wreck.setId(id);
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			ShipMapper oShipMapper= sqlSession.getMapper(ShipMapper.class);
			oShipMapper.updateShip(wreck);
			sqlSession.commit();
			return wreck;
		}
		
	}

	public static Shipwreck delete(Integer id) {
		
		if(data_type_local)
		{
			return wrecks.remove(id);
		}
		else
		{
			List<Shipwreck> oShipwreck = new ArrayList<Shipwreck>() ;
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			ShipMapper oShipMapper= sqlSession.getMapper(ShipMapper.class);
			oShipMapper.deleteShip(id);
			sqlSession.commit();
			oShipwreck = oShipMapper.getAllShip();
			
			for(Shipwreck ooShipwreck : oShipwreck)
			{
				wrecks.put(ooShipwreck.getId(), ooShipwreck);
			}
			return wrecks.remove(id);
		}
	}
}
