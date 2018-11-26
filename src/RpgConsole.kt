class RpgConsole(val presenter: RpgPresenter) : RpgView {

    override fun showChosenWeapon(weapon: Weapon) {
        println("Très bien tu as donc choisis : ")
        println("""
            - Nom : ${weapon.label}
            - Dégats : ${weapon.damage}
        """.trimIndent())
    }

    override fun askWeaponChoiceAnswer() {
        print("Answer : ")
        presenter.onAnswerWeaponChoiceReceived(readLine()!!)
        println()
    }

    override fun showWeaponChoiceQuestion() {
        println("Quel arme veux tu choisir ?")
        println(" $ANSWER_1 -> Épée ")
        println(" $ANSWER_2 -> Hache ")
        println(" $ANSWER_3 -> Arc ")
    }

    override fun showLeaveDungeonMessage() {
        println("Bye bye...")
    }

    override fun showStartDungeonMessage() {
        println("C'est parti..")
    }

    override fun askStartDungeonAnswer() {
        print("Answer : ")
        presenter.onStartDungeonReceived(readLine()!!)
        println()
    }

    override fun showStartDungeonQuestion() {
        println("Veux tu entrer dans le donjon ?")
        println(" ${YES_ANSWER} -> pour commencer")
        println(" ${NO_ANSWER} -> pour quitter")
    }

    override fun showNickname(nickname: String) {
        println("$nickname... quel nom étrange !")
    }

    override fun askNicknameAnswer() {
        print("Pseudo : ")
        presenter.onAnswerNicknameReceived(readLine()!!)
        println()
    }

    override fun askNickname() {
        println("Je voudrais savoir quel est ton pseudo ?")
    }

    override fun showWelcomeMessage() {
        println("Bienvenue à toi !")
    }
}