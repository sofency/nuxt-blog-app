package com.sofency.top.nuxtblog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;  
import java.util.Date;  
  
public class MyMetaObjectHandler implements MetaObjectHandler {  
    @Override  
    public void insertFill(MetaObject metaObject) {  
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 假设你的字段名是 createTime
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 假设你的字段名是 createTime
        // 如果有其他字段需要自动填充，可以在这里继续添加  
    }  
  
    @Override  
    public void updateFill(MetaObject metaObject) {  
        // 更新时自动填充的逻辑（如果需要的话）
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 假设你的字段名是 createTime
    }  
}