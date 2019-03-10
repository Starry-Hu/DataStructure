package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import service.DataBaseService;

/**
 * Servlet implementation class ChangeParkServlet
 */
@WebServlet("/ChangeParkServlet")
public class ChangeParkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		DataBaseService dataBaseService = new DataBaseService();
		Map<String, Object> result_map = new HashMap<>();

		try {
			int parkSize = Integer.parseInt(request.getParameter("parkSize"));
			int waitSize = Integer.parseInt(request.getParameter("waitSize"));
			int price = Integer.parseInt(request.getParameter("price"));
			dataBaseService.change(parkSize, waitSize, price);
			result_map.put("code", 200);
			result_map.put("msg", "修改停车场系统成功");

		} catch (Exception e) {
			result_map.put("code", 300);
			result_map.put("msg", e.getMessage());

		} finally {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result_map);

			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

}
