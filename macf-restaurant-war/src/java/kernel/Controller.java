package kernel;

public abstract class Controller implements ControllerInterface {

    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Controller", "").toLowerCase();
    }

}
