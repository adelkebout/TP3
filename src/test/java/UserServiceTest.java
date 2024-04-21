import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Création d'un mock pour UserRepository
        UserRepository userRepositoryMock = mock(UserRepository.class);

        // Création d'un utilisateur de test
        long userId = 1;
        User expectedUser = new User(userId, "John", "Doe", "john.doe@example.com");

        // Définir le comportement du mock pour la méthode findUserById
        when(userRepositoryMock.findUserById(userId)).thenReturn(expectedUser);

        // Création d'une instance de UserService avec le mock
        UserService userService = new UserService(userRepositoryMock);

        // Appel de la méthode à tester
        User actualUser = userService.getUserById(userId);
        // question 4
        // Vérification que la méthode findUserById du mock a été appelée avec le bon argument
        verify(userRepositoryMock).findUserById(userId);

        // Vérification que l'utilisateur retourné par la méthode est celui attendu
        assert(actualUser != null);
        assert(actualUser.getId() == expectedUser.getId());
        assert(actualUser.getNom().equals(expectedUser.getNom()));
        assert(actualUser.getPrenom().equals(expectedUser.getPrenom()));
        assert(actualUser.getEmail().equals(expectedUser.getEmail()));
    }
}
