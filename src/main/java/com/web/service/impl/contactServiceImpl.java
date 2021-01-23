package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.contact;
import com.web.repository.contactRepository;
import com.web.service.contactService;

@Service
public class contactServiceImpl implements contactService {
	@Autowired
	private contactRepository contactRepository;

	@Override
	public contact findTop1() {
		List<contact> data = contactRepository.findAll();
		return data.size() > 0 ? data.get(0) : null;
	}

}
