package models

import java.time.LocalDateTime

data class Receipt(val Id: String, val entryDateTime: LocalDateTime, val exitDateTime: LocalDateTime, val fees: Int) {

}
