package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.OverInfoService;
import com.game.service.impl.OverInfoServiceImpl;
import com.google.gson.Gson;


@WebServlet("/over-info/*")
public class OverInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OverInfoService oiService = new OverInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(oiService.selectOverInfoList(null));
		} else if("view".equals(cmd) || "update".equals(cmd)) {
	
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		Map<String,String> overInfo = new HashMap<>();
		overInfo.put("oiId", request.getParameter("oiId"));
		overInfo.put("oiName", request.getParameter("oiName"));
		overInfo.put("oiPos", request.getParameter("oiPos"));
		overInfo.put("oiNat", request.getParameter("oiNat"));
	
		
		if("insert".equals(cmd)) {
			int result = oiService.insertOverInfo(overInfo);
			request.setAttribute("msg", "유저 등록 성공");
			request.setAttribute("url", "/user-info/login");
			if(result!=1) {
				request.setAttribute("msg", "유저 등록 실패");
				request.setAttribute("url", "/user-info/insert");
			}
		}else if("update".equals(cmd)) {
			String oiNum = request.getParameter("oiNum");
			overInfo.put("oiNum", oiNum);
			int result = oiService.updateOverInfo(overInfo);
			request.setAttribute("msg", "오버워치 게시판 수정 성공");
			request.setAttribute("url", "over-info/view?uiNum=" + oiNum);
			if(result!=1) {
				request.setAttribute("msg", "유저 수정 실패");
				request.setAttribute("url", "/over-info/update?oiNum=" + oiNum);
			}
		}else if("delete".equals(cmd)) {
			String oiNum = request.getParameter("oiNum");
			int result = oiService.deleteOverInfo(oiNum);
			request.setAttribute("msg", "유저 삭제 성공");
			request.setAttribute("url", "/over-info/list");
			if(result!=1) {
				request.setAttribute("msg", "유저 삭제 실패");
				request.setAttribute("url", "/over-info/view?oiNum=" + oiNum);
			}
		}
		CommonView.forwardMessage(request,response);
	}
}
