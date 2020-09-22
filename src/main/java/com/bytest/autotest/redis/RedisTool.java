package com.bytest.autotest.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <h3>tool</h3>
 * <p>缓存工具类</p>
 *
 * @author : hh
 * @date : 2020-03-22 02:28
 **/
@Service
public class RedisTool {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final long ONEMINUTE = 60;
    public static final long TENMINUTES = ONEMINUTE*10;
    public static final long ONEHOUR = ONEMINUTE*60;
    public static final long ONEDAY = ONEHOUR*24;



    /**
     *指定缓存失效时间
     * @param key
     * @param time 秒  一分钟60   一小时3600  一天 3600*24
     * @return boolean
     */
    public boolean setExpire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取过期
     * @param key
     * @return 秒 返回0 则用不过期
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断是否有这个key
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以是一个，也可以是多个
     */

    public void del(String... key){
        if(key!=null&&key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else {
               redisTemplate.delete(CollectionUtils.arrayToList(key));
            }

        }
    }

    /**
     * 存储String
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储key 并设置过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time){
        try{
            if (time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else {
                set(key,value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object get(String key){
        return key ==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 递增，value为整型的话实现加1，常用于给缓存增加数据用于秒杀活动
     * @param key
     * @param delta
     * @return
     */

    public long incr(String key,long delta){
        if (delta<0){
            throw new RuntimeException("递增因子需要大于0");
        }
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 递减
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key,long delta){
        if (delta<0){
            throw new RuntimeException("递增因子需要大于0");
        }
        return redisTemplate.opsForValue().increment(key,-delta);
    }

    /**
     * 获取一个hashmap，通过键和值获取
     * @param key
     * @param item
     * @return
     */
    public Object hget(String key,String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 通过key获取所有键值对
     * @param key
     * @return
     */
    public Map<String,String> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 存放一个map
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key,Map<String,String> map){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储map，并设置时间
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean hmset(String key,Map<String,Object> map,long time){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            if (time>0){
                setExpire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一个hash表中存储数据，如果没有就创建
     * @param key
     * @param item
     * @param value
     * @return
     */
    public boolean hset(String key,String item,Object value){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一个hash表存储数据，并设置时间
     * @param key
     * @param item
     * @param value
     * @param time
     * @return
     */
    public boolean hset(String key,String item,Object value,long time){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            if (time>0){
                setExpire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表内的数据
     * @param key
     * @param item
     */
    public void hdel(String key,Object... item){
        if (item.length==1){
            redisTemplate.opsForHash().delete(key,item);
        }else {
            for (Object child: item) {
                redisTemplate.opsForHash().delete(key,child);
            }
        }
    }

    /**
     * 判断hash表内是否存在入参数据
     * @param key
     * @param item
     * @return
     */
    public boolean hHasKey(String key,String item){
        return redisTemplate.opsForHash().hasKey(key,item);
    }


    /**
     * hash表递增
     * @param key
     * @param item
     * @param by
     * @return
     */
    public long hincr(String key,String item,long by){
        return redisTemplate.opsForHash().increment(key,item,by);
    }

    /**
     * hash表递减
     * @param key
     * @param item
     * @param by
     * @return
     */
    public long hdecr(String key,String item,long by){
        return redisTemplate.opsForHash().increment(key,item,-by);
    }

    /**
     * 获取set中所有值
     * @param key
     * @return
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断set是否存在
     * @param key
     * @param value
     * @return
     */
    public boolean sHasKey(String key,Object value){
        try {
            return redisTemplate.opsForSet().isMember(key,value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储set集合
     * @param key
     * @param objects
     * @return 成功个数
     */
    public long sSet(String key,Object... objects){
        try {
            return redisTemplate.opsForSet().add(key,objects);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 存储set集合，配置过期时间
     * @param key
     * @param time
     * @param objects
     * @return
     */
    public long sSet(String key, long time, Object... objects) {
        try {
            Long count = redisTemplate.opsForSet().add(key, objects);
            if (time > 0) {
                setExpire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set的长度
     * @param key
     * @return
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除set的值
     * @param key
     * @param objects
     * @return
     */
    public long sRemove(String key,Object... objects){
        try {
            return redisTemplate.opsForSet().remove(key,objects);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lGet(String key,long start,long end){
        try {
            return redisTemplate.opsForList().range(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list长度
     * @param key
     * @return
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据索引获取list
     * @param key
     * @param index
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key,index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 存储list
     * @param key
     * @param object
     * @return
     */
    public boolean lSet(String key,Object object){
        try {
            redisTemplate.opsForList().rightPush(key,object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 存储list并设置过期时间
     * @param key
     * @param object
     * @param time
     * @return
     */
    public boolean lSet(String key,Object object,long time){
        try {
            redisTemplate.opsForList().rightPush(key,object);
            if (time>0) {
                setExpire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 把所有list都存进缓存
     * @param key
     * @param list
     * @return
     */
    public boolean lSet(String key,List<Object> list){
        try {
            redisTemplate.opsForList().rightPushAll(key,list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean lSet(String key,List<Object> value,long time){
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            if (time>0){
                setExpire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新list
     * @param key
     * @param index
     * @param value
     * @return
     */
    public boolean lUpdateIndex(String key,long index,Object value){
        try {
            redisTemplate.opsForList().set(key,index,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value的list
     * @param key
     * @param count
     * @param value
     * @return
     */
    public long lRemove(String key,long count,Object value){
        try {
            long remove = redisTemplate.opsForList().remove(key,count,value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
