import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    ShoppingCart.hi shouldEqual "hi"
  }
}
