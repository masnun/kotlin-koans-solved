package ii_collections

import java.util.*

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
    return HashSet(this.customers.partition { it.getDeliveredOrdersCount() < it.getUnDeliveredOrdersCount() }.first)
}

fun Customer.getDeliveredOrdersCount(): Int {
    return this.orders.map { if (it.isDelivered) 1 else 0 }.sum()
}

fun Customer.getUnDeliveredOrdersCount(): Int {
    return this.orders.map { if (it.isDelivered) 0 else 1 }.sum()
}