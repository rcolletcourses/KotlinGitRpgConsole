class RpgPresenter {

    private val view: RpgConsole = RpgConsole(this)
    private val mainPlayer: Player = Player()

    init {
        initIntroductionPart()
        initStartDungeonPart()
        initWeaponChoicePart()
        initRooms()
    }

    private fun initRooms() {
        mainPlayer.room = DataManager.getInitialRoom()
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
            ANSWER_1 -> Weapon.Sword("Épée", 12)
            ANSWER_2 -> Weapon.Axe("Hache", 14)
            ANSWER_3 -> Weapon.Bow("Arc", 11, 15)
            else -> null
        }
        if (weapon == null) view.askWeaponChoiceAnswer()
        mainPlayer.weapon = weapon
    }
}
