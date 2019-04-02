package sample.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import sample.model.MemberVo;

@Mapper
public interface MemberMapper {
	
	List<MemberVo> list (MemberVo memberVo);
	
	int count (MemberVo memberVo);
	
	MemberVo view (MemberVo memberVo);
	
	void update (MemberVo memberVo);
	
	void insert (MemberVo memberVo);
	
	void delete (MemberVo memberVo);
	
}
