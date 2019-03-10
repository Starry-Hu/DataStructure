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
import service.QueueException;
import service.StackException;

/**
 * Servlet implementation class ArriveFromSideServlet
 */
@WebServlet("/ArriveFromSideServlet")
public class ArriveFromSideServlet extends HttpServlet {
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
			/**
			 * 过道上的车入停车场
			 */
			
			int index = carService.addCarToParkFromSide(carId, inTime);
//			carService.deleteCarFromSide(carId);  //private
			
			String mString = "进入停车场成功 \r 位置下标为" + index;
			result_map.put("code", 200);
			result_map.put("msg", mString);
			result_map.put("index", "停车场" + index);

		} catch (QueueException e) {
			result_map.put("code", 300);
			result_map.put("msg", e.getMessage());
		} catch (StackException e) {
			result_map.put("code", 400);
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
