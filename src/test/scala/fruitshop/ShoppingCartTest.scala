package fruitshop

import fruitshop.ApplePricer.AppleUnitPrice
import fruitshop.Fruit.{Apple, FruitType, Orange}
import fruitshop.OrangePricer.OrangeUnitPrice
import org.mockito.Matchers.{anyLong => anyQuantity}
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar.mock
import org.scalatest.{BeforeAndAfter, FreeSpec, Matchers}

class ShoppingCartTest extends FreeSpec with Matchers with BeforeAndAfter {

  private val orangePricer = mock[FruitPricer]("orange pricer")
  private val applePricer = mock[FruitPricer]("apple pricer")
  private val pricers: Map[FruitType, FruitPricer] = Map(Apple -> applePricer, Orange -> orangePricer)

  before {
    reset(orangePricer, applePricer)
    when(orangePricer.apply(anyQuantity())).thenReturn(OrangeUnitPrice)
    when(applePricer.apply(anyQuantity())).thenReturn(AppleUnitPrice)
  }

  "A shopping cart" - {
    "is constructed with a price list" in {
      ShoppingCart(mock[Map[FruitType, FruitPricer]])
    }

    "with inputs" - {
      val cart = ShoppingCart(pricers)
      "Nothing" in {
        cart.checkout(List.empty) shouldBe 0L
        verifyNoMoreInteractions(applePricer, orangePricer)
      }

      "An orange" in {
        cart.checkout(List(Orange)) shouldBe OrangeUnitPrice
        verify(orangePricer).apply(1L)
        verifyNoMoreInteractions(applePricer)
      }

      "An apple" in {
        cart.checkout(List(Apple)) shouldBe AppleUnitPrice
        verify(applePricer).apply(1L)
        verifyNoMoreInteractions(orangePricer)
      }

      "A mix of fruit" in {
        cart.checkout(List(Apple, Apple, Orange, Apple, Orange)) shouldBe AppleUnitPrice + OrangeUnitPrice
        verify(applePricer).apply(3L)
        verify(orangePricer).apply(2L)
      }
    }
  }
}