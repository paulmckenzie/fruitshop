package fruitshop

import fruitshop.PriceList.{OrangePrice, ApplePrice}
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar.mock
import org.scalatest.{BeforeAndAfter, FreeSpec, Matchers}

class ShoppingCartTest extends FreeSpec with Matchers with BeforeAndAfter {


  "A shopping cart" - {
    "is constructed with a price list" in {
      ShoppingCart(mock[PriceList])
    }

    "with inputs" - {
      val priceList = mock[PriceList]
      when(priceList.getPrice(Apple())).thenReturn(ApplePrice)
      when(priceList.getPrice(Orange())).thenReturn(OrangePrice)
      val cart = ShoppingCart(priceList)

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