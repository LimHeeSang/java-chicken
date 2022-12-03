import controller.PosController;
import service.PosService;

public class Application {
    public static void main(String[] args) {
        PosController posController = new PosController(new PosService());
        posController.run();
    }
}
