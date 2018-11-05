class RpgConsole(presenter: RpgPresenter) : RpgView {
    override fun showNickname(nickname: String) {
        println("$nickname... quel nom étrange !")
    }

    override fun getNicknameAnswer(): String {
        return readLine()!!
    }

    override fun askNickname() {
        println("Je voudrais savoir quel est ton pseudo ?")
        print("Pseudo : ")
    }

    override fun showWelcomeMessage() {
        println("Bienvenue à toi !")
    }
}