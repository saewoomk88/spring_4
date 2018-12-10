package com.om.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.om.board.BoardDTO;
import com.om.board.qna.QnaDTO;
import com.om.board.qna.QnaService;
import com.om.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		
		List<BoardDTO> ar =qnaService.list(pager);
		
		mv.addObject("board", "qna")
		.addObject("list", ar)
		.addObject("pager", pager)
		.setViewName("board/boardList");
		return mv;
		
	}
	
	@RequestMapping(value="qnaSelect")
	public ModelAndView select(int num, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO=qnaService.select(num);
		String path = "";
		if(boardDTO !=null) {
			path = "board/boardSelect";
			mv.addObject("dto", boardDTO);
		}else {
			path="redirect:./qnaList";
		}
		rd.addFlashAttribute("msg", "Fail");
		mv.addObject("board", "qna")
		.setViewName(path);
		
		return mv;
	}
	
	@RequestMapping(value="qnaWrite")
	public ModelAndView qnaWrite() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna")
		.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public ModelAndView qnaWrite2(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.insert(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "fail");
		}
		System.out.println("qna write");
		mv.addObject("board", "qna")
		.setViewName("redirect:./qnaList");
		return mv;
	}
	
	@RequestMapping(value="qnaUpdate")
	public ModelAndView qnaUpdate(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		BoardDTO boardDTO= qnaService.select(num);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public ModelAndView qnaUpdate2(BoardDTO boardDTO, RedirectAttributes rd) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.update(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "update Fail");
		}
		mv.addObject("board", "qna")
		.setViewName("redirect:./qnaSelect?num="+boardDTO.getNum());
		return mv;
	}
	
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public String qnaDelete(int num, RedirectAttributes rd) throws Exception {
		
		int result = qnaService.delete(num);
		if(result<1) {
			rd.addFlashAttribute("msg", "delete Fail");
		}
		
		
		return "redirect:./qnadList";
	}
	
	@RequestMapping(value="qnaReply")
	public ModelAndView qnaReply(int num) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna")
		.addObject("num", num)
		.setViewName("board/boardReply");
		return mv;
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public ModelAndView qnaReply2(QnaDTO qnaDTO, RedirectAttributes rd) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.addObject("board", "qna")
		.setViewName("redirect:./qnaList?num="+qnaDTO.getNum());
		return mv;
	}
}
