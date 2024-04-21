import org.example.ProductApiClient;
import org.example.ProductService;
import org.example.Produit;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct() {
        // Création du mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Création d'un produit fictif pour le test
        Produit produitFictif = new Produit("1", "Produit fictif", 10.0);

        // Définir le comportement du mock lors de l'appel à getProduct
        when(productApiClientMock.getProduct("1")).thenReturn(produitFictif);

        // Création de l'instance ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester
        Produit produit = productService.getProduct("1");

        // Vérification que la méthode getProduct du mock a été appelée avec le bon argument
        verify(productApiClientMock).getProduct("1");
    }
}
