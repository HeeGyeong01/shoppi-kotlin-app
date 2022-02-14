fun main(args: Array<String>){
    val categories = arrayOf("패션", "전자기기", "반려동물용품")

    println("카테고리 선택하기\n =================================")
    for(category in categories){
        println(category)
    }
    println("=> 장바구니로 이동은 # 입력.")
    var selectedCategory = readLine()

    while (selectedCategory.isNullOrBlank()){
        println("카테고리명이나 #를 입력해 주세요")
        selectedCategory = readLine()
    }
    if(selectedCategory == "#"){
        //TODO 1. 장바구니 이동
    }else{
        //TODO 2. 카테고리 상품 목록 보여주기
        //TODO 3. 카테고리 목록에 없는 값을 입력하는 경우
    }
}
