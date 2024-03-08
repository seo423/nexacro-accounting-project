package kr.co.seoulit.erp.account.operate.system.controller;

import java.util.List;

import kr.co.seoulit.erp.account.operate.system.service.BoardService;
import kr.co.seoulit.erp.account.operate.system.to.BoardReqDTO;
import kr.co.seoulit.erp.account.operate.system.to.BoardResDTO;
import kr.co.seoulit.erp.account.sys.common.dao.DatasetToBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nexacro.java.xapi.data.PlatformData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/acc/operate")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private DatasetToBeanMapper datasetToBeanMapper;

	// 게시판 조회
	@RequestMapping("/findBoardList")
	public void findBoardList(@RequestAttribute("reqData")PlatformData reqData,
							  @RequestAttribute("resData")PlatformData resData) throws Exception {

		System.out.println("게시판 조회 Rest API");

		List<BoardResDTO> boardList = boardService.findBoardList();
		datasetToBeanMapper.beansToDataset(resData, boardList, BoardResDTO.class);
	}

	// 게시판 상세 조회
	@RequestMapping("/findBoardDetail")
	public void findBoardDetail(@RequestAttribute("reqData")PlatformData reqData,
								@RequestAttribute("resData")PlatformData resData) throws Exception {

		String boardInfo = reqData.getVariable("bno").getString();
		System.out.println("게시글 : "+ boardInfo + " 상세 조회 Rest API");

		BoardResDTO boardDetail = boardService.findBoardDetail(boardInfo);
		datasetToBeanMapper.beanToDataset(resData, boardDetail, BoardResDTO.class);
	}

	// 게시판 추가
	@RequestMapping("/insertBoard")
	public void insertBoard(@RequestAttribute("reqData") PlatformData reqData,
							@RequestAttribute("resData")PlatformData resData) throws Exception {

		BoardReqDTO boardReqDTO = datasetToBeanMapper.datasetToBean(reqData, BoardReqDTO.class);
		System.out.println("게시판 추가 Rest API "+ boardReqDTO);

		boardService.insertBoard(boardReqDTO);
	}

	// 게시판 수정
	@RequestMapping("/updateBoard")
	public void updateBoard(@RequestAttribute("reqData")PlatformData reqData,
							@RequestAttribute("resData")PlatformData resData) throws Exception {

		BoardReqDTO boardReqDTO = datasetToBeanMapper.datasetToBean(reqData, BoardReqDTO.class);
		System.out.println("게시판 수정 Rest API "+ boardReqDTO);

		boardService.updateBoard(boardReqDTO);
	}

	// 게시판 삭제
	@RequestMapping("/deleteBoard")
	public void deleteBoard(@RequestAttribute("reqData")PlatformData reqData,
							@RequestAttribute("resData")PlatformData resData) throws Exception {

		String boardId = reqData.getVariable("bno").getString();
		System.out.println("게시글 : " + boardId + "삭제 Rest API");

		boardService.deleteBoard(boardId);
	}


}
