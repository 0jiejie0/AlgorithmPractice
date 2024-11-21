//给定一个文本文件 file.txt，请只打印这个文件中的第十行。 
//
// 示例: 
//
// 假设 file.txt 有如下内容： 
//
// Line 1
//Line 2
//Line 3
//Line 4
//Line 5
//Line 6
//Line 7
//Line 8
//Line 9
//Line 10
// 
//
// 你的脚本应当显示第十行： 
//
// Line 10
// 
//
// 说明: 1. 如果文件少于十行，你应当输出什么？ 2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。 
//
// Related Topics Shell 👍 143 👎 0


//There is no code of Java type for this problem

// head file.txt -n 10 | tail -n+10
// tail ...+10表示从第十行开始输出

//

/*
*
* # head file.txt -n 10 | tail -n+10

# tail -n +10 file.txt | head -1  # 这应该是比上一行更优的

# awk 'NR == 10' file.txt  # 之前没见过，没弄懂，下次再说吧

sed -n '10p' file.txt # 看懂了一点，比上边好点但还是没弄懂，没睡醒脑子一团浆糊困得很

*
* */
