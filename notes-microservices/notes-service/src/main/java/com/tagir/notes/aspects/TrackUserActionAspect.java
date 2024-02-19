package com.tagir.notes.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class TrackUserActionAspect {

    /**
     * Создание аспекта логирования стартаи окончания методов с выводом информации о названии метода
     * и его параметрах, а также времени исполнения
     * @param joinPoint точка внедрения аспекта
     * @return объект аспекта
     * @throws Throwable выбрасывание объекта аспекта
     */

    @Around("@annotation(com.tagir.notes.aspects.TrackUserAction)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature() + " started");
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " finished");
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
