package responsibilityfiltermode;

/**
 * @author: 瓦力
 * @date: 2020-08-18 00:05
 * @Target: 责任链模式
 **/

public class WriteHeaderFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("begin WriteHeaderFilter ");
        filterChain.doFilter(request,response,filterChain);
        response.getHeader().put("X-XSS-Protection","1; mode=block");
        System.out.println("finish WriteHeaderFilter ");
    }
}
