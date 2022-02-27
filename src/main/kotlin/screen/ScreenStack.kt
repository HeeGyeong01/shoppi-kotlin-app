package screen

object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen){
        screenStack.add(screen)
    }
    fun pop(){
        screenStack.removeLastOrNull()
    }
    fun peek(): Screen? {
        return screenStack.lastOrNull()
    }
    //Stack의 기본 함수인 isEmpty는 OrNull 함수를 붙여줬기 때문에 필요없음.
}

sealed class  Screen