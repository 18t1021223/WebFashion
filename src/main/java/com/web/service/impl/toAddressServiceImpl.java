package com.web.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.web.dto.toAddressDto;
import com.web.service.toAddressService;

@Service
public class toAddressServiceImpl implements toAddressService {
	@PersistenceContext
	private EntityManager em;

	@Override
	public toAddressDto getToAddressDto(toAddressDto address) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_toAddress_select");
		proc.registerStoredProcedureParameter("provinceId", int.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("districtId", int.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("wardId", int.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);
		proc.setParameter("provinceId", Integer.parseInt(address.getProvince()));
		proc.setParameter("districtId", Integer.parseInt(address.getDistrict()));
		proc.setParameter("wardId", Integer.parseInt(address.getWard()));
		String text = (String) proc.getOutputParameterValue("result");
		if (text.equals(""))
			return null;
		String data[] = text.split("[|]");
		toAddressDto dto = new toAddressDto();
		dto.setProvince(data[0]);
		dto.setDistrict(data[1]);
		if (data.length > 2)
			dto.setWard(data[2]);
		dto.setName(address.getName());
		dto.setPhone(address.getPhone());
		dto.setStreet(address.getStreet());
		return dto;
	}

}
