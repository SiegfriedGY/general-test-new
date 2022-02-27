package design_pattern_abstract_factory_mode.hp;

import design_pattern_abstract_factory_mode.PcFactory;
import design_pattern_abstract_factory_mode.product.*;

public class HpFactory extends PcFactory {
    @Override
    public Mouse produceMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard produceKeyBoard() {
        return new HpKeyBoard();
    }

    @Override
    public HeadPhone produceHeadPhone() {
        return null;
    }
}
