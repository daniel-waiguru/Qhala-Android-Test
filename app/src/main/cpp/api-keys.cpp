//
// Created by DanielWaiguru on 10/06/2021.
//
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

Java_tech_danielwaiguru_data_common_Constants_getApiKey(JNIEnv *env, jobject thiz) {
    std::string api_key = "7d533c39f66d4a212a1b3c81273ec7d1";
    return env->NewStringUTF(api_key.c_str());
}



