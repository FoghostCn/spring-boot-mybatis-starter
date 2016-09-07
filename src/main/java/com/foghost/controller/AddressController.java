package com.foghost.controller;

import com.foghost.base.Controller;
import com.foghost.mapper.AddressMapper;
import com.foghost.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController extends Controller{

	private final AddressMapper addressMapper;

	@Autowired
	private AddressController(final AddressMapper addressMapper) {
		Assert.notNull(addressMapper, "addressMapper must not be null");
		this.addressMapper = addressMapper;
	}

	@GetMapping("/{id}")
	public Address getById(@PathVariable final int id) throws Exception{
		return addressMapper.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Address createAddress(@RequestBody final Address address) {
		addressMapper.createAddress(address);
		return address;
	}

}