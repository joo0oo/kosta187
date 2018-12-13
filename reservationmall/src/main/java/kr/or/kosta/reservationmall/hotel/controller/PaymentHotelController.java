package kr.or.kosta.reservationmall.hotel.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.hotel.service.HotelPaymentService;
import kr.or.kosta.reservationmall.hotel.service.HotelPaymentServiceImpl;

public class PaymentHotelController implements Controller{
	private HotelPaymentService hotelPaymentService;
	Logger logger = Logger.getLogger(Controller.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
	
		String hotel_id = request.getParameter("hotel_id");
		String user_id = request.getParameter("user_id");
		int totalPrice2 = Integer.parseInt(request.getParameter("totalPrice2"));
		String[] roomIdList = request.getParameter("room_id_list").split(",");
		String reservation_start_day = request.getParameter("reservationStartDay");
		String reservation_end_day = request.getParameter("reservationEndDay");

		PrintWriter out = null;
		String resultType = null;
		
		Map<String, Integer> roomIdDupleCheckList = new HashMap<>();
		
		for(int j = 0; j < roomIdList.length; j++) {
			if(roomIdDupleCheckList.containsKey(roomIdList[j].trim())) {
				int tempVal = roomIdDupleCheckList.get(roomIdList[j].trim())+1;
				roomIdDupleCheckList.remove(roomIdList[j].trim());
				roomIdDupleCheckList.put(roomIdList[j].trim(), tempVal);
			}else{
				roomIdDupleCheckList.put(roomIdList[j].trim(), 1);
			}	

		}
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		hotelPaymentService = (HotelPaymentService)factory.getBean(HotelPaymentServiceImpl.class);
		try {
			for(int i=  0; i<roomIdList.length; i++) {
				if(hotelPaymentService.checkHotelReserve(hotel_id.trim(), roomIdList[i].trim(), reservation_start_day.trim(), reservation_end_day.trim(),roomIdDupleCheckList.get(roomIdList[i].trim()))){
					resultType="default";
				}else {
					resultType="existReserve";
					break;
				}
			}
			if(!resultType.equals("existReserve")) {
				resultType="default";
				if(hotelPaymentService.addHotelPayment(hotel_id+user_id+ totalPrice2, totalPrice2)) {
					resultType="success";
					String paymentId = hotelPaymentService.getPaymentId(hotel_id+user_id+ totalPrice2);
					for(int r = 0 ; r < roomIdList.length; r++) {
						hotelPaymentService.addHotelReserve(reservation_start_day, reservation_end_day, user_id, Integer.parseInt(paymentId), roomIdList[r].trim(), Integer.parseInt(hotel_id));
					}
				}
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/plain; charset=utf-8");
		try {
			out = response.getWriter();
			out.println(resultType);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(),e);
		}
		
		return null;
	}
}
