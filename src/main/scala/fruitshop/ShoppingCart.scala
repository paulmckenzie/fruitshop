package fruitshop

import fruitshop.Fruit.FruitType

case class ShoppingCart(pricers: Map[FruitType, FruitPricer]) {

  def checkout(items: List[FruitType]): Price = items.groupBy(ft => ft) map { case (ft, itemsOfSameFruit) => pricers(ft)(itemsOfSameFruit.size) } sum
}

