interface RpgView {
    fun showWelcomeMessage()
    fun askNickname()
    fun askNicknameAnswer()
    fun showNickname(nickname: String)
    fun showStartDungeonQuestion()
    fun askStartDungeonAnswer()
    fun showStartDungeonMessage()
    fun showLeaveDungeonMessage()
    fun showWeaponChoiceQuestion()
    fun askWeaponChoiceAnswer()
    fun showChosenWeapon(weapon: Weapon)
}