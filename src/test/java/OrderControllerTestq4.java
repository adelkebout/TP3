import org.example.Order;
import org.example.OrderController;
import org.example.OrderService;
import org.example.OrderDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class OrderControllerTestq4 {

    @Mock
    private OrderService orderServiceMock;

    @Mock
    private OrderDao orderDaoMock; // Assuming OrderDao is used, comment out if not

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        OrderController OrderController = new OrderController(orderServiceMock); // Inject OrderService mock
        assertNotNull(orderServiceMock);

        // assertNotNull(orderDaoMock);
    }

    @Test
    public void testCreateOrder() {
        // Create a sample order
        Order order = new Order(1L, "John Doe", 100.00);

        // Capture arguments passed to OrderService.createOrder
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        // Mock OrderService behavior
        doNothing().when(orderServiceMock).createOrder(orderCaptor.capture());

        // Call the method under test
        OrderController.createOrder(order);

        // Verify that OrderService.createOrder was called with the correct order
        verify(orderServiceMock).createOrder(orderCaptor.capture());
        Order capturedOrder = orderCaptor.getValue();
        assertEquals(order, capturedOrder);


    }
}
