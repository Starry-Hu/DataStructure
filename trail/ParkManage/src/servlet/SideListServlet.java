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

import service.QueueService;

import domain.Car;

/**
 * Servlet implementation class SideListServlet
 */
@WebServlet("/SideListServlet")
public class SideListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		QueueService queueService = new QueueService();
		Map<String, Object> result_map = new HashMap<>();
		try {
			Car[] cars = queueService.getCars();
			int count = queueService.getCapacity();

			result_map.put("code", 200);
			result_map.put("count", count);
			result_map.put("data", cars);
			result_map.put("msg", "获取成功！");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result_map);

			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

}
