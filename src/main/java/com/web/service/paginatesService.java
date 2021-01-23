package com.web.service;

import com.web.dto.paginateDto;

public interface paginatesService {
	
	paginateDto getInfo(long totalData,int page,int pageSize , int orderBy, int limit);
}
