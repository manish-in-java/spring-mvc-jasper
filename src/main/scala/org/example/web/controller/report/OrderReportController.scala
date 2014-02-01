package org.example.web.controller.report

import java.util.Collection
import org.example.service.OrderService
import org.example.web.report.jasper.JasperReportGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.{ RequestMapping, RequestMethod }
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import javax.servlet.http.HttpServletRequest

/**
 * An Order Report controller.
 */
abstract class OrderReportController(val report: String, val page: String) {
  @Autowired
  protected var service: OrderService = _

  /**
   * Generates an Excel version of the Order Report.
   */
  @RequestMapping(Array("excel"))
  def excel(response: HttpServletResponse) {
    JasperReportGenerator.generateExcel(report, this.datasource, response)
  }

  /**
   * Generates an HTML version of the Order Report.
   */
  @RequestMapping(Array("html"))
  def html(request: HttpServletRequest, response: HttpServletResponse) {
    JasperReportGenerator.generateHTML(report, this.datasource, request, response)
  }

  /**
   * Generates a PDF version of the Order Report.
   */
  @RequestMapping(Array("pdf"))
  def pdf(response: HttpServletResponse) {
    JasperReportGenerator.generatePDF(report, this.datasource, response)
  }

  /**
   * Displays the Order Report page.
   */
  @RequestMapping(method = Array(RequestMethod.GET))
  def show = this.page

  /**
   * Gets the data source for the report.
   */
  protected def datasource: Collection[_]
}
