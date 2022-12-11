#include <jni.h>
#include "com_ansen_jnitest_JNITest.h"
#ifdef __cplusplus  //最好有这个，否则被编译器改了函数名字找不到不要怪我
extern "C" {
#endif

JNIEXPORT jint JNICALL Java_com_ansen_jnitest_JNITest_plus
(JNIEnv * env, jclass cla, jint x, jint y)
{
    return x + y;
}


#ifdef __cplusplus
}
#endif