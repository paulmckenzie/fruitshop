package fruitshop

import org.scalatest.{FreeSpec, Matchers}

class ShoppingCartTest extends FreeSpec with Matchers {

  "A shopping cart" - {
    "with inputs" - {
      "Nothing" in {
        ShoppingCart.checkout(List.empty) shouldBe 0L
      }
    }
  }
}
