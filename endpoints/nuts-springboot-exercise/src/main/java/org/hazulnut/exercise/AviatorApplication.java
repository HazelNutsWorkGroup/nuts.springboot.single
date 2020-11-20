package org.hazulnut.exercise;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * Aviator .
 *
 * <p>Aviator
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/11/18 16:11: created.<br>
 */
public class AviatorApplication {
    public static void main(String[] args) {
        //注册函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)"));
    }
}

class AddFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number left = FunctionUtils.getNumberValue(arg1, env);
        Number right = FunctionUtils.getNumberValue(arg2, env);
        return new AviatorDouble(left.doubleValue() + right.doubleValue());
    }

    @Override
    public String getName() {
        return "add";
    }
}