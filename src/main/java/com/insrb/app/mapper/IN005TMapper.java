package com.insrb.app.mapper;

import java.util.List;
import java.util.Map;

public interface IN005TMapper {
	String getCurrentDateTime();

	int insert(String email, String name, String teltype, String mobile, String pwd, String jumina, String sex, String utype);

	// Test에서 사용된 user 삭제할 때만 사용하고, 실재 웹 서비스는 하지 않는다.
	void delete(String email);

	Map<String, Object> selectById(String id);

	void selectAll(Map<String, Object> out);

	List<Map<String, Object>> findId(String name, String teltype, String mobile, String jumina, String sex);

	void updatePwd(String id, String newPwd);

	void updateJuminb(String id, String encJuminb);

	void updateBasic(String id, String name, String teltype, String mobile, String jumina, String sex);

	void updateUseYN(String id, String useYn);
}
