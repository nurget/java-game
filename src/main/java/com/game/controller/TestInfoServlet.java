//package com.game.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.game.common.CommonView;
//import com.game.service.TestInfoService;
//import com.game.service.impl.TestInfoServiceImpl;
//import com.google.gson.Gson;
//
//
//@WebServlet("/test-info/*")
//public class TestInfoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private TestInfoService tiService = new TestInfoServiceImpl();
//	private Gson gson = new Gson();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String cmd = CommonView.getCmd(request);
//		String json = "";
//		if("list".equals(cmd)) {
//			json = gson.toJson(tiService.selectTestInfoList(null));
//		} else if("view".equals(cmd) || "update".equals(cmd)) {
//	
//		}
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(json);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String cmd = CommonView.getCmd(request);
//		
//		Map<String,String> testInfo = new HashMap<>();
//		testInfo.put("uiId", request.getParameter("uiId"));
//		testInfo.put("uiName", request.getParameter("uiName"));
//		testInfo.put("uiPwd", request.getParameter("uiPwd"));
//		testInfo.put("uiDesc", request.getParameter("uiDesc"));
//		if(request.getParameter("uiBirth")!=null) {
//			testInfo.put("uiBirth", request.getParameter("uiBirth").replace("-", ""));
//		}
//		
//		if("insert".equals(cmd)) {
//			int result = tiService.insertTestInfo(testInfo);
//			request.setAttribute("msg", "유저 등록 성공");
//			request.setAttribute("url", "/user-info/login");
//			if(result!=1) {
//				request.setAttribute("msg", "유저 등록 실패");
//				request.setAttribute("url", "/user-info/insert");
//			}
//		}else if("update".equals(cmd)) {
//			String uiNum = request.getParameter("uiNum");
//			testInfo.put("uiNum", uiNum);
//			int result = tiService.updateTestInfo(testInfo);
//			request.setAttribute("msg", "유저 수정 성공");
//			request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
//			if(result!=1) {
//				request.setAttribute("msg", "유저 수정 실패");
//				request.setAttribute("url", "/user-info/update?uiNum=" + uiNum);
//			}
//		}else if("delete".equals(cmd)) {
//			String uiNum = request.getParameter("uiNum");
//			int result = tiService.deleteTestInfo(uiNum);
//			request.setAttribute("msg", "유저 삭제 성공");
//			request.setAttribute("url", "/user-info/list");
//			if(result!=1) {
//				request.setAttribute("msg", "유저 삭제 실패");
//				request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
//			}
//		}else if("login".equals(cmd)) {
//			HttpSession session = request.getSession();
//			String uiId = request.getParameter("uiId");
//			String uiPwd = request.getParameter("uiPwd");
//			Map<String,String> ui = tiService.login(uiId);
//			if(ui!=null) {
//				String dbUiPwd = ui.get("uiPwd");
//				if(uiPwd.equals(dbUiPwd)) {
//					request.setAttribute("msg", "로그인을 성공했습니다.");
//					request.setAttribute("url", "/");
//					session.setAttribute("user", ui);
//				}
//			}
//		}
//		CommonView.forwardMessage(request,response);
//	}
//}
