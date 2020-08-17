package FilterMode;

/**
 * @author: 瓦力
 * @date: 2020-05-23 13:59
 **/

public class ClearFilter implements InputFilter {
    protected InputBuffer buffer;
    @Override
    public void setBuffer(InputBuffer inputBuffer) {
        this.buffer=inputBuffer;

    }

    @Override
    public int doRead(byte[] chunk) throws Exception {
        int i= buffer.doRead(chunk);
        if (i == -1)
            return -1;
        for (int j= 0; j < chunk.length; j++){
            if (chunk[j] == 'a'){
                chunk[j] = 'f';
            }
        }
        return i;

    }

    public InputBuffer getBuffer(){
        return buffer;
    }
}
