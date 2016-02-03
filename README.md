# unlimited works
## web service:
### run finatra service -
1. use sbt command in project root dictionary, input keys
2. >project webFinatra
3. >run
4. use localhost:9999/signin on browser test is it work.

### run playframwork -
1. sbt
2. >project webPlay
3. >run
4. use http://localhost:9000/signin on browser test is it work.

##设计理念
1. 可扩展性:将程序分不到任意多的计算机上,计算能力和资源成正相关
2. 独立性:相同层次的功能没有固定的入口点,每个同层的节点都可以相互替代
3. 网络作为基本的通讯单位,每个通讯单位只做一件事情(或者一件事的一个/多个可并行单位部分)