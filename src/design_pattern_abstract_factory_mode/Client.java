package design_pattern_abstract_factory_mode;

import design_pattern_abstract_factory_mode.Huawei.HuaweiFactory;
import design_pattern_abstract_factory_mode.dell.DellFactory;
import design_pattern_abstract_factory_mode.product.KeyBoard;
import design_pattern_abstract_factory_mode.product.Mouse;

public class Client {
    public static void main(String[] args) {
        PcFactory factory = new HuaweiFactory();
        KeyBoard keyBoard = factory.produceKeyBoard();
        Mouse mouse = factory.produceMouse();
    }
}
