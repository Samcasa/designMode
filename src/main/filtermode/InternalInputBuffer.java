package filtermode;

/**
 * @author: 瓦力
 * @date: 2020-05-23 13:54
 * @Target: 过滤器模式
 **/

public class InternalInputBuffer implements InputBuffer {
    boolean isEnd=false;
    byte[] buf=new byte[4];
    protected int lastActiveFilter=-1;
    protected  InputFilter[] activeFilters=new InputFilter[2];

    InputBuffer inputStreaminputBuffer=(InputBuffer) new InputStreamInputBuffer();


    public void addActiveFilter(InputFilter filter) {
        if (lastActiveFilter == -1) {
            filter.setBuffer(inputStreaminputBuffer);
        } else {
            for (int i = 0; i <= lastActiveFilter; i++) {
                //过滤器不重复添加
                if (activeFilters[i].equals(filter))
                    return;
            }
            //当前的filter设置指向上一个过滤器的buffer 这里是递归调用的关键
            filter.setBuffer(activeFilters[lastActiveFilter]);
        }

        activeFilters[++lastActiveFilter] = filter;
    }

    public int doRead(byte[] chunk) throws Exception {

        if (lastActiveFilter == -1){
             return inputStreaminputBuffer.doRead(chunk);
        }else {
            return activeFilters[lastActiveFilter].doRead(chunk);
        }
    }


    private class InputStreamInputBuffer implements InputBuffer {
        @Override
        public int doRead(byte[] chunk) throws Exception {
            if(isEnd==false){
                buf[0]='a';
                buf[1]='b';
                buf[2]='c';
                buf[3]='d';
                System.arraycopy(buf,0,chunk,0,4);
                isEnd=true;
                return chunk.length;
            }else {
                return -1;
            }
        }
    }
}
