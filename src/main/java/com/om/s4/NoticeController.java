package com.om.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.om.board.BoardDTO;
import com.om.board.notice.NoticeDTO;
import com.om.board.notice.NoticeService;
import com.om.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		
		List<BoardDTO> ar =noticeService.list(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value="noticeSelect")
	public ModelAndView noticeSelect(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO =noticeService.select(num);
		mv.addObject("dto", boardDTO)
		.addObject("board", "notice")
		.setViewName("board/boardSelect");
		return mv;
	}
	
	//Insert
	@RequestMapping(value="noticeWrite")
	public ModelAndView noticeWrite(BoardDTO boardDTO){
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice")
		.setViewName("board/boardWrite");
	
		return mv;
	}
	
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public ModelAndView noticeWrite2(BoardDTO boardDTO, RedirectAttributes rd)  throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.insert(boardDTO);
		
		if(result<1) {
			rd.addFlashAttribute("msg", "Insert Fail");
		}
		
		mv.addObject("board", "notice")
		.setViewName("redirect:./noticeList");
	
		return mv;
	}
	
	//UPdate
	@RequestMapping(value="noticeUpdate")
	public ModelAndView noticeUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(boardDTO.getNum());
		System.out.println(boardDTO.getTitle());
		boardDTO =noticeService.select(boardDTO.getNum());
		
		mv.addObject("board", "notice")
		.addObject("dto", boardDTO)
		.setViewName("board/boardUpdate");
	
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public ModelAndView noticeUpdate2(BoardDTO boardDTO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.update(boardDTO);
		String msg = "Fail";
		if(result>0) {
			msg="Success";
		}
		rd.addFlashAttribute("msg", msg);
		mv.addObject("board", "notice")
		.setViewName("redirect:./noticeSelect?num="+boardDTO.getNum());
	
		return mv;
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public ModelAndView noticeDelete() {
		ModelAndView mv = new ModelAndView();
		System.out.println("notice Delete");
		mv.addObject("board", "notice")
		.setViewName("board/boardList");
	
		return mv;
	}
	
	

}
