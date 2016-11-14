package com.boot.mapper;

import java.util.List;

import com.boot.model.Shipwreck;


public interface ShipMapper {

	 public void insertShip(Shipwreck ship);

	 public Shipwreck getShipById(Integer userId);

	 public List<Shipwreck> getAllShip();

	 public void updateShip(Shipwreck ship);

	 public void deleteShip(Integer id);
}
