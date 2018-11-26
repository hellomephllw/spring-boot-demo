# spring-boot-demo
spring boot for rapid dev

## 依赖说明

### 需要依赖com.llw.express包: https://github.com/hellomephllw/java-project-express

## gradle任务

### generateBasicCode

执行后自动生成基础的service和dao

### generateTableDevCheck

执行后检查bean实体与数据库中的表，打印差异

### generateTableDevIncrement

执行后对bean实体和数据库中的表差异进行增量处理

### generateTableDevForce

执行后对bean实体和数据库中的表差异实行强制同步

### 注：dev、test、prod区分gradle任务执行的环境
