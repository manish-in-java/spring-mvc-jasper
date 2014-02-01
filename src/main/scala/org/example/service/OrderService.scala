package org.example.service

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.List

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

import org.example.data.OrderRepository
import org.example.domain.OrderMonthlySummary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Business logic operations on {@link Order}.
 */
@Component
class OrderService {
  @Autowired
  var repository: OrderRepository = _

  /**
   * Gets the month-wise summary of orders.
   *
   * @return A {@link List} of {@link OrderMonthlySummary}s.
   */
  def getMonthlySummary = asJavaList(this.repository.findAll.groupBy(order => OrderService.monthFormatter.format(order.date))
    .toSeq
    .map(group => OrderMonthlySummary(group._1, group._2
      .map(order => order.total)
      .foldLeft(BigDecimal.ZERO)(_.add(_)))))

  /**
   * Gets all available orders.
   *
   * @return A {@link List} of {@link Order}s.
   */
  def getOrders = this.repository.findAll
}

private object OrderService {
  private val monthFormatter = new SimpleDateFormat("MMMM yyyy")
}
