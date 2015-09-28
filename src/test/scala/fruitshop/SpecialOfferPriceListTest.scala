package fruitshop

import fruitshop.PriceList.{ApplePrice, OrangePrice}
import org.scalatest.{FreeSpec, Matchers}

class SpecialOfferPriceListTest extends FreeSpec with Matchers {
  private val priceList = SpecialOfferPriceList()

  "Special Offers" - {
    "Apples are BOGOF" - {
      "an apple" in {
        ApplePricer.getPrice(1) shouldBe ApplePrice
      }

      "one paid-for apple, one free apple" in {
        ApplePricer.getPrice(2) shouldBe ApplePrice
      }

      "two paid-for apples, one free apple" in {
        ApplePricer.getPrice(3) shouldBe 2 * ApplePrice
      }

      "twenty-two paid-for apples, twenty-two free apples" in {
        ApplePricer.getPrice(44) shouldBe 22 * ApplePrice
      }

      "twenty-three paid-for apples, twenty-two free apples" in {
        ApplePricer.getPrice(45) shouldBe 23 * ApplePrice
      }
    }

    "Oranges are three for two" - {
      "an orange" in {
        priceList.getPrice(Orange()) shouldBe OrangePrice
      }

      "two oranges" in {
        priceList.getPrice(Orange(), 2) shouldBe 2 * OrangePrice
      }

      "three oranges, pay for two" in {
        priceList.getPrice(Orange(), 3) shouldBe 2 * OrangePrice
      }

      "thirty three oranges, pay for twenty two" in {
        priceList.getPrice(Orange(), 33) shouldBe 22 * OrangePrice
      }

      "thirty four oranges, pay for twenty three" in {
        priceList.getPrice(Orange(), 34) shouldBe 23 * OrangePrice
      }

      "thirty five oranges, pay for twenty four" in {
        priceList.getPrice(Orange(), 35) shouldBe 24 * OrangePrice
      }

      "thirty six oranges, pay for twenty four" in {
        priceList.getPrice(Orange(), 36) shouldBe 24 * OrangePrice
      }
    }
  }

  object ApplePricer extends FruitPricer[Apple] {
    override def getPrice(quantity: Int): Price = ((quantity / 2) + (quantity % 2)) * ApplePrice
  }

}


