package data

object CartItems {
    //이거는 프로젝트 전역에서 상품 데이터를 저장하는 클래스이므로
    //..항상 같은 값이 유지되어야 하기 때문에 싱글톤 객체로 만들음.
    private val mutableProducts = mutableMapOf<Product, Int>() //mutable -> 안에서만 수정 가능하게
    val products: Map<Product, Int> = mutableProducts //Immutable ->바깥에서 수정 못하게

    fun addProduct(product: Product) {
        mutableProducts[product]?.let { //없을수도 있으므로(Nullable Type) Safe call operator 사용
            mutableProducts[product] = it + 1
        } ?: run{ mutableProducts[product] = 1 }
    }
}