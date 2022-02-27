package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

class ShoppingHome: Screen() {
    fun start(){
        showWelcomeMessage()
        showCategories()
    }
    private fun showWelcomeMessage() {
        ScreenStack.push(this)
        println("이름을 입력하세요 ")
        val name = readLine().getNotEmptyString()
        println(
            """
            환영합니다. $name 님.
            원하시는 카테고리를 입력해주세요.
            $LINE_DIVIDER
            """.trimIndent()
        )
    }

    private fun showCategories(){
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }
}