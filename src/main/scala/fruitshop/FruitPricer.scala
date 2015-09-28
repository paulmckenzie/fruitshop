package fruitshop

object ApplePricer extends FruitPricer {
  val AppleUnitPrice = 60L

  override def apply(quantity: Quantity): Price = ((quantity / 2) + (quantity % 2)) * AppleUnitPrice
}

object OrangePricer extends FruitPricer {
  val OrangeUnitPrice = 25L

  override def apply(quantity: Quantity): Price = ((2 * (quantity / 3)) + (quantity % 3)) * OrangeUnitPrice
}