package data

import data.model.Room
import data.model.RoomType

object DataManager {

    private var rooms: List<Room>? = null

    init {
        buildRooms()
    }

    private fun buildRooms() {
        val startRoom = Room(RoomType.ROOM_INIT)
        val room1 = Room(RoomType.ROOM_1)
        val room2 = Room(RoomType.ROOM_2)
        val room3 = Room(RoomType.ROOM_3)
        val room4 = Room(RoomType.ROOM_4, isLocked = true)
        val endRoom = Room(RoomType.ROOM_END, isLocked = true)

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
        rooms = ArrayList()
        rooms = arrayListOf(startRoom, room1, room2, room3, room4, endRoom)
    }

    fun getRooms() {}

    fun getInitialRoom() = rooms?.find { it.type == RoomType.ROOM_INIT }
}