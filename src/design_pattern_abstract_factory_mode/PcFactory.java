package design_pattern_abstract_factory_mode;

import design_pattern_abstract_factory_mode.product.HeadPhone;
import design_pattern_abstract_factory_mode.product.KeyBoard;
import design_pattern_abstract_factory_mode.product.Mouse;

public abstract class PcFactory {

    public abstract Mouse produceMouse();

    public abstract KeyBoard produceKeyBoard();

    public abstract HeadPhone produceHeadPhone();
}
