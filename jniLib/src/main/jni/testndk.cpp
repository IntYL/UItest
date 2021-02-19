//
// Created by leiyao6 on 2021/2/19.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_HelloC_helloFromC(
        JNIEnv* env,
jclass /* this */) {
std::string hello = "Hello from C++";
return env->NewStringUTF(hello.c_str());
}