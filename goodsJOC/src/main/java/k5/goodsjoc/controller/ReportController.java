package k5.goodsjoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Statistics_management/statistics")
public class ReportController {

		@GetMapping("goodsStatistics")
		public String goodsStatistics() {
			System.out.println("페이지: 상품통계 ");
			System.out.println("경로: Statistics_management/statistics/goodsStatistics(GET방식 성공) ");
			
			return "/Statistics_management/statistics/goodsStatistics";
		}
		@GetMapping("businessStatistics")
		public String businessStatistics() {
			System.out.println("페이지: 거래처통계 ");
			System.out.println("경로: Statistics_management/statistics/businessStatistics(GET방식 성공) ");
			
			return "/Statistics_management/statistics/businessStatistics";
		}
}
