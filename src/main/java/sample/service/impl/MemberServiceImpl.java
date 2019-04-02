package sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import sample.mapper.MemberMapper;
import sample.model.MemberVo;
import sample.service.MemberService;

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {
	
	@Resource(name="memberMapper")
	private MemberMapper memberMapper;

	@Override
	public List<MemberVo> list(MemberVo memberVo) throws Exception {
		return memberMapper.list(memberVo);
	}

	@Override
	public MemberVo view(MemberVo memberVo) throws Exception {
		return memberMapper.view(memberVo);
	}

	@Override
	public int count(MemberVo memberVo) throws Exception {
		return memberMapper.count(memberVo);
	}

	@Override
	public void update(MemberVo memberVo) throws Exception {
		memberMapper.update(memberVo);
	}

	@Override
	public void delete(MemberVo memberVo) throws Exception {
		memberMapper.delete(memberVo);
	}

	@Override
	public void insert(MemberVo memberVo) throws Exception {
		memberMapper.insert(memberVo);
	}

}
