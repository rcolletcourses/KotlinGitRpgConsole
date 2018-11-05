interface RpgView {
    fun showWelcomeMessage()
    fun askNickname()
    fun getNicknameAnswer(): String
    fun showNickname(nickname: String)
}