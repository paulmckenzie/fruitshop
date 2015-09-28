package fruitshop

import fruitshop.StubPriceList.{ApplePrice, OrangePrice}
import org.scalatest.{FreeSpec, Matchers}

class ShoppingCartTest extends FreeSpec with Matchers {

  "A shopping cart" - {
    "is constructed with a price list" in {
      ShoppingCart(StubPriceList)
    }

    "with inputs" - {
      val cart = ShoppingCart(StubPriceList)

      "Nothing" in {
        cart.checkout(List.empty) shouldBe 0L
      }

      "An orange" in {
        cart.checkout(List(Orange())) shouldBe OrangePrice
      }

      "An apple" in {
        cart.checkout(List(Apple())) shouldBe ApplePrice
      }

      "A mix of fruit" in {
        cart.checkout(List(Apple(), Apple(), Apple(), Orange(), Orange())) shouldBe (ApplePrice * 3) + (OrangePrice * 2)
      }
    }
  }
}

object StubPriceList extends PriceList {
  val OrangePrice = 25L
  val ApplePrice = 60L
  private val prices: Map[Fruit, Long] = Map(Orange() -> OrangePrice, Apple() -> ApplePrice)

  override def getPrice(fruit: Fruit): Long = prices(fruit)
}