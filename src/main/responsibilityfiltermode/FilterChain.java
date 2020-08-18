package responsibilityfiltermode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 瓦力
 * @date: 2020-08-17 23:52
 * @Target: 责任链模式
 **/

public class FilterChain implements Filter {
    private List<Filter> list=new ArrayList<>();
    private int index=0;
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if(index<list.size()){
            Filter filter = list.get(index);
            index++;
            filter.doFilter(request,response,filterChain);
            return;
        }

        //do servlet request in TOMCAT
        System.out.println("servlet.service(Request,Response)");
        response.setResponseBody("get servlet.service(Request,Response) result");
    }

    public FilterChain add(Filter filter){
        this.list.add(filter);
        return this;
    }
}
