
trait Product {
    def price:Double
}

object Apple extends Product {
    def price = 0.60
}

object Orange extends Product {
    def price = 0.25
}

object ShoppingCart {
    def total(products:Seq[Product]) = products.map(_.price).sum
}