package screen

import data.CartItems

class ShoppingCart {
    private val products = CartItems.products

    fun showCartItems(){
        if(products.isNotEmpty()){
            println(products.keys.joinToString( //keys는 product의 키값을 set로 return함.
                separator = ", /n",
                prefix = """
                    ***=======================***
                    장바구니에 담은 상품 목록입니다.
                    
                """.trimIndent()
            ){"카테고리: ${it.categoryLabel} / 상품명: ${it.name} / 수량: ${products[it]}"}
            )
        } else{
            println("""
                장바구니에 담긴 상품이 없습니다.
            """.trimIndent())
        }

    }

}
