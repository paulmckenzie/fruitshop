package fruitshop


object PriceList {
  val OrangePrice = 25L
  val ApplePrice = 60L
}

trait PriceList {
  def getPrice(fruit: Fruit, quantity: Int = 1): Price
}
