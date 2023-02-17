import models.Receipt
import models.Ticket
import ParkingLot
import java.time.LocalDateTime

class Operator {
    companion object {
        var ticketId = 1
        val chargeForAnHour = 10
    }

    fun generateTicket(slotNumber: Int): Ticket {
        val entryDateTime = LocalDateTime.now()
        val ticket = Ticket(ticketId++, slotNumber, entryDateTime)

        return ticket
    }

    fun generateReceipt(ticket: Ticket): Receipt {
        val exitDateTime = LocalDateTime.now()
        val Id = "R-" + ticket.Id.toString()
        val fees = calculateFees(10, chargeForAnHour)
        val receipt = Receipt(Id, ticket.entryDateTime, exitDateTime, fees)

        return receipt
    }

    private fun calculateFees(numberOfHours: Int, chargeForAnHour: Int): Int {
        return numberOfHours * chargeForAnHour
    }

    fun resetTicketIds() {
        ticketId = 1
    }
}