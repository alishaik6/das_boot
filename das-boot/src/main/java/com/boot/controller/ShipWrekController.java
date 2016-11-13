package com.boot.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;

@RestController
@RequestMapping("/api/v1/")
public class ShipWrekController {

	@RequestMapping(value ="shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> getlist()
	{
		return ShipwreckStub.list();
	}
	
	@RequestMapping(value ="shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck getwreck(@PathVariable Long id)
	{
		return ShipwreckStub.get(id);
	}
	
	@RequestMapping(value ="shipwrecks", method = RequestMethod.POST)
	public Shipwreck create( @RequestBody Shipwreck wreck)
	{
		return ShipwreckStub.create(wreck);
	}
	
	@RequestMapping(value ="shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id , @RequestBody Shipwreck  wreck )
	{
		return ShipwreckStub.update(id, wreck);
	}
	@RequestMapping(value ="shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck getlist(@PathVariable Long id)
	{
		return ShipwreckStub.delete(id);
	}
	
}
