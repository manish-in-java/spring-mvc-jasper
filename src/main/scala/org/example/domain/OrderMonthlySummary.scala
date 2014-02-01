package org.example.domain

import java.math.BigDecimal

import scala.beans.BeanProperty

/**
 * Represents the summary of orders for a month.
 */
case class OrderMonthlySummary(@BeanProperty val month: String, @BeanProperty total: BigDecimal)
