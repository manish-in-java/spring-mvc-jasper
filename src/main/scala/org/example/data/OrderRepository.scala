package org.example.data

import java.util.List

import org.example.domain.Order

/**
 * Contract for data access operations on {@link Order}.
 */
trait OrderRepository {
  /**
   * Finds all available orders.
   *
   * @return A {@link List} of {@link Order}s.
   */
  def findAll: List[Order]
}
