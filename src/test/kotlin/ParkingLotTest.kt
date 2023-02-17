import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParkingLotTest {
    @BeforeEach
    fun setUp() {
        ParkingLot.allSlots.clear()
        Operator().resetTicketIds()
    }

    private fun addSlotsToLot(quantity: Int): Int {
        return ParkingLot().addSlots(quantity)
    }

    @Test
    fun `Should add 100 slots to parking lot`() {
        val expectedSlotCount = 100

        val addedSlots = ParkingLot().addSlots(expectedSlotCount)

        assertEquals(expectedSlotCount, addedSlots)
    }

    @Test
    fun `Should add 50 slots to parking lot`() {
        val expectedSlotCount = 50

        val addedSlots = ParkingLot().addSlots(expectedSlotCount)

        assertEquals(expectedSlotCount, addedSlots)
    }

    @Test
    fun `Should return free slotNumber if slot is not occupied`() {
        val expectedSlotNumber = 1
        addSlotsToLot(10)

        val actualSlotNumber = ParkingLot().getFreeSlotNumber()

        assertEquals(expectedSlotNumber, actualSlotNumber)
    }

    @Test
    fun `Should return 3 as free slotNumber for parking if slotNumber 1 an 2 are occupied`() {
        val expectedSlotNumber = 3

        addSlotsToLot(15)
        ParkingLot().parkVehicle()
        ParkingLot().parkVehicle()
        val actualSlotNumber = ParkingLot().getFreeSlotNumber()

        assertEquals(expectedSlotNumber, actualSlotNumber)
    }

    @Test
    fun `Should generate ticket if vehicle parking is done`() {
        val expectedSpotNumber = 1
        val expectedTicketId = 1

        addSlotsToLot(100)
        val ticket = ParkingLot().parkVehicle()

        assertEquals(expectedTicketId, ticket.Id)
        assertEquals(expectedSpotNumber, ticket.spotNumber)
    }

    @Test
    fun `Should generate receipt if vehicle is unparked`() {
        val expectedReceiptNumber = "R-1"
        val expectedFees = 0

        addSlotsToLot(50)
        val ticket = ParkingLot().parkVehicle()
        val receipt = ParkingLot().unparkVehicle(ticket.spotNumber)

        assertEquals(expectedReceiptNumber, receipt.id)
        assertEquals(expectedFees, receipt.fees)
    }
}