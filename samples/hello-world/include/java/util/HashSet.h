//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/util/HashSet.java
//
//  Created by rwl on 2/1/13.
//

@class JavaUtilHashMap;
@protocol JavaUtilCollection;
@protocol JavaUtilIterator;

#import "JreEmulation.h"
#import "java/io/Serializable.h"
#import "java/util/AbstractSet.h"
#import "java/util/Set.h"

#define JavaUtilHashSet_serialVersionUID -5024744406713321676

@interface JavaUtilHashSet : JavaUtilAbstractSet < JavaUtilSet, NSCopying, JavaIoSerializable > {
 @public
  JavaUtilHashSet *dummyKey_;
  JavaUtilHashMap *backingMap_;
}

@property (nonatomic, retain) JavaUtilHashSet *dummyKey;
@property (nonatomic, retain) JavaUtilHashMap *backingMap;

- (id)init;
- (id)initWithInt:(int)capacity;
- (id)initWithInt:(int)capacity
        withFloat:(float)loadFactor;
- (id)initWithJavaUtilCollection:(id<JavaUtilCollection>)collection;
- (id)initWithJavaUtilHashMap:(JavaUtilHashMap *)backingMap;
- (BOOL)addWithId:(id)object;
- (void)clear;
- (id)clone;
- (BOOL)containsWithId:(id)object;
- (BOOL)isEmpty;
- (id<JavaUtilIterator>)iterator;
- (BOOL)removeWithId:(id)object;
- (int)size;
- (JavaUtilHashMap *)createBackingMapWithInt:(int)capacity
                                   withFloat:(float)loadFactor;
- (id)copyWithZone:(NSZone *)zone;
@end