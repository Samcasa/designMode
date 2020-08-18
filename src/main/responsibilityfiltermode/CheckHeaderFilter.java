package responsibilityfiltermode;

/**
 * @author: 瓦力
 * @date: 2020-08-18 00:01
 * @Target: 责任链模式
 **/

public class CheckHeaderFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        String token = request.getHeader().get("token");
        System.out.println(token);
        System.out.println("begin CheckHeaderFilter");
        filterChain.doFilter(request,response,filterChain);
        System.out.println("finish CheckHeaderFilter");
    }
}
