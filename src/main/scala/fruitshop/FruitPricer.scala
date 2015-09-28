package fruitshop

trait FruitPricer[F <: Fruit] {
  def getPrice(quantity: Int): Price
}
