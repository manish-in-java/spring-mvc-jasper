package org.example.data

import java.math.BigDecimal
import java.util.ArrayList
import java.util.Collections
import java.util.Date
import java.util.List

import org.example.domain.Order
import org.springframework.stereotype.Component

/**
 * Provides data access operations on an in-memory order data store.
 */
@Component
class OrderMemoryRepository extends OrderRepository {
  /**
   * {@inheritDoc}
   */
  def findAll = Collections.unmodifiableList(OrderMemoryRepository.ORDERS)
}

private object OrderMemoryRepository {
  private val year = new Date().getYear

  private val ORDERS = new ArrayList[Order]

  ORDERS.add(Order(1, date(1, 1), "John", amount(3.95)))
  ORDERS.add(Order(2, date(1, 3), "Christopher", amount(2.91)))
  ORDERS.add(Order(2, date(1, 7), "Miles", amount(4.37)))
  ORDERS.add(Order(2, date(1, 8), "George", amount(6.43)))
  ORDERS.add(Order(3, date(1, 11), "Peter", amount(8.25)))
  ORDERS.add(Order(4, date(1, 17), "Norman", amount(5.16)))
  ORDERS.add(Order(5, date(1, 19), "Jacob", amount(12.14)))
  ORDERS.add(Order(6, date(1, 28), "Michael", amount(4.69)))
  ORDERS.add(Order(7, date(1, 31), "Brian", amount(11.09)))
  ORDERS.add(Order(8, date(2, 4), "Adrian", amount(10.52)))
  ORDERS.add(Order(9, date(2, 12), "Stephen", amount(3.66)))
  ORDERS.add(Order(10, date(2, 21), "Erica", amount(4.23)))
  ORDERS.add(Order(11, date(2, 22), "Amish", amount(8.74)))
  ORDERS.add(Order(12, date(2, 24), "Graham", amount(4.38)))
  ORDERS.add(Order(13, date(2, 26), "Jonathan", amount(15.51)))
  ORDERS.add(Order(14, date(3, 9), "Lily", amount(5.31)))
  ORDERS.add(Order(15, date(3, 14), "Frank", amount(29.95)))
  ORDERS.add(Order(16, date(3, 15), "Lloyd", amount(11.26)))
  ORDERS.add(Order(17, date(3, 19), "Britany", amount(3.12)))
  ORDERS.add(Order(18, date(3, 22), "Caleb", amount(6.73)))
  ORDERS.add(Order(19, date(3, 25), "Barbara", amount(13.55)))
  ORDERS.add(Order(20, date(3, 27), "Kilian", amount(0.99)))

  private def amount(value: Double) = new BigDecimal(value)
  private def date(month: Int, day: Int) = new Date(year, month - 1, day)
}
