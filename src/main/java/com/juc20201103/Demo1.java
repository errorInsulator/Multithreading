package com.juc20201103;

public class Demo1 {
    int number =0;

    /**
     * 0: aload_0   从局部变量0中装载引用类型值入栈。
     * 1: dup       复制栈顶一个字长的数据，将复制后的数据压栈。
     * 2: getfield   获取对象字段的值。   #2                  // Field number:I
     * 5: iconst_1   1(int)值入栈。
     * 6: iadd       将栈顶两int类型数相加，结果入栈。
     * 7: putfield   给对象字段赋值。   #2                  // Field number:I
     * 10: return    void函数返回。
     */
    public void print(){
        number++;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
