package design_pattern_abstract_factory_mode.Huawei;

import design_pattern_abstract_factory_mode.PcFactory;
import design_pattern_abstract_factory_mode.product.*;

public class HuaweiFactory extends PcFactory {
    @Override
    public Mouse produceMouse() {
        System.out.println("This is a HuaweiMouse");
        return new HuaweiMouse();
    }

    @Override
    public KeyBoard produceKeyBoard() {
        System.out.println("This is a HuaweiKeyBoard");
        return new HuaweiKeyBoard();
    }

    @Override
    public HeadPhone produceHeadPhone() {
        return null;
    }
}
