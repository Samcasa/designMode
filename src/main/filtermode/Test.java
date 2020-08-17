package filtermode;


/**
 * @author: 瓦力
 * @date: 2020-05-23 14:04
 * @Target: 过滤器模式
 **/

public class Test {
    public static void main(String[] args) throws Exception {

        InternalInputBuffer internalInputBuffer=new InternalInputBuffer();

        ClearFilter clearFilter=new ClearFilter();
        UpperFilter upperFilter=new UpperFilter();

        internalInputBuffer.addActiveFilter(clearFilter);
        internalInputBuffer.addActiveFilter(upperFilter);
        byte[] chunk=new byte[4];
        int i=0;
        while (i!=-1){
            i=internalInputBuffer.doRead(chunk);
            if(i==-1){
                break;
            }
        }
        System.out.println(new String(chunk));

    }
}
