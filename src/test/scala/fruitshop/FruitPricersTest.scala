package fruitshop

import fruitshop.ApplePricer.AppleUnitPrice
import fruitshop.OrangePricer.OrangeUnitPrice
import org.scalatest.{FreeSpec, Matchers}

class FruitPricersTest extends FreeSpec with Matchers {
  "Special Offers" - {
    "Apples are BOGOF" - {
      "an apple" in {
        ApplePricer(1) shouldBe AppleUnitPrice
      }

      "one paid-for apple, one free apple" in {
        ApplePricer(2) shouldBe AppleUnitPrice
      }

      "two paid-for apples, one free apple" in {
        ApplePricer(3) shouldBe 2 * AppleUnitPrice
      }

      "twenty-two paid-for apples, twenty-two free apples" in {
        ApplePricer(44) shouldBe 22 * AppleUnitPrice
      }

      "twenty-three paid-for apples, twenty-two free apples" in {
        ApplePricer(45) shouldBe 23 * AppleUnitPrice
      }
    }

    "Oranges are three for two" - {
      "an orange" in {
        OrangePricer(1) shouldBe OrangeUnitPrice
      }

      "two oranges" in {
        OrangePricer(2) shouldBe 2 * OrangeUnitPrice
      }

      "three oranges, pay for two" in {
        OrangePricer(3) shouldBe 2 * OrangeUnitPrice
      }

      "thirty three oranges, pay for twenty two" in {
        OrangePricer(33) shouldBe 22 * OrangeUnitPrice
      }

      "thirty four oranges, pay for twenty three" in {
        OrangePricer(34) shouldBe 23 * OrangeUnitPrice
      }

      "thirty five oranges, pay for twenty four" in {
        OrangePricer(35) shouldBe 24 * OrangeUnitPrice
      }

      "thirty six oranges, pay for twenty four" in {
        OrangePricer(36) shouldBe 24 * OrangeUnitPrice
      }
    }
  }
}


