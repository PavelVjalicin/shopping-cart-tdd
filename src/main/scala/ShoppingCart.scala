
trait Product {
    def price:BigDecimal
    def multiPurchaseDiscount(itemAmount:Int):BigDecimal
}

object Apple extends Product {
    def price = 0.60
    def multiPurchaseDiscount(itemAmount: Int): BigDecimal = {
        Math.floor(itemAmount / 2) * price
    }
}

object Orange extends Product {
    def price = 0.25
    def multiPurchaseDiscount(itemAmount: Int): BigDecimal = {
        Math.floor(itemAmount / 3) * price
    }
}

object ShoppingCart {
    def total(products:Seq[Product]): BigDecimal = {
        def price = products.map(_.price).sum
        def discount = multiPurchaseDiscountTotal(products)

        price - discount
    }

    private def multiPurchaseDiscountTotal(products: Seq[Product]): BigDecimal = {
        val productTypes = products.toSet
        productTypes.map { product =>
            val productOfTypeCount = products.count(_ == product)
            product.multiPurchaseDiscount(productOfTypeCount)
        }.sum
    }
}