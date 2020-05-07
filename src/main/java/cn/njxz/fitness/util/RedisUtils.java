package cn.njxz.fitness.util;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kalend Zhang on 2019/6/21.
 *
 * @author Kalend
 * @date 2019/6/21
 */
@Slf4j
@Component
@AllArgsConstructor
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    // -------------------key相关操作---------------------

    /**
     * 查找匹配的key
     *
     * @param pattern 查询表达式
     *
     * @return Set key集合
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 删除key
     *
     * @param key key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     *
     * @param keys keys
     */
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 是否存在key
     *
     * @param key redis key
     *
     * @return Boolean 成功或者失败
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * setNx
     *
     * @param key     key
     * @param value   value
     * @param timeout timeout
     *
     * @return boolean
     */
    public boolean setNx(String key, String value, long timeout) {
        boolean b = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (b) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return b;
    }

    /**
     * runLua 执行lua脚本
     *
     * @author kalend.zhang
     * @date 17:48 2020/3/27
     * @param fileClasspath lua脚本Classpath 与 application.properties
     * @param returnType lua脚本返回类型
     * @param keys lua脚本需要操作的 redis key 合集
     * @param values lua脚本需要操作的value
     * @return java.lang.Object
     **/
    public <T> Object runLua(String fileClasspath, Class returnType, List keys, Object ... values) {
        DefaultRedisScript<T> redisScript =new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(fileClasspath)));
        redisScript.setResultType(returnType);
        return redisTemplate.execute(redisScript,keys,values);
    }


    /**
     * 批量写入redis
     * @param keys
     * @param values
     * @param timeout
     *
     * @return
     */
    public Boolean batchAdd(List keys, List values,Long timeout) {
        if(CollectionUtils.isEmpty(keys)){
            return false;
        }
        values.add(0,timeout);
        return (Boolean) runLua("/lua/batchAdd.lua", Boolean.class, keys, values.toArray());
    }

    /**
     * 批量查询redis
     * @param keys
     *
     * @return
     */
    public List batchGet(List keys) {
        if(CollectionUtils.isEmpty(keys)){
            return Collections.EMPTY_LIST;
        }
        return (List) runLua("/lua/batchGet.lua", List.class, keys);
    }

}
