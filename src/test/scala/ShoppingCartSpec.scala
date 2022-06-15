import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "Shopping Cart" should "output total price of items" in {
    ShoppingCart.total(Seq()) shouldEqual 0
    ShoppingCart.total(Seq(Apple, Orange)) shouldEqual (Apple.price + Orange.price)
    ShoppingCart.total(Seq(Apple)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Orange)) shouldEqual Orange.price
  }

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
}
