package com.johnsully83.service.model.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnsully83.dao.JpaDao;
import com.johnsully83.model.cloud.jpa.Guest;
import com.johnsully83.service.model.AbstractDtoService;

@Service("guestDtoService")
public class GuestDtoService extends AbstractDtoService<Guest, Integer> {

	@Autowired
	public GuestDtoService(@Qualifier("guestDao") JpaDao<Guest, Integer> guestDao) {
		super(guestDao);
	}

}
