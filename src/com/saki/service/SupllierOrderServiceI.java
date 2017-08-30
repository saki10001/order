package com.saki.service;

import java.util.List;
import java.util.Map;

import com.saki.model.TCompany;
import com.saki.model.TProduct;
import com.saki.model.TSupllierOrderDetail;

public interface SupllierOrderServiceI  extends BaseServiceI{


	List<Map<String, Object>> searchDetail(String id);

	List<TProduct> searchProduct();

	TSupllierOrderDetail getByDetailId(String string);

	void deleteByKey(String key);

	void getOrderDetail();

	void getSupllierOrder();

	void splitOrder(String id);

	int deleteDetailById(String orderId, String detailId);

	List<TCompany> searchCompany();
	
	public String updateDetail(String update) ;
}
