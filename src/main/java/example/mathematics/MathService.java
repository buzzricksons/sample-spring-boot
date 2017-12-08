package example.mathematics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Example for mathematics.
 *
 * @author HyungCheol Kim
 */
@Component
@Service
public class MathService {
    @Value("${error.message}")
    private String ERROR_MESSAGE;
    /**
     * Calculate mathematics using {@link SpelExpressionParser}.
     *
     * @param math
     * @return Result of calculation. If failed return {@link #ERROR_MESSAGE}
     */
    public String calculate(String math) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression(math);
            int result = (Integer) exp.getValue();
            return Integer.toString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }
}
