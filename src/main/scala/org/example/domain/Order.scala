package org.example.domain

import java.lang.Long
import java.math.BigDecimal
import java.util.Date

import scala.reflect.BeanProperty

/**
 * Represents an order.
 */
case class Order(@BeanProperty val id: Long, @BeanProperty val date: Date, @BeanProperty val customer: String, @BeanProperty val total: BigDecimal)
