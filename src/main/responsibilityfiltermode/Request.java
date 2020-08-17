package responsibilityfiltermode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 瓦力
 * @date: 2020-08-17 23:48
 * @Target: 责任链模式
 **/

public class Request {
    private String requestBody;
    private Map<String,String> header=new HashMap<>();

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
