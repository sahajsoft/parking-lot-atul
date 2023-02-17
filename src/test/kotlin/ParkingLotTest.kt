import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertEquals

class ParkingLotTest {
    @BeforeEach
    fun setUp() {
        ParkingLot.allSlots.clear()
        Operator.ticketId = 0
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

        var addedSlots = ParkingLot().addSlots(10)
        val actualSlotNumber = ParkingLot().getFreeSlotNumber()

        assertEquals(expectedSlotNumber, actualSlotNumber)
    }

    @Test
    fun `Should return 3 as free slotNumber for parking if slotNumber 1 an 2 are occupied`() {
        val expectedSlotNumber = 3

        var addedSlots = ParkingLot().addSlots(10)
        ParkingLot().parkVehicle()
        ParkingLot().parkVehicle()
        val actualSlotNumber = ParkingLot().getFreeSlotNumber()

        assertEquals(expectedSlotNumber, actualSlotNumber)
    }

    @Test
    fun `Should generate ticket if vehicle parking is done`() {
        var addedSlots = ParkingLot().addSlots(10)

        val ticket = ParkingLot().parkVehicle()

        print(ticket)
    }
}