import org.example.Order;
import org.example.OrderController;
import org.example.OrderService;
import org.example.OrderDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Mock
    private OrderService orderServiceMock;

    @Mock
    private OrderDao orderDaoMock;

    private OrderController orderController;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        orderController = new OrderController(orderServiceMock);
        assertNotNull(orderServiceMock); // Check if mock is initialized
        assertNotNull(orderDaoMock);   // You might also use orderDaoMock
    }


    @Test
    public void testCreateOrder() {
        // Create a sample order
        Order order = new Order(1L, "John Doe", 100.00);

        // Mock OrderService behavior
        doNothing().when(orderServiceMock).createOrder(order);

        // Call the method under test
        orderController.createOrder(order);

        // Verify that OrderService.createOrder was called with the correct order
        verify(orderServiceMock).createOrder(order);
    }
}
