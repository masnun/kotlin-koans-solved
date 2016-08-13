package ii_collections

import java.util.*

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return HashSet(this.customers.filter { product in it.orderedProducts })
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    return this.orders.filter { it.isDelivered  }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
}
