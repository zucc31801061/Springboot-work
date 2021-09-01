package cn.edu.zucc.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
/*springboot提供了默认的错误映射地址error
@RequestMapping("${server.error.path:${error.path:/error}}")
@RequestMapping("/error")
上面2种写法都可以
*/
@RequestMapping("/error")
//继承springboot提供的ErrorController
public class TestErrorController implements ErrorController {
    //一定要重写方法,默认返回null就可以,不然报错,因为getErrorPath为空.
    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/ok")
    @ResponseBody
    public Map<String, Object> noError() {
        //用Map容器返回信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code ", 200);
        map.put("msg", "正常，这是测试页面");

        return map;
    }

    @RequestMapping( value = "",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String errorHtml4040(HttpServletRequest request, HttpServletResponse response) {
        return "404错误,不存在";
    }

    @RequestMapping(value = "", consumes="application/json;charset=UTF-8",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  Map<String, Object> errorJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rspCode", 404);
        map.put("rspMsg", "不存在");
        return map;
    }
}
