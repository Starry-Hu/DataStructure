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

import domain.Car;
import service.CarException;
import service.CarService;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		CarService carService = new CarService();
		String carId = request.getParameter("carId");
		String outTime = request.getParameter("outTime");

		Map<String, Object> result_map = new HashMap<>();
		try {
			/**
			 * 离开停车场
			 */
			Car deleteCar = carService.deleteCarFromPark(carId, outTime);
			double duration = Double.parseDouble(outTime) - Double.parseDouble(deleteCar.getInTime());
			double money = deleteCar.getMoney();

			result_map.put("code", 200);
			result_map.put("delete_data", deleteCar);
			result_map.put("duration", duration);
			result_map.put("money", money);

			result_map.put("msg", "成功离开停车场！ 用时" + duration + "费用为" + money);

		} catch (CarException e) {
			// 没有找到指定的车辆
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
