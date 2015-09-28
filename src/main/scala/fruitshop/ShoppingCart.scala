package fruitshop

case class ShoppingCart(priceList: PriceList) {

  def checkout(items: List[Fruit]): Long = items.map(priceList.getPrice).sum

}
