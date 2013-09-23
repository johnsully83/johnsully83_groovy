package com.home.service.model.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.home.dao.JpaDao;
import com.home.model.cloud.jpa.Guest;
import com.home.service.model.AbstractDtoService;

@Service("guestDtoService")
public class GuestDtoService extends AbstractDtoService<Guest, Integer> {

	@Autowired
	public GuestDtoService(@Qualifier("guestDao") JpaDao<Guest, Integer> guestDao) {
		super(guestDao);
	}

}
