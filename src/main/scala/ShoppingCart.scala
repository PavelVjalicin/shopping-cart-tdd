
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

object Banana extends Product {
    def price = 0.20
    def multiPurchaseDiscount(itemAmount: Int): BigDecimal = {
        Math.floor(itemAmount / 2) * price
    }
}

object ShoppingCart {
    def total(products:Seq[Product]): BigDecimal = {
        def price = products.map(_.price).sum
        def discount = multiPurchaseDiscountTotal(products)
        def bundlePurchaseDiscount = bundlePurchaseTotal(products)

        price - discount - bundlePurchaseDiscount
    }

    private def bundlePurchaseTotal(products:Seq[Product]):BigDecimal = {
        val productTypes = products.toSet
        if(productTypes.contains(Banana) && productTypes.contains(Apple)) {
            val bananaCount = products.count(_ == Banana)
            val appleCount = products.count(_ == Apple)
            val applePricesBeforeDiscount = products.filter(_ == Apple).map(_.price).sum
            val bananaPricesBeforeDiscount = products.filter(_ == Banana).map(_.price).sum
            val bananaPricesTotal =  bananaPricesBeforeDiscount - Banana.multiPurchaseDiscount(bananaCount)
            val applePricesTotal =  applePricesBeforeDiscount - Apple.multiPurchaseDiscount(appleCount)
            if( bananaPricesTotal < applePricesTotal) bananaPricesTotal
            else applePricesTotal
        } else {
            0
        }
    }

    private def multiPurchaseDiscountTotal(products: Seq[Product]): BigDecimal = {
        val productTypes = products.toSet
        productTypes.map { product =>
            val productOfTypeCount = products.count(_ == product)
            product.multiPurchaseDiscount(productOfTypeCount)
        }.sum
    }
}