package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

class ShoppingCart: Screen() {
    private val products = CartItems.products

    fun showCartItems(){
        ScreenStack.push(this)
        if(products.isNotEmpty()){
            println(products.keys.joinToString( //keys는 product의 키값을 set로 return함.
                separator = ", /n",
                prefix = """
                    $LINE_DIVIDER
                    장바구니에 담은 상품 목록입니다.
                    
                """.trimIndent()
            ){"카테고리: ${it.categoryLabel} / 상품명: ${it.name} / 수량: ${products[it]}"}
            )
        } else{
            println("""
                장바구니에 담긴 상품이 없습니다.
            """.trimIndent())
        }
        showPreviousScreenOpion()

    }

    private fun showPreviousScreenOpion() {
        println("""
            $LINE_DIVIDER
            이전 화면으로 돌아가시겠습니까? (y/n)
        """.trimIndent())

        when(readLine().getNotEmptyString()) {
            "y" -> moveToPreviousScreen()
            "n" -> showCartItems()
            else -> {
                //TODO 재입력 요청
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop()
        when(val previousScreen = ScreenStack.peek()){
            is ShoppingProductList ->{
                previousScreen.showProducts()
            }
            is ShoppingCategory ->{
                previousScreen.showCategories()
            }
            is ShoppingHome, is ShoppingCart -> {
                //아무것도 하지 않음
            }
        }
    }

}





