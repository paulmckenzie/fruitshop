package fruitshop

object ApplePricer extends FruitPricer {
  val AppleUnitPrice = 60L

  override def apply(quantity:Int): Price = ((quantity / 2) + (quantity % 2)) * AppleUnitPrice
}

object OrangePricer extends FruitPricer {
  val OrangeUnitPrice = 25L

  override def apply(quantity:Int): Price = ((2 * (quantity / 3)) + (quantity % 3)) * OrangeUnitPrice
}