package models

import java.time.LocalDateTime

data class Ticket(val Id: Int, val spotNumber: Int, val entryDateTime: LocalDateTime)
