class RpgPresenter {

    private val view: RpgConsole = RpgConsole(this)
    private val mainPlayer: Player = Player()

    init {
        initIntroductionPart()
        initStartDungeonPart()
        initWeaponChoicePart()
        initRooms()
        initRoomsEvents()
    }

    private fun initRoomsEvents() {
        mainPlayer.room?.type?.also {
            view.showCurrentRoom(it.label)
            when (it) {
                RoomType.ROOM_INIT -> handleInitRoomEvent()
                RoomType.ROOM_1 -> handleRoom1Event()
                RoomType.ROOM_2 -> handleRoom2Event()
                RoomType.ROOM_3 -> handleRoom3Event()
                RoomType.ROOM_4 -> handleRoom4Event()
                RoomType.ROOM_END -> handleEndingRoomEvent()
            }
            handleMovement()
        }

    }

    private fun handleMovement() {
        view.showMovementQuestion()
        mainPlayer.room?.also {
            it.northRoom?.also {
                view.showPossibility(Direction.NORTH)
            }
            it.eastRoom?.also {
                view.showPossibility(Direction.EAST)
            }
            it.southRoom?.also {
                view.showPossibility(Direction.SOUTH)
            }
            it.westRoom?.also {
                view.showPossibility(Direction.WEST)
            }
        }
        view.askMovementAnswer()

    }

    private fun handleEndingRoomEvent() {
    }

    private fun handleRoom4Event() {
    }

    private fun handleRoom3Event() {
    }

    private fun handleRoom2Event() {
    }

    private fun handleRoom1Event() {
    }

    private fun handleInitRoomEvent() {
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

    fun onMovementAnswerReceived(answer: String) {
        when(answer) {
            Direction.NORTH.key -> mainPlayer.updateNewRoom(mainPlayer.room?.northRoom)
            Direction.SOUTH.key -> {}
            Direction.WEST.key -> {}
            Direction.EAST.key -> {}
        }
    }

    fun Player.updateNewRoom(room: Room?) {

    }
}
