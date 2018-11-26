class RpgPresenter {

    private val view: RpgConsole = RpgConsole(this)
    private val mainPlayer: Player = Player()

    init {
        initIntroductionPart()
        initStartDungeonPart()
        initWeaponChoicePart()
    }

    private fun initWeaponChoicePart() {
        view.showWeaponChoiceQuestion()
        view.askWeaponChoiceAnswer()
        view.showChosenWeapon(mainPlayer.weapon!!)
    }

    private fun initIntroductionPart() {
        view.showWelcomeMessage()
        view.askNickname()
        view.askNicknameAnswer()
        view.showNickname(mainPlayer.name!!)
    }

    fun onAnswerNicknameReceived(answer: String) {
        mainPlayer.name = answer
    }

    fun initStartDungeonPart() {
        view.showStartDungeonQuestion()
        view.askStartDungeonAnswer()
    }

    fun onStartDungeonReceived(answer: String) {
        when (answer.toUpperCase()) {
            YES_ANSWER -> view.showStartDungeonMessage()
            NO_ANSWER -> view.showLeaveDungeonMessage()
            else -> initStartDungeonPart()
        }
    }

    tailrec fun onAnswerWeaponChoiceReceived(answer: String) {
        var weapon: Weapon? = when(answer) {
            ANSWER_1 -> Weapon.SWORD
            ANSWER_2 -> Weapon.AXE
            ANSWER_3 -> Weapon.BOW
            else -> null
        }
        if (weapon == null) view.askWeaponChoiceAnswer()
        mainPlayer.weapon = weapon
    }
}
