package sample.service;

import java.util.List;

import sample.model.MemberVo;

public interface MemberService {

	List<MemberVo> list (MemberVo memberVo) throws Exception;
	
	MemberVo view (MemberVo memberVo) throws Exception;
	
	int count (MemberVo memberVo) throws Exception;
	
	void update (MemberVo memberVo) throws Exception;
	
	void delete (MemberVo memberVo) throws Exception;
	
	void insert (MemberVo memberVo) throws Exception;
}
