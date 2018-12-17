data class Room(val type: RoomType,
                var northRoom: Room? = null,
                var southRoom: Room? = null,
                var eastRoom: Room? = null,
                var westRoom: Room? = null,
                var isLocked: Boolean = false)

enum class RoomType(val label: String) {
    ROOM_INIT("Room initial"),
    ROOM_1("Room 1"),
    ROOM_2("Room 2"),
    ROOM_3("Room 3"),
    ROOM_4("Room 4"),
    ROOM_END("Room final")
}

enum class Direction(val label: String,val key: String) {
    NORTH("North", NORTH_ANSWER),
    SOUTH("South", SOUTH_ANSWER),
    EAST("East", EAST_ANSWER),
    WEST("West", WEST_ANSWER)
}