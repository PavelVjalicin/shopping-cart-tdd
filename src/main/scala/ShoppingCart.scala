
trait Product {
    def price:Double
    def multiPurchaseDiscount(itemAmount:Int):Double
}

object Apple extends Product {
    def price = 0.60
    def multiPurchaseDiscount(itemAmount: Int): Double = {
        Math.floor(itemAmount / 2) * price
    }
}

object Orange extends Product {
    def price = 0.25
    def multiPurchaseDiscount(itemAmount: Int): Double = {
        Math.floor(itemAmount / 2) * price
    }
}

object ShoppingCart {
    def total(products:Seq[Product]) = {
        def price = products.map(_.price).sum
        def discount = multiPurchaseDiscountTotal(products)

        price - discount
    }

    def multiPurchaseDiscountTotal(products: Seq[Product]) = {
        val productTypes = products.toSet
        productTypes.map { product =>
            val productOfTypeCount = products.count(_ == product)
            product.multiPurchaseDiscount(productOfTypeCount)
        }.sum
    }
}