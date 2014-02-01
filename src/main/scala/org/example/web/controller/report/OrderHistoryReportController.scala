package org.example.web.controller.report

import org.example.service.OrderService
import org.example.web.report.jasper.JasperReportGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletResponse

/**
 * Order History Report controller.
 */
@Controller
@RequestMapping(Array("/order/history"))
class OrderHistoryReportController extends OrderReportController("org/example/report/order/history.jrxml", "report/order/history") {
  /**
   * {@inheritDoc}
   */
  override protected def datasource = this.service.getOrders
}
