package screen
import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList(private val selectedCategory: String): Screen() {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식"),
    )
    private val categories: Map<String, List<Product>> = products.groupBy{
        //product -> product.categoryLabel
        it.categoryLabel
    }
    fun showProducts(){
        ScreenStack.push(this)
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())

            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }

//            val productSize = categoryProducts.size
//            for(index in 0 until productSize){
//                println("${index}. ${categoryProducts[index].name}")
//            } //여기까지 코드: 고른 카테고리 안의 상품들 보여줌.
            showCartOption(categoryProducts)
        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>) {
        println(
            """
                $LINE_DIVIDER
                장바구니에 담을 상품 번호를 입력해주세요.
            """.trimIndent()
        )
        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let{ //존재한다면 cartItem에 추가
            //product -> 방식으로 코드 써주는 것도 가독성에 좋을 듯.
            CartItems.addProduct(it)
            println("장바구니로 ${it.name}이(가) 이동되었습니다. ")
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *를 입력해주세요.")
            val answer = readLine().getNotEmptyString()
            if(answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if(answer == "*"){
                showProducts()
            }else{
                //TODO 그 외 값을 입력한 경우 처리
            }
        } ?: run { //입력한 인덱스 번호에 해당하는 Product가 없는 경우
            println("$selectedIndex 번은 목록에 없는 상품 번호입니다. 다시 입력해 주세요")
            showProducts()
        }

    }

    private fun showEmptyProductMessage(selectedCategory: String){
        println("[$selectedCategory] 카테고리에 등록된 상품이 없습니다.")
        //--------------------------------------------------



    }



}