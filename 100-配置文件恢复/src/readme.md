#题目描述

    有6条配置命令，它们执行的结果分别是：
	命令					执行
    reset				reset what
    reset board			board fault
    board add			where to add
    board delet			no board at all
    reboot backplane	impossible
    backplane abort		install first
    he he				unkonw command

	注意：he he不是命令。
    为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
    1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，
        执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
    2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，
        但是该命令有两个关键词，所有匹配失败，执行结果为：unkown command
    3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。
        例如输入：r b，找到匹配命令reset board，执行结果为：board fault。
    4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。
        例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
    5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
    6、若匹配失败，打印“unkonw command”


#输入描述:
    多行字符串，每行字符串一条命令


#输出描述:
    执行结果，每条命令输出一行

#输入例子:
    reset
    reset board
    board add
    board delet
    reboot backplane
    backplane abort

#输出例子:
    reset what
    board fault
    where to add
    no board at all
    impossible
    install first