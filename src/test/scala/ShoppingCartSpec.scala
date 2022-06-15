import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "Shopping Cart" should "output total price of items" in {
    ShoppingCart.total(Seq()) shouldEqual 0
    ShoppingCart.total(Seq(Apple, Apple, Orange, Apple)) shouldEqual 2.05
    ShoppingCart.total(Seq(Apple)) shouldEqual 0.60
    ShoppingCart.total(Seq(Orange)) shouldEqual 0.25
  }
}
