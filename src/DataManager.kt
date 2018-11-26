object DataManager {

    private var rooms: List<Room>? = null

    private fun buildRooms() {
        val startRoom = Room("Start Room")
        val room1 = Room("Room 1")
        val room2 = Room("Room 2")
        val room3 = Room("Room 3")
        val room4 = Room("Room 4")
        val endRoom = Room("End Room")

        startRoom.northRoom = room1
        room1.northRoom = room2
        room1.westRoom = room4
        room1.eastRoom = room3
        room1.southRoom = startRoom

        room2.northRoom = endRoom
        room2.eastRoom = room3
        room2.southRoom = room1

        room3.northRoom = room2
        room3.westRoom = room1

        room4.westRoom = room1

        endRoom.southRoom = room2

        rooms = arrayListOf(startRoom, room1, room2, room3, room4, endRoom)
    }

    fun getRooms() {}

    fun getInitialRoom() = rooms?.first()
}