import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "Shopping Cart" should "output total price of items" in {
    ShoppingCart.total(Seq()) shouldEqual 0
    ShoppingCart.total(Seq(Apple, Apple, Orange, Apple)) shouldEqual (Apple.price * 3 + Orange.price)
    ShoppingCart.total(Seq(Apple)) shouldEqual Apple.price
    ShoppingCart.total(Seq(Orange)) shouldEqual Orange.price
  }
}
