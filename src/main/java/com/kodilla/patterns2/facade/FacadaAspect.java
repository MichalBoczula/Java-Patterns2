package com.kodilla.patterns2.facade;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class FacadaAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadaAspect.class);

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.openOrder(..))"
            + "&& args(userId) && target(object)")
    public void logEventOpenOrder(Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: openOrder" + ", Args: " + userId);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.addItem(..))"
            + "&& args(orderId, productId, qty) && target(object)")
    public void logEventAddItem(long orderId, Long productId, double qty, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: addItem" + ", Args: " + orderId + " " + productId + " " + qty);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.removeItem(..))"
            + "&& args(orderId, productIdLong) && target(object)")
    public void logEventRemoveItem(Long orderId, Long productIdLong, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: removeItem" + ", Args: " + orderId + " " + productIdLong);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.calculateValue(..))"
            + "&& args(orderId) && target(object)")
    public void logEventCalculateValue(Long orderId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: calculateValue" + ", Args: " + orderId);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.doPayment(..))"
            + "&& args(orderId) && target(object)")
    public void logEventDoPayment(Long orderId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: doPayment" + ", Args: " + orderId);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.verifyOrder(..))"
            + "&& args(orderId) && target(object)")
    public void logEventVerifyOrder(Long orderId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: verifyOrder" + ", Args: " + orderId);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.submitOrder(..))"
            + "&& args(orderId) && target(object)")
    public void logEventSubmitOrder(Long orderId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: submitOrder" + ", Args: " + orderId);
    }

    @Before("execution(* com.kodilla.patterns2.shop.ShopService.cancelOrder(..))"
            + "&& args(orderId) && target(object)")
    public void logEventCancelOrder(Long orderId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + " method: cancelOrder" + ", Args: " + orderId);
    }

    @Around("execution(* com.kodilla.patterns2.shop.ShopService.openOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object timeConsumed;
        try {
            long startTime = System.currentTimeMillis();
            timeConsumed = proceedingJoinPoint.proceed();
            long finishTime = System.currentTimeMillis();
            LOGGER.info("Class: ShopService processed method openOrder in: " + (finishTime - startTime) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            return throwable;
        }
        return timeConsumed;
    }
}
