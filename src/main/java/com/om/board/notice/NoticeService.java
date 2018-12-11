package com.om.board.notice;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.file.FileDAO;
import com.om.file.FileDTO;
import com.om.util.FileSaver;
import com.om.util.Pager;
@Service
public class NoticeService implements BoardService{
	
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO select(int num) throws Exception{
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("n");
		List<FileDTO> files=fileDAO.list(fileDTO);
		return noticeDAO.select(num);
	}
	
	public String select(int num, Model model, RedirectAttributes rd) throws Exception{
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("n");
		List<FileDTO> files=fileDAO.list(fileDTO);
		BoardDTO boardDTO= noticeDAO.select(num);
		String path="";
		if(boardDTO !=null) {
		model.addAttribute("dto", boardDTO);
		model.addAttribute("files", files);
		path="board/boardSelect";
		}else {
			path="./noticeList";
			rd.addFlashAttribute("msg", "해당 글이 존재하지 않습니다.");
		}
		return path;
		
	}
	
	public int insert(BoardDTO boardDTO) {
		return 0;
	}
	
	public int insert(BoardDTO boardDTO, MultipartFile f1, HttpSession session) throws Exception{
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/notice");
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setOname(f1.getOriginalFilename());
		fileDTO.setFname(fs.saveFile3(realPath, f1));
		fileDTO.setKind("n");
		
		int result =noticeDAO.insert(boardDTO);
		
		if(result<1) {
			throw new Exception();
		}
		
		
			
			result= fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		
		return result;
	}
	
	public int update(BoardDTO boardDTO) throws Exception{
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(int num) throws Exception{
		return noticeDAO.delete(num);
	}
	

	
	

}
