package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
    private static final List<Map<String, String>> MOCK_LIST;

    static {
        MOCK_LIST = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("num", i+" ");
            map.put("name", "이름" + i);
            map.put("age", i + "살");
            map.put("address", "서울 어딘가");
            MOCK_LIST.add(map);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8"); // JSON 타입으로 설정
        PrintWriter out = response.getWriter();
        
        String json = gson.toJson(MOCK_LIST); // MOCK_LIST를 JSON 형태로 변환
        out.print(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
