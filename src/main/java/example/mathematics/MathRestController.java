package example.mathematics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class MathRestController {
    @Autowired
    private MathService mathService;

    /**
     * Excuting for {@code /calc} end point
     *
     * @param session session information
     * @param allRequestParams all request param
     * @return
     */
    @RequestMapping("/math")
    public String calc(HttpSession session, @RequestParam Map<String,String> allRequestParams) {
        return mathService.calculate(allRequestParams.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .filter(key -> key.equals("math"))
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no mathematics param."))
                .replaceAll("\\s+","+"));//UnEscape + mark.
    }
}
