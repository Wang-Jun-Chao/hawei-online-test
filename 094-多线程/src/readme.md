#题目描述

    问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
    接口说明：
    void init();  //初始化函数
    void Release(); //资源释放函数
    unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
    unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
    unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
    Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
    char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证

#输入描述:
    输入一个int整数


#输出描述:
    输出多个ABCD

#输入例子:
    10

#输出例子:
    ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD