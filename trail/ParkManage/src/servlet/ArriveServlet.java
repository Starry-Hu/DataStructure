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

import service.CarService;
import service.StackException;
import service.QueueException;

/**
 * Servlet implementation class ArriveServlet
 */
@WebServlet("/ArriveServlet")
public class ArriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		CarService carService = new CarService();
		String carId = request.getParameter("carId");
		String inTime = request.getParameter("inTime");

		Map<String, Object> result_map = new HashMap<>();

		try {
			int index = carService.addCarToPark(carId, inTime);
			String mString = "进入停车场成功 \r位置下标为" + index;

			result_map.put("code", 200);
			result_map.put("msg", mString);
			result_map.put("index", "停车场"+ index);

		} catch (StackException e) {
			try {
				int index = carService.addCarToSide(carId);
				result_map.put("code", 300);
				result_map.put("msg", e.getMessage() + "进入过道等候\r位置下标为" + index);
				result_map.put("index", "过道"+ index);


			} catch (QueueException e1) {
				result_map.put("code", 400);
				result_map.put("msg", e.getMessage() + "无法停车");
				
			}

		} finally {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result_map);

			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

}
