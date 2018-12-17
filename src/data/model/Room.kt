package data.model

import common.EAST_ANSWER
import common.NORTH_ANSWER
import common.SOUTH_ANSWER
import common.WEST_ANSWER

data class Room(val type: RoomType,
                var northRoom: Room? = null,
                var southRoom: Room? = null,
                var eastRoom: Room? = null,
                var westRoom: Room? = null,
                var isLocked: Boolean = false)

enum class RoomType(val label: String) {
    ROOM_INIT("data.model.Room initial"),
    ROOM_1("data.model.Room 1"),
    ROOM_2("data.model.Room 2"),
    ROOM_3("data.model.Room 3"),
    ROOM_4("data.model.Room 4"),
    ROOM_END("data.model.Room final")
}

enum class Direction(val label: String,val key: String) {
    NORTH("North", NORTH_ANSWER),
    SOUTH("South", SOUTH_ANSWER),
    EAST("East", EAST_ANSWER),
    WEST("West", WEST_ANSWER)
}