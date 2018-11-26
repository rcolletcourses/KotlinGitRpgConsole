data class Room(val name: String,
                var northRoom: Room? = null,
                var southRoom: Room? = null,
                var eastRoom: Room? = null,
                var westRoom: Room? = null)