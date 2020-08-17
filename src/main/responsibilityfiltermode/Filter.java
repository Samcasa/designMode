package responsibilityfiltermode;

/**
 * @author: 瓦力
 * @date: 2020-08-17 23:46
 *  @Target: 责任链模式
 **/

public interface Filter {
    void doFilter(Request request,Response response,FilterChain filterChain);

}
