import org.example.ProductApiClient;
import org.example.ProductService;
import org.example.Produit;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProductServiceTestq4 {

    @Test
    public void testGetProduct_Success() {
        // Création du mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Création d'un produit fictif pour le test
        Produit produitFictif = new Produit("1", "Produit fictif", 10.0);

        // Définir le comportement du mock lors de l'appel à getProduct pour un succès
        when(productApiClientMock.getProduct("1")).thenReturn(produitFictif);

        // Création de l'instance ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester
        Produit produit = productService.getProduct("1");

        // Vérification que la méthode getProduct du mock a été appelée avec le bon argument
        verify(productApiClientMock).getProduct("1");
    }

    @Test
    public void testGetProduct_DataFormatIncompatible() {
        // Création du mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Définir le comportement du mock lors de l'appel à getProduct pour un format de données incompatible
        when(productApiClientMock.getProduct(anyString())).thenThrow(new RuntimeException("Format de données incompatible"));

        // Création de l'instance ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester et vérification qu'elle lance une exception de format de données incompatible
        assertThrows(RuntimeException.class, () -> productService.getProduct("1"));
    }


    @Test
    public void testGetProduct_ApiCallFailure() {
        // Création du mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Définir le comportement du mock lors de l'appel à getProduct pour un échec d'appel d'API
        when(productApiClientMock.getProduct(anyString())).thenReturn(null);

        // Création de l'instance ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester et vérification qu'elle retourne null en cas d'échec d'appel d'API
        assertNull(productService.getProduct("1"));
    }
}
