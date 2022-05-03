#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class LibraryIAPProduct, LibraryIAPProductNotification, LibraryKotlinEnumCompanion, LibraryKotlinEnum<E>, LibraryMessageType, LibraryKotlinArray<T>, LibraryTimestamp, SKProduct, LibraryIAPProductNotificationType, SKPaymentTransaction, LibraryIAPProductNotificationTypeCompanion, LibraryStoreKitSKPaymentTransactionState, LibraryIAPManager, LibraryIAPManagerErrorQueue, LibraryKotlinUnit, LibraryIAPManagerNotificationQueue, LibraryIAPManagerProductList, LibraryStoreKitSKPaymentTransactionStateCompanion, LibraryKotlinThrowable, LibraryKotlinException, LibraryKotlinRuntimeException, LibraryKotlinIllegalStateException;

@protocol LibraryKotlinComparable, LibraryKotlinIterator, LibraryKotlinCEnum;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface LibraryBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface LibraryBase (LibraryBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface LibraryMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface LibraryMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorLibraryKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface LibraryNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface LibraryByte : LibraryNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface LibraryUByte : LibraryNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface LibraryShort : LibraryNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface LibraryUShort : LibraryNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface LibraryInt : LibraryNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface LibraryUInt : LibraryNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface LibraryLong : LibraryNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface LibraryULong : LibraryNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface LibraryFloat : LibraryNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface LibraryDouble : LibraryNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface LibraryBoolean : LibraryNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("IAPStoreDelegate")))
@protocol LibraryIAPStoreDelegate
@required
- (void)didFailWithErrorError:(NSString *)error __attribute__((swift_name("didFailWithError(error:)")));
- (NSArray<LibraryIAPProduct *> *)getProductList __attribute__((swift_name("getProductList()")));
- (void)productListWasReceivedProducts:(NSArray<LibraryIAPProduct *> *)products __attribute__((swift_name("productListWasReceived(products:)")));
- (void)productNotificationWasReceivedNotification:(LibraryIAPProductNotification *)notification __attribute__((swift_name("productNotificationWasReceived(notification:)")));
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol LibraryKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface LibraryKotlinEnum<E> : LibraryBase <LibraryKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) LibraryKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageType")))
@interface LibraryMessageType : LibraryKotlinEnum<LibraryMessageType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) LibraryMessageType *message __attribute__((swift_name("message")));
@property (class, readonly) LibraryMessageType *warning __attribute__((swift_name("warning")));
@property (class, readonly) LibraryMessageType *error __attribute__((swift_name("error")));
+ (LibraryKotlinArray<LibraryMessageType *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *title __attribute__((swift_name("title")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Timestamp")))
@interface LibraryTimestamp : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)timestamp __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryTimestamp *shared __attribute__((swift_name("shared")));
- (NSString *)basicDatetimeNoMillis __attribute__((swift_name("basicDatetimeNoMillis()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPProduct")))
@interface LibraryIAPProduct : LibraryBase
- (instancetype)initWithSkProduct:(SKProduct *)skProduct __attribute__((swift_name("init(skProduct:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable localizedPrice __attribute__((swift_name("localizedPrice")));
@property (readonly) NSString *localizedTitle __attribute__((swift_name("localizedTitle")));
@property (readonly) NSString *price __attribute__((swift_name("price")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPProductNotification")))
@interface LibraryIAPProductNotification : LibraryBase
- (instancetype)initWithType:(LibraryIAPProductNotificationType *)type transaction:(SKPaymentTransaction * _Nullable)transaction error:(NSString * _Nullable)error __attribute__((swift_name("init(type:transaction:error:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithType:(LibraryIAPProductNotificationType *)type error:(NSString * _Nullable)error __attribute__((swift_name("init(type:error:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString * _Nullable error __attribute__((swift_name("error")));
@property (readonly) SKPaymentTransaction * _Nullable transaction __attribute__((swift_name("transaction")));
@property (readonly) LibraryIAPProductNotificationType *type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPProductNotificationType")))
@interface LibraryIAPProductNotificationType : LibraryKotlinEnum<LibraryIAPProductNotificationType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) LibraryIAPProductNotificationTypeCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) LibraryIAPProductNotificationType *productwaspurchased __attribute__((swift_name("productwaspurchased")));
@property (class, readonly) LibraryIAPProductNotificationType *productwasdeferred __attribute__((swift_name("productwasdeferred")));
@property (class, readonly) LibraryIAPProductNotificationType *productpurchasefailed __attribute__((swift_name("productpurchasefailed")));
@property (class, readonly) LibraryIAPProductNotificationType *productwasrestored __attribute__((swift_name("productwasrestored")));
@property (class, readonly) LibraryIAPProductNotificationType *productispurchasing __attribute__((swift_name("productispurchasing")));
+ (LibraryKotlinArray<LibraryIAPProductNotificationType *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPProductNotificationType.Companion")))
@interface LibraryIAPProductNotificationTypeCompanion : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryIAPProductNotificationTypeCompanion *shared __attribute__((swift_name("shared")));
- (LibraryIAPProductNotificationType *)fromSkPaymentTransactionStateState:(LibraryStoreKitSKPaymentTransactionState *)state __attribute__((swift_name("fromSkPaymentTransactionState(state:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPManager")))
@interface LibraryIAPManager : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)iAPManager __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryIAPManager *shared __attribute__((swift_name("shared")));
- (void)purchaseProductProduct:(LibraryIAPProduct *)product __attribute__((swift_name("purchaseProduct(product:)")));
- (void)refreshProductsIds:(NSSet<NSString *> *)ids callback:(void (^ _Nullable)(NSArray<LibraryIAPProduct *> *))callback __attribute__((swift_name("refreshProducts(ids:callback:)")));
- (void)refreshReceipt __attribute__((swift_name("refreshReceipt()")));
- (void)setPurchaseCompletedNotification:(LibraryIAPProductNotification *)notification __attribute__((swift_name("setPurchaseCompleted(notification:)")));
- (void)start __attribute__((swift_name("start()")));
@property (readonly) NSString * _Nullable receipt __attribute__((swift_name("receipt")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPManager.ErrorQueue")))
@interface LibraryIAPManagerErrorQueue : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)errorQueue __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryIAPManagerErrorQueue *shared __attribute__((swift_name("shared")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)observeOnReceive:(void (^)(NSString *))onReceive completionHandler:(void (^)(LibraryKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("observe(onReceive:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPManager.NotificationQueue")))
@interface LibraryIAPManagerNotificationQueue : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)notificationQueue __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryIAPManagerNotificationQueue *shared __attribute__((swift_name("shared")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)observeOnReceive:(void (^)(LibraryIAPProductNotification *))onReceive completionHandler:(void (^)(LibraryKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("observe(onReceive:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)postNotification:(LibraryIAPProductNotification *)notification completionHandler:(void (^)(LibraryKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("post(notification:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IAPManager.ProductList")))
@interface LibraryIAPManagerProductList : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)productList __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryIAPManagerProductList *shared __attribute__((swift_name("shared")));
- (NSArray<LibraryIAPProduct *> *)get __attribute__((swift_name("get()")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)observeOnReceive:(void (^)(NSArray<LibraryIAPProduct *> *))onReceive completionHandler:(void (^)(LibraryKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("observe(onReceive:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoggingKt")))
@interface LibraryLoggingKt : LibraryBase
+ (void)eObjcMsg:(NSString *)msg className:(NSString * _Nullable)className tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("eObjc(msg:className:tags:)")));
+ (void)mObjcMsg:(NSString *)msg className:(NSString * _Nullable)className tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("mObjc(msg:className:tags:)")));
+ (void)wObjcMsg:(NSString *)msg className:(NSString * _Nullable)className tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("wObjc(msg:className:tags:)")));
+ (void)writeToConsoleClassName:(NSString * _Nullable)className message:(NSString *)message type:(LibraryMessageType *)type tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("writeToConsole(className:message:type:tags:)")));
+ (void)e:(id _Nullable)receiver msg:(NSString *)msg tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("e(_:msg:tags:)")));
+ (void)m:(id _Nullable)receiver msg:(NSString *)msg tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("m(_:msg:tags:)")));
+ (void)w:(id _Nullable)receiver msg:(NSString *)msg tags:(NSDictionary<NSString *, NSString *> *)tags __attribute__((swift_name("w(_:msg:tags:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface LibraryKotlinEnumCompanion : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface LibraryKotlinArray<T> : LibraryBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(LibraryInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<LibraryKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("KotlinCEnum")))
@protocol LibraryKotlinCEnum
@required
@property (readonly) id value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StoreKitSKPaymentTransactionState")))
@interface LibraryStoreKitSKPaymentTransactionState : LibraryKotlinEnum<LibraryStoreKitSKPaymentTransactionState *> <LibraryKotlinCEnum>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) LibraryStoreKitSKPaymentTransactionStateCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) LibraryStoreKitSKPaymentTransactionState *skpaymenttransactionstatepurchasing __attribute__((swift_name("skpaymenttransactionstatepurchasing")));
@property (class, readonly) LibraryStoreKitSKPaymentTransactionState *skpaymenttransactionstatepurchased __attribute__((swift_name("skpaymenttransactionstatepurchased")));
@property (class, readonly) LibraryStoreKitSKPaymentTransactionState *skpaymenttransactionstatefailed __attribute__((swift_name("skpaymenttransactionstatefailed")));
@property (class, readonly) LibraryStoreKitSKPaymentTransactionState *skpaymenttransactionstaterestored __attribute__((swift_name("skpaymenttransactionstaterestored")));
@property (class, readonly) LibraryStoreKitSKPaymentTransactionState *skpaymenttransactionstatedeferred __attribute__((swift_name("skpaymenttransactionstatedeferred")));
+ (LibraryKotlinArray<LibraryStoreKitSKPaymentTransactionState *> *)values __attribute__((swift_name("values()")));
@property (readonly) LibraryLong *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface LibraryKotlinThrowable : LibraryBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (LibraryKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) LibraryKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface LibraryKotlinException : LibraryKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface LibraryKotlinRuntimeException : LibraryKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface LibraryKotlinIllegalStateException : LibraryKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface LibraryKotlinCancellationException : LibraryKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(LibraryKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface LibraryKotlinUnit : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol LibraryKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StoreKitSKPaymentTransactionState.Companion")))
@interface LibraryStoreKitSKPaymentTransactionStateCompanion : LibraryBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) LibraryStoreKitSKPaymentTransactionStateCompanion *shared __attribute__((swift_name("shared")));
- (LibraryStoreKitSKPaymentTransactionState *)byValueValue:(int64_t)value __attribute__((swift_name("byValue(value:)"))) __attribute__((deprecated("Will be removed.")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
