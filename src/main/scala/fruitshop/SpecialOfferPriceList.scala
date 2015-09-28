package fruitshop

import fruitshop.PriceList._

case class SpecialOfferPriceList() extends PriceList {

  override def getPrice(fruit: Fruit, quantity: Int): Price = {
    if (fruit == Apple()) calculatePriceForApples(quantity)
    else calculatePriceForOranges(quantity)
  }

  private def calculatePriceForOranges(quantity: Int): Price = {
    ((2 * (quantity / 3)) + (quantity % 3)) * OrangePrice
  }

  private def calculatePriceForApples(quantity: Int): Price = {
    ((quantity / 2) + (quantity % 2)) * ApplePrice
  }
}
