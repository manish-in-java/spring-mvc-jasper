package org.example.web.controller.report

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Order History Summary controller.
 */
@Controller
@RequestMapping(Array("/order/summary"))
class OrderSummaryReportController extends OrderReportController("org/example/report/order/summary.jrxml", "report/order/summary") {
  /**
   * {@inheritDoc}
   */
  override protected def datasource = this.service.getMonthlySummary
}
