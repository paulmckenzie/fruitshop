package fruitshop

trait PriceList {
  def getPrice(fruit: Fruit): Price
}
