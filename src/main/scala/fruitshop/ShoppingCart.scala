package fruitshop

case class ShoppingCart(priceList: PriceList) {

  def checkout(items: List[Fruit]): Price = items.map(priceList.getPrice).sum

}
