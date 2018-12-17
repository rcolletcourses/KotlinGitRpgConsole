package presentation

import data.model.Direction
import data.model.Weapon

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
    fun showCurrentRoom(type: String)
    fun showMovementQuestion()
    fun showPossibility(north: Direction)
    fun askMovementAnswer()
    fun showRoomLocked()
}