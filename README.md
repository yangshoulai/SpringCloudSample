# Spring Cloud Sample

基于 Spring Cloud & Nacos 的微服务项目演示 

## 开发环境搭建

* 下载 Nacos Docker
    ```bash
    git clone https://github.com/nacos-group/nacos-docker.git
    cd nacos-docker
    docker-compose -f example/standalone-mysql-8.yaml up
    ```

* 导入工程代码


* 编译
    ```bash
    mvn -X clean compile
    ```
* 启动  