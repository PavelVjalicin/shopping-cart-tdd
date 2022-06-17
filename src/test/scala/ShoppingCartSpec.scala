import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

  "Shopping Cart" should "apply discount on: buy one, get one free on Apples" in {
    ShoppingCart.total(Seq(Apple)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Apple, Apple)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Apple, Apple, Apple)) shouldEqual 2 * Apple.price
    ShoppingCart.total(Seq(Apple, Apple, Apple, Apple)) shouldEqual 2 * Apple.price
  }

  "Shopping Cart" should "apply discount on: 3 for the price of 2 on Oranges" in {
    ShoppingCart.total(Seq(Orange, Orange)) shouldEqual 2 * Orange.price
    ShoppingCart.total(Seq(Orange,Orange,Orange)) shouldEqual 2 * Orange.price
    ShoppingCart.total(Seq(Orange, Orange, Orange, Orange)) shouldEqual 3 * Orange.price
    ShoppingCart.total(Seq(Orange, Orange, Orange, Orange, Orange, Orange, Orange)) shouldEqual 5 * Orange.price
  }

  "Shopping Cart" should "apply discount on: buy one get one offer" in {
    ShoppingCart.total(Seq(Banana)) shouldEqual Banana.price
    ShoppingCart.total(Seq(Banana, Banana)) shouldEqual Banana.price
    ShoppingCart.total(Seq(Banana, Banana, Banana)) shouldEqual 2 * Banana.price
  }

  "Shopping Cart" should "when Bananas are bought together with Apple cheapest one is free" in {
    ShoppingCart.total(Seq(Apple, Banana)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Apple, Banana, Banana)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Apple, Banana, Banana, Banana, Banana, Banana, Banana, Banana, Banana)) shouldEqual 4 * Banana.price
  }

  "Shopping Cart" should "output total price of items with discounts" in {
    ShoppingCart.total(Seq()) shouldEqual 0
    ShoppingCart.total(Seq(Apple, Orange)) shouldEqual (Apple.price + Orange.price)
    ShoppingCart.total(Seq(Apple)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Orange)) shouldEqual Orange.price
    ShoppingCart.total(Seq(Apple, Orange, Orange, Orange, Apple, Apple)) shouldEqual 2 * Apple.price + 2 * Orange.price
  }

  "
}
