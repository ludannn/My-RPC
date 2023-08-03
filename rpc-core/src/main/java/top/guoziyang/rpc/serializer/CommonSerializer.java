package top.guoziyang.rpc.serializer;

/**
 * 3.通用的序列化反序列化接口
 * @author ziyang
 */
public interface CommonSerializer {
    /**
     * 序列化
     * @param obj
     * @return
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @return
     */
    Object deserialize(byte[] bytes, Class<?> clazz);

    /**
     * 获得该序列化器的编号
     * @return
     */
    int getCode();

    /**
     * 获得该序列化器的编号
     * @param code
     * @return
     */
    static CommonSerializer getByCode(int code) {
        switch (code) {
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }

}
