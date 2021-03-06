# DataStructure

2018下学年数据结构实验

## 说明

### trial1：约瑟夫环的两种实现方式【采用了链表和数组两种方式】

> 编号1、2、…、n的n个人按顺时针方向围坐一圈，每人有一个正整数编号。从某个位置上的人开始报数，数到m的人便出列：下一个人（第m+1个）又从1数起，数到m的人便是第2个出列的人：依次重复下去，直到最后一个人出列，于是得到一个新的次序，试设计程序求出出列顺序。

### trial2：停车场管理【采用了JavaWeb实现简易停车场管理】

> 设停车场内只有一个可停放n辆汽车的狭长通道， 且只有一个大门可供汽车进出。汽车在停车场按车辆到达时的先后顺序，依次由北向南排列（大门在最南端，最先到达的第一辆   车停放在车场的最北端），若停车场内已停满 n 辆汽车，则后来的汽车只能在门外的便道上等候，一旦停车场内有车开走，则排在便道上的第一辆车即可开入。当停车场内某辆车要离开时，由于停车场是狭长的通道，在它之后开入车场必须先退出车场为它让路，待该辆车开出大门外后，为它让路的车辆再按原次序进入车场。在这里假设汽车不能从便道上开走。每辆停放在车场的车在它离开停车场时必须按它停留的时间长短缴纳费用。试为停车场编制按上述要求进行管理的模拟程序。要求：根据各结点的信息，调用相应的函数或者语句，将结点入栈或入队,出栈或者出队。

本实验采用JavaWeb实现简易停车场管理系统，以停车场栈和循环队列过道模拟数据库进行相关操作，通过Ajax和servlet进行前后端交互请求将停车场信息显示出来。

### trial3：二叉树遍历【采用链式存储结构，通过二叉链表实现】

> 建立一颗二叉树，并分别用前序、中序、后序遍历该二叉树。
运用二叉树的遍历算法，编写算法分别实现如下功能：
(1)	求出二叉树中的节点总数
(2)	求出二叉树中的叶子数目
(3)	求二叉树的深度
(4)	释放二叉树中的所有节点

### trial4：图的存储及遍历【采用链式存储结构，通过邻接表实现图的存储】

> 用邻接表建立一个图，并分别按广度优先和深度优先搜索算法遍历图中的每个顶点。
说明：（1）存储结构采用邻接表结构；
（2）分别用深度优先和广度优先搜索对图进行遍

### trial5：哈希表的设计【采用顺序存储结构，通过结构体（电话记录）数组来实现】

> 设计哈希表实现电话号码查询系统。要求实现以下功能：
(1)	哈希表中每个记录有下列数据项：电话号码、用户名、地址：
(2)	从键盘输入各记录，以电话号码为关键字建立哈希表（至少要有12个以上的记录，哈希表的长度为8）;
(3)	采用链地址法解决冲突；
(4)	显示建立好的哈希表，并在哈希表上查找、删除和插入给定关键字值的记录。
(5)	采用除留余数发进行哈希表的散列，即电话号码作为关键字，将电话号码的11位相加，按照模7取余；
