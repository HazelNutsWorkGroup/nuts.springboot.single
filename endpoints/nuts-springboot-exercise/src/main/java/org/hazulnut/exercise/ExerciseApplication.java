package org.hazulnut.exercise;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * exercise appliaction.
 *
 * <p>exercise appliaction project
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/11/17 15:25: created.<br>
 */
public class ExerciseApplication {

    public static void main(String[] args) {
        test1();
        //test2();
    }

    public static void test2() {
        String exp = "threshold = def (x) { x >= 10 ? x : 0 };\n" +
                "result = threshold(num);\n" +
                "System.out.println(result);";
        Map map = new HashMap();
        map.put("num", 15);
        MVEL.eval(exp, map);

    }

    public static void test1(){
        Expression expression = AviatorEvaluator.getInstance().compile("\n" +
                "fn add(x, y) {\n" +
                "  if type(x) != 'long' || type(y) != 'long' {\n" +
                "    throw \"unsupported type\";\n" +
                "  }\n" +
                "  return x + y;\n" +
                "}\n" +
                "three = add(1, 2);\n" +
                "println(three);");
        Object result = expression.execute();

        System.out.println(result);

    }
}
