package responsibilityfiltermode;

/**
 * @author: 瓦力
 * @date: 2020-08-18 00:08
 * @Target: 责任链模式
 **/

public class Test {
    public  static  void main(String[] arg){
        Request request=new Request();
        request.getHeader().put("token","11111");
        Response response=new Response();

        FilterChain filterChain=new FilterChain();
        filterChain.add(new CheckHeaderFilter());
        filterChain.add(new WriteHeaderFilter());
        filterChain.doFilter(request,response,filterChain);
        System.out.println(response.getResponseBody());
        System.out.println(response.getHeader().toString());
    }
}
