//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/util/Dictionary.java
//
//  Created by rwl on 2/1/13.
//

@protocol JavaUtilEnumeration;

#import "JreEmulation.h"

@interface JavaUtilDictionary : NSObject {
}

- (id)init;
- (id<JavaUtilEnumeration>)elements;
- (id)getWithId:(id)key;
- (BOOL)isEmpty;
- (id<JavaUtilEnumeration>)keys;
- (id)putWithId:(id)key
         withId:(id)value;
- (id)removeWithId:(id)key;
- (int)size;
@end