//package com.bytest.autotest.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * <h3>tool</h3>
// * <p>mongo工具类</p>
// *
// * @author : hh
// * @date : 2020-04-02 21:32
// **/
//@Component
//public class MongoTool {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**
//     * 判断集合是否存在
//     * @param name 集合名称
//     * @return 返回是否存在
//     */
//    public boolean createCollection(String name){
//        if(mongoTemplate.collectionExists(name)){
//            return true;
//        }else {
//            mongoTemplate.createCollection(name);
//            if(mongoTemplate.collectionExists(name)){
//                return true;
//            }else {
//                return false;
//            }
//        }
//    }
//
//    /**
//     * 判断集合是否存在
//     * @param name
//     * @return
//     */
//    public boolean isExits(String name){
//        return mongoTemplate.collectionExists(name);
//    }
//
//
//    /**
//     * 插入数据，插入数据集合
//     * @param collection
//     * @param name
//     */
//    public void add(Collection<?> collection,String name){
//        mongoTemplate.insert(collection,name);
//    }
//
//    /**
//     * 添加一个数据到collection里
//     * @param obj
//     */
//    public void addOne(Object obj,String tablename){
//        mongoTemplate.insert(obj, tablename);
//    }
//
//    /**
//     * 通过条件和数据类型删除数据
//     * @param query
//     * @param obj
//     * @param name
//     */
//    public void delete(Query query, Object obj, String name){
//        mongoTemplate.remove(query,obj.getClass(),name);
//    }
//
//    /**
//     * 根据参数类型删除所有数据
//     * @param obj
//     * @param name
//     */
//    public void deleteByType(Object obj, String name){
//        mongoTemplate.remove(obj,name);
//    }
//
//    /**
//     * 铜鼓查询删除数据
//     * @param query
//     * @param name
//     */
//    public void deleteByQuery(Query query, String name){
//        mongoTemplate.remove(query,name);
//    }
//
//    /**
//     * 通过条件更新数据
//     * @param query
//     * @param update
//     * @param obj
//     * @param name
//     */
//    public void update(Query query, Update update, Class<?> obj, String name){
//        mongoTemplate.updateMulti(query,update,obj,name);
//        //mongoTemplate.update(obj);
//
//    }
//
//    /**
//     * 获取指定结合下的所有数据
//     * @param obj
//     * @param name
//     * @return
//     */
//    public List<?> getAllByCollectionName(Object obj,String name){
//        return mongoTemplate.findAll(obj.getClass(),name);
//    }
//
//    /**
//     * 通过条件查询所有数据
//     * @param query
//     * @param obj
//     * @param name
//     * @return
//     */
//    public List<?> getConditionAndCollectionName(Query query, Class<?> obj, String name){
//        return mongoTemplate.find(query,obj,name);
//    }
//
//    public Object getData(Query query, Class<?> obj, String tablename){
//        return mongoTemplate.findOne(query,obj,tablename);
//    }
//
//
//
//
//}
