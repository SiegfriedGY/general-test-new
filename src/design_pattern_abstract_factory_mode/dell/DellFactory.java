package design_pattern_abstract_factory_mode.dell;

import design_pattern_abstract_factory_mode.PcFactory;
import design_pattern_abstract_factory_mode.product.*;

public class DellFactory extends PcFactory {
    @Override
    public Mouse produceMouse() {
        System.out.println("This is a DellMouse");
        return new DellMouse();
    }

    @Override
    public KeyBoard produceKeyBoard() {
        System.out.println("This is a DellKeyBoard");
        return new DellKeyBoard();
    }

    @Override
    public HeadPhone produceHeadPhone() {
        return null;
    }
}
