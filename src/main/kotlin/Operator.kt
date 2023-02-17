import models.Receipt
import models.Ticket
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Operator {
    companion object {
        var ticketId = 1
        const val CHARGE_FOR_AN_HOUR = 10
    }

    fun generateTicket(slotNumber: Int): Ticket {
        val entryDateTime = LocalDateTime.now()

        return Ticket(ticketId++, slotNumber, entryDateTime)
    }

    fun generateReceipt(ticket: Ticket): Receipt {
        val exitDateTime = LocalDateTime.now()
        val id = "R-" + ticket.id.toString()
        val totalHours: Int = ChronoUnit.HOURS.between(exitDateTime, ticket.entryDateTime).toInt()

        val fees = calculateFees(totalHours)

        return Receipt(id, ticket.entryDateTime, exitDateTime, fees)
    }

    private fun calculateFees(numberOfHours: Int): Int {
        return numberOfHours * CHARGE_FOR_AN_HOUR
    }

    fun resetTicketIds() {
        ticketId = 1
    }
}