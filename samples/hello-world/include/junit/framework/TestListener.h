//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/junit/build_result/java/junit/framework/TestListener.java
//
//  Created by rwl on 2/1/13.
//

@class JavaLangThrowable;
@class JunitFrameworkAssertionFailedError;
@protocol JunitFrameworkTest;

#import "JreEmulation.h"

@protocol JunitFrameworkTestListener < NSObject >
- (void)addErrorWithJunitFrameworkTest:(id<JunitFrameworkTest>)test
                 withJavaLangThrowable:(JavaLangThrowable *)t;
- (void)addFailureWithJunitFrameworkTest:(id<JunitFrameworkTest>)test
  withJunitFrameworkAssertionFailedError:(JunitFrameworkAssertionFailedError *)t;
- (void)endTestWithJunitFrameworkTest:(id<JunitFrameworkTest>)test;
- (void)startTestWithJunitFrameworkTest:(id<JunitFrameworkTest>)test;
@end