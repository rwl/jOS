//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/util/Collection.java
//
//  Created by rwl on 2/1/13.
//

@class IOSObjectArray;
@protocol JavaUtilIterator;

#import "JreEmulation.h"
#import "java/lang/Iterable.h"

@protocol JavaUtilCollection < JavaLangIterable, NSObject >
- (BOOL)addWithId:(id)object;
- (BOOL)addAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection;
- (void)clear;
- (BOOL)containsWithId:(id)object;
- (BOOL)containsAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection;
- (BOOL)isEmpty;
- (id<JavaUtilIterator>)iterator;
- (BOOL)removeWithId:(id)object;
- (BOOL)removeAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection;
- (BOOL)retainAllWithJavaUtilCollection:(id<JavaUtilCollection>)collection;
- (int)size;
- (IOSObjectArray *)toArray;
- (IOSObjectArray *)toArrayWithNSObjectArray:(IOSObjectArray *)array;
@end