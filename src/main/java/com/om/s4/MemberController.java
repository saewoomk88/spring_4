package com.om.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.om.member.MemberDTO;
import com.om.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="join")
	public void join()throws Exception{
	}//void 면 자기 url 주소 /member/join
	
	//회원가입
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String joinPost(MemberDTO memberDTO, RedirectAttributes rd) throws Exception{
		
		int result = memberService.join(memberDTO);
		String path="redirect:../"; //홈컨트롤러를 거쳐서 가야되니까 루트밑에..
		
		if(result<1) {
			path="redirect:./join";
			rd.addFlashAttribute("msg", "가입실패");
		}
		return path;
	}
	//중복확인
	@RequestMapping(value="idCheck")
	public String idCheck(String id, Model model) throws Exception{
		MemberDTO memberDTO=memberService.idCheck(id);
		/*int result =0 >>사용 불가능
				result = 1 >> 사용가능*/
		int result =0;
		if(memberDTO==null) {
			result =1;
		}
		model.addAttribute("result", result);
		return "common/result";
	}
	
	//로그인
	@RequestMapping(value="login")
	public String login() throws Exception{
		
		return "member/login";
	}
	//로그인처리
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginPost(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception{
		memberDTO=memberService.login(memberDTO);
		String path="";
		
		if(memberDTO !=null) {
			//1번째 방법 : 매개변수를 받아서 리퀘스트 겟세션을 해서 어트리뷰트로 넘겨줌.
			//HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
			
			path ="redirect:../";
		}else {
			path ="redirect:./login";
			rd.addFlashAttribute("msg", "로그인실패");
		}
		
		return path;
	}
	
	@RequestMapping(value="myPage")
	public void myPage() throws Exception{
	}
	
	@RequestMapping(value="update")
	public void update() throws Exception{
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception{
		MemberDTO sMemberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO.setId(sMemberDTO.getId());
		int result = memberService.update(memberDTO);
		if(result>0) {
			memberDTO.setGrade(sMemberDTO.getGrade());
			session.setAttribute("member", memberDTO);
		}else {
			rd.addFlashAttribute("msg", "update Fail");
		}
		return "redirect:./myPage";
	}
	
	@RequestMapping(value="delete")
	public String delete(HttpSession session, RedirectAttributes rd) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result= memberService.delete(memberDTO.getId());
		String message="delete fail";
		if(result>0) {
			message ="Success";
			session.invalidate();//세션의 유지시간을 강제로 없애는 메서드
		}	
		rd.addFlashAttribute("msg", message);
		
		return "redirect:../";
	}
	
	@RequestMapping(value="logOut")
	public String logOut(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
}
