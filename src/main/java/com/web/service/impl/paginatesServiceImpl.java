package com.web.service.impl;

import org.springframework.stereotype.Service;

import com.web.dto.paginateDto;
import com.web.service.paginatesService;

@Service
public class paginatesServiceImpl implements paginatesService {

	@Override
	public paginateDto getInfo(long totalData, int page, int pageSize, int orderBy, int limit) {
		paginateDto pag = new paginateDto();
		pag.setPageSize(pageSize);
		pag.setTotalPage(getTotalPage(totalData, pageSize));
		pag.setPage(getPageCurrent(pag.getTotalPage(), page));
		pag.setOrderBy(orderBy);
		pag = numberPageView(pag, pag.getPage(), limit, pag.getTotalPage());
		return pag;
	}

	/**
	 * NẾU TOTALPAGE LÀ SỐ THÂP PHÂN THÌ CỘNG THÊM 1 VÀ LẤY PHẦN NGUYÊN NẾU LÀ SỐ
	 * NGUYÊN THÌ KIỂM TRA TỔNG DỮ LIỆU = 0 NẾU ĐÚNG THÌ TRẢ VỀ 1 , NẾU KHÔNG THÌ
	 * TRẢ VỀ TOTALPAGE
	 */
	private int getTotalPage(long totalData, int pageSize) {
		float totalPage = totalData / pageSize;
		return (int) ((float) totalData % (float) pageSize == 0 ? (totalData == 0 ? 1 : totalPage) : totalPage + 1);
	}

	private int getPageCurrent(int totalPage, int page) {
		if (page < 1)
			return 1;
		else if (page > totalPage)
			return totalPage;
		return page;
	}

	private paginateDto numberPageView(paginateDto pag, int page, int limit, int totalPage) {
		int start = page - 2;
		int end = page + 2;
		if (start <= 0) {
			start = 1;
			// NẾU TỔNG TRANG BÉ HƠN TRANG HIEN THỊ THÌ TRẢ TRANG HIỂN THỊ BẰNG TONG TRANG
			end = limit > totalPage ? totalPage : limit;
		} else if (end > totalPage) {
			end = totalPage;
			// NẾU START LỚN HƠN END THÌ START = 1 VÀ END = TỔNG TRANG
			start = limit - 1 > end ? 1 : limit - 1;
		}
		pag.setStart(start);
		pag.setEnd(end);
		pag.setPageLimit(limit);
		return pag;
	}
}
