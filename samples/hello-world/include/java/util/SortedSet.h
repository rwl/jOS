//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/util/SortedSet.java
//
//  Created by rwl on 2/1/13.
//

@protocol JavaUtilComparator;

#import "JreEmulation.h"
#import "java/util/Set.h"

@protocol JavaUtilSortedSet < JavaUtilSet, NSObject >
- (id<JavaUtilComparator>)comparator;
- (id)first;
- (id<JavaUtilSortedSet>)headSetWithId:(id)end;
- (id)last;
- (id<JavaUtilSortedSet>)subSetWithId:(id)start
                               withId:(id)end;
- (id<JavaUtilSortedSet>)tailSetWithId:(id)start;
@end
