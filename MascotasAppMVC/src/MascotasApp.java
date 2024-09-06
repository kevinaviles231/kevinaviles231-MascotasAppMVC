import controller.MascotasController;
import view.MascotasView;

public class MascotasApp {
    public static void main(String[] args) {
        MascotasView view = new MascotasView();
        new MascotasController(view);
    }
}