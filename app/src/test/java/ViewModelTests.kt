import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever{}
        viewModel.setQuantity(12)
        assertEquals("27,00 ₽", viewModel.price.value)
    }

    @Test
    fun price_pickup_today() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever{}
        viewModel.setDate(viewModel.dateOptions[0])
        viewModel.setQuantity(1)
        assertEquals("5,00 ₽", viewModel.price.value)
    }

    @Test
    fun price_pickup_tomorrow() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever{}
        viewModel.setDate(viewModel.dateOptions[1])
        viewModel.setQuantity(1)
        assertEquals("2,00 ₽", viewModel.price.value)
    }
}