# DataStructure - practice

2018下学年数据结构习题练习

<!-- TOC -->autoauto- [DataStructure - practice](#datastructure---practice)auto    - [说明](#说明)auto        - [chp21：实现对数组的循环左移](#chp21实现对数组的循环左移)auto        - [chp22：实现队列元素逆置（使用栈）【采用Java内部封装的栈和队列】](#chp22实现队列元素逆置使用栈采用java内部封装的栈和队列)auto        - [chp31：输出该链表中倒数第k个结点【自定义链表类】](#chp31输出该链表中倒数第k个结点自定义链表类)auto        - [chp32：线性链表的结点移动【自定义链表类】](#chp32线性链表的结点移动自定义链表类)auto        - [chp33：	创建链表](#chp33	创建链表)auto        - [chp41：利用三元组完成矩阵加法](#chp41利用三元组完成矩阵加法)auto        - [chp42：	数组主元素(2013考研题)](#chp42	数组主元素2013考研题)auto        - [chp43：产生n阶螺旋数字矩阵](#chp43产生n阶螺旋数字矩阵)auto        - [chp5：构造一棵huffman树](#chp5构造一棵huffman树)auto        - [chp8：快速排序](#chp8快速排序)autoauto<!-- /TOC -->

## 说明

### chp21：实现对数组的循环左移


> 【问题描述】设将n（n>1）个整数存放在一维数组R中。试设计一个在时间和空间两方面都尽可能高效的算法。将R中保存的序列循环左移P（P>0）个位置。
例如，假设P<n，将R中的数据（X0,X1,..Xn-1）循环左移P个位置后，变换为（Xp, XP+1,..Xn-1,X0,X1,...Xp-1）

> 【输入形式】循环移动的位数，数组中数据的个数，循环前的数组
【输出形式】循环后的数组

> 【样例输入】3 5 1 2 3 4 5
【样例输出】4 5 1 2 3

> 【样例说明】请大家注意，循环位移的位数可能超过数组中元素个数；输入与输出的数据均以空格分割，其中输入的数据中第一个是循环移位的位数，第二个是数组中数据的个数，后面的是数组中的数据。

### chp22：实现队列元素逆置（使用栈）【采用Java内部封装的栈和队列】

> 【问题描述】
已知Q是一个非空队列，S是一个空栈。仅使用少量工作变量以及对队列和栈的基本操作，编写一个算法，将队列Q中的所有元素逆置。

> 【输入形式】
输入的第一行为队列元素个数，第二行为队列从首至尾的元素
【输出形式】
输出队列的逆置

> 【样例输入】
3
1 2 3
> 【样例输出】
3 2 1

### chp31：输出该链表中倒数第k个结点【自定义链表类】

> 【问题描述】输入一个单向链表，输出该链表中倒数第k个结点，链表的最后一个结点是倒数第1个节点。

> 【输入形式】输入第一位为K值，其后接一串以空格分隔的整型值。
【输出形式】输出为倒数第K个结点的值，若无，则输出Not Found

> 【样例输入】3 13 45 54 32 1 4 98 2
【样例输出】4
【样例说明】K值为3，则输出链表倒数第3个结点的值，为4；数据输入间以空格隔开
【评分标准】本题要综合输出正确性及使用的数据结构。需由输入数据构建单链表。不使用链表的将不得分。

### chp32：线性链表的结点移动【自定义链表类】

> 【问题描述】
已知非空线性链表第1个链结点指针为list，链结点构造为
struct node{
    datatype data;
    node *link;
};
请写一算法，将该链表中数据域值最大的那个点移到链表的最后面。（假设链表中数据域值最大的链结点惟一）（注意：要求先写出算法的解题思路，然后再写出算法）
【输入形式】
输入为一个整数序列，整数之间以空格隔开，序列以回车结尾。
【输出形式】
输出为移动后的整数序列，整数之间以空格隔开，序列以回车结尾。
【样例输入】
3 12 4 9 5 1
【样例输出】
3 4 9 5 1 12
【样例说明】
将序列中最大的数字12移动到序列最后。
【评分标准】
本题必须采用链表来实现移动操作，其他方法不得分。

### chp33：	创建链表

> 【问题描述】提交与自己学号相邻的两位同学的学号与一门考试成绩，编程建立由这三组数据结点组成的简单链表。
【输入形式】三组同学的学号后三位，成绩
【输出形式】链表各节点的数据
【样例输入】201 98  202 94  203 89
【样例输出】
[num=201,score=98]
[num=202,score=94]
[num=203,score=89]
【样例说明】输入三组数据，创建一个单链表

### chp41：利用三元组完成矩阵加法

> 【问题描述】
以三元组表存贮的稀疏矩阵A，B 非零元个数分别为m 和n。试完成程序，完成A+B。
> 【输入形式】
第一排为分别为A B元素的个数，以下各排分别输入对应的三元组，头m组为A中的元素，接下来为B的元素，同一个矩阵的元素按照行递增排练，第一行规定为1，同一行的元素按照列递增排练，第一列规定为1
【输出形式】
为相应的三元组，以回车分开，如果结果全部为0，则输出 -1 -1 -1
>【样例输入】
2 1
1 2 3
1 3 4
1 3 3
【样例输出】
1 2 3
1 3 7
 
### chp42：	数组主元素(2013考研题)

> 【问题描述】
已知一个整数序列A长度为N其中若存在a且a的个数大于N/2则称为A的主元素
例如0 5 5 3 5 7 5 5 则为主元素 5
又如0 5 5 3 5 1 5 7则中没有主元素。
假设中的个元素保存在一个一维数组中，请设计一个尽可能高效的算法，找出的主元素。若存在主元素则输出该元素否则输出
【输入形式】
一个整数数组
【输出形式】
主元素
【样例输入】
0 5 5 3 5 7 5 5
【样例输出】
5
【样例说明】
长度为8，共有5个5，其个数大于N/2个，因此为主元素;

### chp43：产生n阶螺旋数字矩阵

> 【问题描述】
编写一个程序，对任意输入的正整数n(n不大于10)，产生并显示n阶螺旋式数字方阵。如n=3 要显示的方阵为
1 2 3
8 9 4
7 6 5
【输入形式】输入一个数n
【输出形式】产生n阶螺旋数字矩阵，数字以空格隔开
【样例输入】3
【样例输出】 
1 2 3
8 9 4
7 6 5
【样例说明】注意输出的数字以空格隔开

### chp5：构造一棵huffman树

### chp8：快速排序

> 【问题描述】对待排序序列使用快速排序算法进行排序，计算第一次划分之后分界元素在序列中的位置和最终排序结果（划分和分界元素的概念参照课本）（在序列中的位置跟书上一致，从1而不是从0开始）
【输入形式】序列元素个数，序列
【输出形式】第一次划分之后分界元素的位置，最终排序结果
【样例输入】5 0 2 1 -1 -2
【样例输出】3 -2 -1 0 1 2
【样例说明】序列中的元素均为整数