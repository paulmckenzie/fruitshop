package fruitshop

object Fruit {
  sealed trait FruitType

  case object Apple extends FruitType

  case object Orange extends FruitType
}