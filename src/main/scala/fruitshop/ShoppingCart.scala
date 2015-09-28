package fruitshop

import fruitshop.Fruit.FruitType

case class ShoppingCart(pricers: Map[FruitType, FruitPricer]) {

  def checkout(items: List[FruitType]): Price = items.groupBy(fruitType => fruitType) map { case (fruitType, itemsOfSameFruit) => pricers(fruitType)(itemsOfSameFruit.size) } sum
}

