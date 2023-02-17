import models.Receipt
import models.Ticket

class ParkingLot {
    companion object {
        var allSlots = mutableMapOf<Int, Slot>()
        var slotTickets = mutableMapOf<Int, Ticket>()
    }

    fun addSlots(quantity: Int): Int {
        for (slotNumber in 1..quantity) {
            allSlots[slotNumber] = Slot(slotNumber)
        }
        return allSlots.size
    }

    fun getFreeSlotNumber(): Int {
        for (slotNumber in 1..allSlots.size) {
            val slot = allSlots[slotNumber]!!

            if (!slot.isOccupied) {
                return slotNumber
            }
        }
        throw Exception("No free slot available")
    }

    fun parkVehicle(): Ticket {
        val freeSlotNumber = getFreeSlotNumber()
        val slot = allSlots[freeSlotNumber]!!
        slot.isOccupied = true

        val ticket = Operator().generateTicket(freeSlotNumber)
        slotTickets[freeSlotNumber] = ticket

        return ticket
    }

    fun unparkVehicle(slotNumber: Int): Receipt {
        val slot = allSlots[slotNumber]!!
        slot.isOccupied = false

        val slotTicket = slotTickets[slotNumber]!!

        return Operator().generateReceipt(slotTicket)
    }
}
